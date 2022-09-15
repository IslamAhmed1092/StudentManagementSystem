package database;
// This class name as common used as repository
// And all of its implementations suffexed with Impl
// Excellent  good work my bro

import java.util.List;

public interface ApiServices<T> {
    void add(T item);
    void remove(String id);
    void update(T item);
    T get(String id);
    List<T> getAll();
}
