package repository.impl;

import entity.impl.OrderEntity;
import repository.AbstractJpaRepository;

import javax.ejb.Stateless;

/**
 * @author Fedor Zholud
 *
 */

@Stateless
public class OrderJpaRepository extends AbstractJpaRepository<OrderEntity> {

    public OrderJpaRepository() {
        super(OrderEntity.class);
    }

}
