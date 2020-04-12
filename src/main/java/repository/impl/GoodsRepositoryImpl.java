package repository.impl;

import entity.GoodsEntity;
import repository.GoodsRepository;

import javax.ejb.Stateless;
import javax.persistence.*;
import java.util.List;


@Stateless
public class GoodsRepositoryImpl implements GoodsRepository {

    @PersistenceContext(name = "myUnit")
    private EntityManager em;

    public void create(GoodsEntity goods) {
        em.persist(goods);
    }

    public GoodsEntity read(int id) {
        GoodsEntity goods = em.find(GoodsEntity.class, id);
        return goods;
    }

    public List<GoodsEntity> findAll() {
        TypedQuery<GoodsEntity> query = em.createQuery("select g from GoodsEntity g", GoodsEntity.class);
        List<GoodsEntity> goodsList = query.getResultList();
        return goodsList;
    }

    public void update(GoodsEntity goods) {
        em.merge(goods);
    }

    public void delete(GoodsEntity goods) {
        em.remove(goods);
    }
}