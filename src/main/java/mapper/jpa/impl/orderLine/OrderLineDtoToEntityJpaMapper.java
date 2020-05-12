package mapper.jpa.impl.orderLine;

import entity.impl.OrderLineEntity;
import mapper.jpa.DtoToEntityJpaMapper;
import mapper.jpa.EntityToDtoJpaMapper;
import model.impl.OrderLineDto;

import javax.ejb.Stateless;

@Stateless(name = "OrderLineDtoToEntityJpaMapper")
public class OrderLineDtoToEntityJpaMapper implements DtoToEntityJpaMapper<OrderLineEntity, OrderLineDto> {

    //TODO need implement
    @Override
    public OrderLineEntity dtoToEntity(OrderLineDto dto) {
        throw new RuntimeException("not yet implemented");
    }
}
