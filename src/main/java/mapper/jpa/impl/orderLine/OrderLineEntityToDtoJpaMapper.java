package mapper.jpa.impl.orderLine;

import entity.impl.OrderEntity;
import entity.impl.OrderLineEntity;
import mapper.jpa.EntityToDtoJpaMapper;
import model.impl.OrderDto;
import model.impl.OrderLineDto;

import javax.ejb.EJB;
import javax.ejb.Stateless;

@Stateless(name = "OrderLineEntityToDtoJpaMapper")
public class OrderLineEntityToDtoJpaMapper implements EntityToDtoJpaMapper<OrderLineEntity, OrderLineDto> {

    @EJB(beanName = "OrderEntityToDtoJpaMapper")
    EntityToDtoJpaMapper<OrderEntity, OrderDto> orderEntityToDtoJpaMapper;

    @Override
    public OrderLineDto entityToDto(OrderLineEntity entity) {
        return OrderLineDto.builder()
                .setId(entity.getId())
                .setOrderNumber(entity.getOrderNumber())
                .setGoodsId(entity.getGoodsId())
                .setPrice(entity.getPrice())
                .setAmount(entity.getAmount())
                .setPriceSum(entity.getPriceSum())
                .build();
    }
}
