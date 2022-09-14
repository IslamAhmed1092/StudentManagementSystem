package system.database;


import java.util.List;

public interface ApiServices<T> {
    void add(T item);
    void remove(String id);
    void update(T item);
    T get(String id);
    List<T> getAll();
}
