package repository;

import entity.BaseEntity;
import entity.GoodsEntity;

import java.util.List;

/**
 * @author Fedor Zholud
 *
 */

public interface Repository<T extends BaseEntity> {

    //create
    void create(T entity);

    //find
    T find(long id);

    //find all
    List<T> findAll();

    //find all with parameter
    List<T> findAll(long param);

    //update
    void update(T entity);

    //delete
    void delete(T entity);
}
