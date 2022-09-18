package database;


import exception.NotFoundException;

import java.util.List;

public interface ApiServices<T> {
    void add(T item);
    void remove(String id) throws NotFoundException;
    void update(T item) throws NotFoundException;
    T get(String id) throws NotFoundException;
    List<T> getAll();
}
