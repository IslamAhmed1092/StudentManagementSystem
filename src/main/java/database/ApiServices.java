package database;
// This class name as common used as repository
// And all of its implementations suffexed with Impl
// Excellent  good work my bro

import exception.NotFoundException;

import java.util.List;

public interface ApiServices<T> {
    void add(T item);
    void remove(String id) throws NotFoundException;
    void update(T item) throws NotFoundException;
    T get(String id) throws NotFoundException;
    List<T> getAll();
}
