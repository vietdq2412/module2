package service.product;

import model.Product;
import service.IService;

import java.util.Map;

public interface IProductService extends IService<Product> {
    Product findById(int productId);
}
