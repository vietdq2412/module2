package service.product;

import file_data_IO.FileIO;
import model.Category;
import model.Product;

import java.util.HashMap;
import java.util.Map;

public class ProductService implements IProductService {
    private int lastId = 0;
    private final String PRODUCT_DATA_PATH = "product_data.txt";
    private Map<String, Product> mapProduct;
    private static final ProductService instance = new ProductService();
    FileIO<Product> fileIO = (FileIO<Product>) FileIO.getInstance();


    private ProductService() {
        mapProduct = findAll();
        this.updateLastId();
    }

    public static ProductService getInstance() {
        return instance;
    }

    @Override
    public void updateData() {
        fileIO.writeFile(PRODUCT_DATA_PATH, mapProduct);
    }

    @Override
    public Map<String, Product> findAll() {
        if (fileIO.checkFile(PRODUCT_DATA_PATH)) {
            return fileIO.readFile(PRODUCT_DATA_PATH);
        } else {
            System.out.println("Product data empty!");
            return new HashMap<>();
        }
    }

    public void updateLastId(){
        if (this.mapProduct.isEmpty()){
            this.mapProduct.put("id", new Product(0,"id", "id", 1));
            this.lastId = 0;
        }else {
            this.lastId = mapProduct.get("id").getId();
        }
    }

    @Override
    public Product add(Product product) {
        this.lastId++;
        product.setId(getLastId());
        mapProduct.put(String.valueOf(getLastId()), product);

        mapProduct.get("id").setId(this.lastId);
        updateData();
        return product;
    }

    @Override
    public void edit(Product product) {

    }

    @Override
    public boolean delete(String id) {
        return false;
    }
    public int getLastId() {
        return lastId;
    }

    public Map<String, Product> getMapProduct() {
        return mapProduct;
    }

    @Override
    public Product findById(int productId) {
        return mapProduct.get(String.valueOf(productId));
    }
}
