package service;

import model.AppUser;

import java.util.Map;

public interface IService<T> {
    void updateData();

    Map<String, T> findAll();
    public T add(T t);
    public void edit(T t);
    public boolean delete(String id);
}
