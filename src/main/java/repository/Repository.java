package repository;

import entity.BaseEntity;
import entity.GoodsEntity;

import java.util.List;

public interface Repository<T> {

    //create
    void create(T entity);

    //find
    T find(int id);

    //find all
    List<T> findAll();

    //find all with parameter
    List<T> findAll(int param);

    //update
    void update(T entity);

    //delete
    void delete(T entity);
}
