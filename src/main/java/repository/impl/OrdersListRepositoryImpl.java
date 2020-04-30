package repository.impl;

import entity.OrdersListEntity;
import repository.OrdersListRepository;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Stateless
public class OrdersListRepositoryImpl implements OrdersListRepository {

    @PersistenceContext(name = "myUnit")
    private EntityManager em;

    @Override
    public OrdersListEntity create(OrdersListEntity ordersList) {
        em.persist(ordersList);

        return ordersList;
    }

    @Override
    public OrdersListEntity find(int id) {
        OrdersListEntity ordersList = em.find(OrdersListEntity.class, id);
        return ordersList;
    }

    @Override
    public List<OrdersListEntity> findAll(int orderNumber) {
        TypedQuery<OrdersListEntity> query = em.createQuery("select o from OrdersListEntity o where o.orderNumber = :orderNumber", OrdersListEntity.class).setParameter("orderNumber", orderNumber);
        List<OrdersListEntity> ordersList = query.getResultList();
        return ordersList;
    }

    @Override
    public void update(OrdersListEntity ordersList) {
        em.merge(ordersList);
    }

    @Override
    public void delete(OrdersListEntity ordersList) {
        em.remove(ordersList);
    }
}
