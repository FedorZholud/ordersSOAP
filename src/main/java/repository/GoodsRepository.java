package repository;

import entity.GoodsEntity;

import java.io.Serializable;
import java.util.List;


public interface GoodsRepository {

    //create
    void create(GoodsEntity goods);

    //read
    GoodsEntity read(int id);

    //read all
    List<GoodsEntity> findAll();

    //update
    void update(GoodsEntity goods);

    //delete
    void delete(GoodsEntity goods);
}
