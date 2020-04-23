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

    @Override
    public void create(GoodsEntity goods) {
        em.persist(goods);
    }

    @Override
    public GoodsEntity read(int id) {
        GoodsEntity goods = em.find(GoodsEntity.class, id);
        return goods;
    }

    @Override
    public List<GoodsEntity> findAll() {
        TypedQuery<GoodsEntity> query = em.createQuery("select g from GoodsEntity g", GoodsEntity.class);
        List<GoodsEntity> goodsList = query.getResultList();
        return goodsList;
    }

    @Override
    public void update(GoodsEntity goods) {
        em.merge(goods);
    }

    @Override
    public void delete(GoodsEntity goods) {
        em.remove(goods);
    }
}