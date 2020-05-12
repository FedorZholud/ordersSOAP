package repository;

import entity.Entity;

import java.util.List;

public interface Repository<T extends Entity> {

    /**
     * create
     * @param entity object for create
     */
    void create(T entity);

    /**
     * find entity by id
     * @param id id from object
     * @return entity
     */
    T find(long id);

    /**
     * find all entities in table
     * @return List of entities
     */
    List<T> findAll();

    /**
     * find all entities by param
     * @param param parameter for search
     * @return List of entities
     */
    List<T> findAll(long param);

    /**
     * update
     * @param entity object for update
     */
    void update(T entity);

    /**
     * hard delete
     * @param entity object for hard delete
     */
    void delete(T entity);
}
