package mapper.jpa.impl.order;

import entity.impl.GoodsEntity;
import entity.impl.OrderEntity;
import entity.impl.OrderLineEntity;
import mapper.jpa.EntityToDtoJpaMapper;
import model.impl.OrderDto;
import model.impl.OrderLineDto;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import java.util.List;
import java.util.stream.Collectors;

@Stateless(name = "OrderEntityToDtoJpaMapper")
public class OrderEntityToDtoJpaMapper implements EntityToDtoJpaMapper<OrderEntity, OrderDto> {

    @EJB(beanName = "OrderLineEntityToDtoJpaMapper")
    EntityToDtoJpaMapper<OrderLineEntity, OrderLineDto> orderLineEntityToDtoJpaMapper;

    @Override
    public OrderDto entityToDto(OrderEntity entity) {
        List<OrderLineDto> orderLineDto = entity.getOrdersListEntities().stream()
                .map(orderLineEntityToDtoJpaMapper::entityToDto)
                .collect(Collectors.toList());

        return OrderDto.builder()
                .setOrderNumber(entity.getOrderNumber())
                .setCustomer(entity.getCustomer())
                .setOrderTime(entity.getOrderTime())
                .setOrderList(orderLineDto)
                .build();
    }
}
