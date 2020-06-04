package mapper.jpa.impl.orderLine;

import entity.impl.GoodsEntity;
import entity.impl.OrderLineEntity;
import mapper.jpa.DtoToEntityJpaMapper;
import mapper.jpa.EntityToDtoJpaMapper;
import model.impl.OrderLineDto;
import repository.impl.GoodsJpaRepository;

import javax.ejb.EJB;
import javax.ejb.Stateless;

@Stateless(name = "OrderLineDtoToEntityJpaMapper")
public class OrderLineDtoToEntityJpaMapper implements DtoToEntityJpaMapper<OrderLineEntity, OrderLineDto> {

    @EJB
    GoodsJpaRepository goodsJpaRepository;

    @Override
    public OrderLineEntity dtoToEntity(OrderLineDto dto) {
        GoodsEntity goodsEntity = goodsJpaRepository.find(dto.getGoodsId());

        OrderLineEntity orderLineEntity = new OrderLineEntity();
        orderLineEntity.setOrderNumber(dto.getOrderNumber());
        orderLineEntity.setGoodsId(goodsEntity.getId());
        orderLineEntity.setAmount(dto.getAmount());
        orderLineEntity.setPrice(goodsEntity.getPrice());
        orderLineEntity.setPriceSum(goodsEntity.getPrice() * dto.getAmount());

        return orderLineEntity;
    }
}
