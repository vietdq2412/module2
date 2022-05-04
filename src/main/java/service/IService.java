package service;

import model.Product;

import java.util.Map;

public interface IService<T> {
    void updateData();

    Map<String, T> findAll();
    public T add(T t);
    public void edit(T t);
    public T delete(String id);
}
