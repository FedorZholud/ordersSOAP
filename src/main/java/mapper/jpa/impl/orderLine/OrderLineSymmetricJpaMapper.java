package mapper.jpa.impl.orderLine;

import entity.impl.OrderLineEntity;
import mapper.jpa.DtoToEntityJpaMapper;
import mapper.jpa.EntityToDtoJpaMapper;
import mapper.jpa.JpaSymmetricMapper;
import model.impl.OrderLineDto;
import org.hibernate.criterion.Order;

import javax.ejb.EJB;
import javax.ejb.Stateless;

@Stateless(name = "OrdersLineJpaSymmetricMapper", mappedName = "OrdersLineJpaSymmetricMapper")
public class OrderLineSymmetricJpaMapper implements JpaSymmetricMapper<OrderLineEntity, OrderLineDto> {

    @EJB(beanName = "OrderLineDtoToEntityJpaMapper")
    DtoToEntityJpaMapper<OrderLineEntity, OrderLineDto> orderLineDtoToEntityJpaMapper;

    @EJB(beanName = "OrderLineEntityToDtoJpaMapper")
    EntityToDtoJpaMapper<OrderLineEntity, OrderLineDto> orderLineEntityToDtoJpaMapper;

    @Override
    public OrderLineDto entityToDto(OrderLineEntity entity) {
        return orderLineEntityToDtoJpaMapper.entityToDto(entity);
    }

    @Override
    public OrderLineEntity dtoToEntity(OrderLineDto dto) {
        return orderLineDtoToEntityJpaMapper.dtoToEntity(dto);
    }
}
