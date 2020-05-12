package repository.impl;

import entity.impl.OrderLineEntity;
import repository.AbstractJpaRepository;

import javax.ejb.Stateless;

/**
 * @author Fedor Zholud
 *
 */

@Stateless
public class OrderLineJpaRepository extends AbstractJpaRepository<OrderLineEntity> {

    public OrderLineJpaRepository() {
        super(OrderLineEntity.class);
    }

}
