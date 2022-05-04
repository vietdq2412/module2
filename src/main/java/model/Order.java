package model;

import java.io.Serializable;
import java.util.List;

public class Order implements Serializable {
    private int id;
    private Product product;
    private String status;

    public Order() {
    }

    public Order(int id, Product product, String status) {
        this.id = id;
        this.product = product;
        this.status = status;
    }

    public Order(Product product, String status) {
        this.product = product;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return String.format("|ID: %-5s|Status: %-10s|Product: %-20s|Price: %.0f", id,status,product.getName(),product.getPrice());
    }
}
