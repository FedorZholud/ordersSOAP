package repository.impl;

import entity.OrdersListEntity;
import repository.OrdersListRepository;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

/**
 * @author Fedor Zholud
 *
 */

@Stateless
public class OrdersListRepositoryImpl extends RepositoryAbstract<OrdersListEntity> {

    OrdersListRepositoryImpl() {
        super(OrdersListEntity.class);
    }

//    @PersistenceContext(name = "myUnit")
//    private EntityManager em;
//
//    @Override
//    public OrdersListEntity create(OrdersListEntity ordersList) {
//        em.persist(ordersList);
//
//        return ordersList;
//    }
//
//    @Override
//    public OrdersListEntity find(int id) {
//        OrdersListEntity ordersList = em.find(OrdersListEntity.class, id);
//        return ordersList;
//    }
//
//    @Override
//    public List<OrdersListEntity> findAll(int orderNumber) {
//        TypedQuery<OrdersListEntity> query = em.createNamedQuery("entity.OrdersListEntity.findAll", OrdersListEntity.class).setParameter("orderNumber", orderNumber);
//        List<OrdersListEntity> ordersList = query.getResultList();
//        return ordersList;
//    }
//
//    @Override
//    public void update(OrdersListEntity ordersList) {
//        em.merge(ordersList);
//    }
//
//    @Override
//    public void delete(OrdersListEntity ordersList) {
//        em.remove(ordersList);
//    }
}
