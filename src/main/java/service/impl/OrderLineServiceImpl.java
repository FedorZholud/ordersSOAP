package service.impl;

import entity.impl.GoodsEntity;
import entity.impl.OrderLineEntity;
import mapper.jpa.EntityToDtoJpaMapper;
import mapper.jpa.JpaSymmetricMapper;
import model.impl.OrderLineDto;
import repository.impl.GoodsJpaRepository;
import repository.impl.OrderLineJpaRepository;
import service.OrderLineService;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Fedor Zholud
 *
 */

@Stateless
public class OrderLineServiceImpl implements OrderLineService {

    @EJB
    GoodsJpaRepository goodsRepository;

    @EJB
    OrderLineJpaRepository ordersListRepository;

    @EJB(beanName = "OrdersLineJpaSymmetricMapper")
    JpaSymmetricMapper<OrderLineEntity, OrderLineDto> orderLineDtoJpaSymmetricMapper;

    @Override
    public OrderLineDto createOrderLine(long orderNumber, long goodsId, int amount) {
        return orderLineDtoJpaSymmetricMapper.entityToDto(createOrdersListEntity(orderNumber, goodsId, amount));
    }

    @Override
    public long createOrderLineAsId(long orderNumber, long goodsId, int amount) {
        return createOrdersListEntity(orderNumber, goodsId, amount).getId();
    }

    @Override
    public long createOrderLineAsId(OrderLineDto orderList) {
        OrderLineEntity orderLineEntity = orderLineDtoJpaSymmetricMapper.dtoToEntity(orderList);
        ordersListRepository.create(orderLineEntity);
        return orderLineEntity.getId();
    }

    private OrderLineEntity createOrdersListEntity(long orderNumber, long goodsId, int amount) {
        GoodsEntity goodsEntity = goodsRepository.find(goodsId);

        OrderLineEntity orderLineEntity = new OrderLineEntity();
        orderLineEntity.setOrderNumber(orderNumber);
        orderLineEntity.setGoodsName(goodsEntity.getName());
        orderLineEntity.setPrice(goodsEntity.getPrice());
        orderLineEntity.setAmount(amount);
        orderLineEntity.setPriceSum(goodsEntity.getPrice() * amount);

        ordersListRepository.create(orderLineEntity);

        return orderLineEntity;
    }

    @Override
    public List<OrderLineDto> getOrderLine(long orderNumber) {
        List<OrderLineEntity> ordersListEntities = ordersListRepository.findAll(orderNumber);

        return ordersListEntities.stream()
                .map(orderLineDtoJpaSymmetricMapper::entityToDto)
                .collect(Collectors.toList());
    }

    @Override
    public long deleteOrderLine(long id) {
        OrderLineEntity orderLineEntity = ordersListRepository.find(id);
        ordersListRepository.delete(orderLineEntity);

        return orderLineEntity.getId();
    }

    @Override
    public long updateOrderLine(long id, int amount) {
        OrderLineEntity orderLineEntity = ordersListRepository.find(id);
        orderLineEntity.setAmount(amount);
        orderLineEntity.setPriceSum(orderLineEntity.getPrice() * amount);

        ordersListRepository.update(orderLineEntity);

        return orderLineEntity.getId();
    }

}
