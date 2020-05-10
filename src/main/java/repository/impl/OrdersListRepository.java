package repository.impl;

import entity.OrdersListEntity;

import javax.ejb.Stateless;

/**
 * @author Fedor Zholud
 *
 */

@Stateless
public class OrdersListRepository extends AbstractRepository<OrdersListEntity> {

    public OrdersListRepository() {
        super(OrdersListEntity.class);
    }

}
