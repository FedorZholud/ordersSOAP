package repository.impl;

import entity.OrdersEntity;

import javax.ejb.Stateless;

/**
 * @author Fedor Zholud
 *
 */

@Stateless
public class OrdersRepository extends AbstractRepository<OrdersEntity>{

    public OrdersRepository() {
        super(OrdersEntity.class);
    }

}
