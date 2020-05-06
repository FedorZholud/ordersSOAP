package repository.impl;

import entity.GoodsEntity;
import repository.GoodsRepository;

import javax.ejb.Stateless;
import javax.persistence.*;
import java.util.List;

/**
 * @author Fedor Zholud
 *
 */

@Stateless
public class GoodsRepositoryImpl extends RepositoryAbstract<GoodsEntity> {

    public GoodsRepositoryImpl() {
        super(GoodsEntity.class);
    }


//
//    @PersistenceContext(name = "myUnit")
//    private EntityManager em;
//
//    @Override
//    public void create(GoodsEntity goods) {
//        em.persist(goods);
//    }
//
//    @Override
//    public GoodsEntity find(int id) {
//        GoodsEntity goods = em.find(GoodsEntity.class, id);
//        return goods;
//    }
//
//    @Override
//    public List<GoodsEntity> findAll() {
//        TypedQuery<GoodsEntity> query = em.createNamedQuery("entity.GoodsEntity.findAll", GoodsEntity.class);
//        List<GoodsEntity> goodsList = query.getResultList();
//        return goodsList;
//    }
//
//    @Override
//    public void update(GoodsEntity goods) {
//        em.merge(goods);
//    }
//
//    @Override
//    public void delete(GoodsEntity goods) {
//        em.remove(goods);
//    }
}