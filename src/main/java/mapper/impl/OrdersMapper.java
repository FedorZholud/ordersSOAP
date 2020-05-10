package mapper.impl;

import entity.OrdersEntity;
import mapper.Mapper;
import model.OrdersDto;
import service.OrdersListService;

import javax.ejb.EJB;
import javax.ejb.Stateless;

@Stateless
public class OrdersMapper implements Mapper<OrdersEntity, OrdersDto> {

    @EJB
    OrdersListService ordersListService;

    @Override
    public OrdersDto entityToDto(OrdersEntity entity) {
        return OrdersDto.builder()
                .setOrderNumber(entity.getOrderNumber())
                .setCustomer(entity.getCustomer())
                .setOrderTime(entity.getOrderTime())
                .setOrderList(ordersListService.getOrdersList((int) entity.getOrderNumber()))
                .build();
    }
}
