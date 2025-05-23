//dao// ===============================
// DAO.java (Generic Interface)
// ===============================
package main.com.smartdoc.dao;

import java.util.List;

public interface DAO<T> {
    T get(int id);
    List<T> getAll();
    void save(T t);
    void update(T t);
    void delete(int id);
}
