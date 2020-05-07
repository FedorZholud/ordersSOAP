package mapper.impl;

import entity.OrdersListEntity;
import mapper.Mapper;
import model.OrdersListDto;

import javax.ejb.Stateless;

@Stateless
public class OrdersListMapper implements Mapper<OrdersListEntity, OrdersListDto> {

    @Override
    public OrdersListDto entityToDto(OrdersListEntity entity) {
        return OrdersListDto.builder()
                .setId(entity.getId())
                .setOrderNumber(entity.getOrderNumber())
                .setGoodsName(entity.getGoodsName())
                .setPrice(entity.getPrice())
                .setAmount(entity.getAmount())
                .setPriceSum(entity.getPriceSum())
                .build();
    }
}
