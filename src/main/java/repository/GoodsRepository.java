package repository;

import entity.GoodsEntity;

import java.util.List;


/**
 * @author Fedor Zholud
 *
 */

public interface GoodsRepository {

    //create
    void create(GoodsEntity goods);

    //read
    GoodsEntity find(int id);

    //read all
    List<GoodsEntity> findAll();

    //update
    void update(GoodsEntity goods);

    //delete
    void delete(GoodsEntity goods);
}
