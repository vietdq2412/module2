package controller;

import model.Product;
import service.product.ProductService;
import view.ProductView;

import java.util.Map;
import java.util.Scanner;

public class ProductController {
    private ProductService productService = ProductService.getInstance();
    private static final ProductController instance = new ProductController();
    private ProductController(){}
    public static ProductController getInstance(){
        return instance;
    }

    Scanner scanner = new Scanner(System.in);
    ProductView productView = ProductView.getInstance();

    public void showProductView(){
        productView.showProductView();
    }

    public void showListProduct(){
        Map<String, Product> productMap = productService.getMapProduct();
        productView.showListProduct(productMap);
    }

    public void AddProduct(){
        Product newProduct = productView.addProductView();

        productService.add(newProduct);
        productView.showProductView();
    }

    public void detailProduct(int productId) {
        Product product = productService.findById(productId);
        productView.detailProduct(product);
    }
}
