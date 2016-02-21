package dao;

import java.util.List;

/**
 * Created by 1 on 04.02.2016.
 */
public interface IDao<T> {
    void insert(T obj);

    void update(T obj);

    List<T> getAll();

    T findById(int id);

    boolean delete(T obj);

}
