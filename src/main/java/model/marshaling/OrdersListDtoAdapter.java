package model.marshaling;

import model.OrdersListDto;

/**
 * @author Fedor Zholud
 *
 */

import javax.xml.bind.annotation.adapters.XmlAdapter;

public class OrdersListDtoAdapter extends XmlAdapter<AdaptedOrdersListDto, OrdersListDto> {

    @Override
    public OrdersListDto unmarshal(AdaptedOrdersListDto adaptedOrdersListDto) throws Exception {
        return OrdersListDto.builder()
                .setId(adaptedOrdersListDto.getId())
                .setOrderNumber(adaptedOrdersListDto.getOrderNumber())
                .setGoodsName(adaptedOrdersListDto.getGoodsName())
                .setPrice(adaptedOrdersListDto.getPrice())
                .setAmount(adaptedOrdersListDto.getAmount())
                .setPriceSum(adaptedOrdersListDto.getPriceSum())
                .build();
    }

    @Override
    public AdaptedOrdersListDto marshal(OrdersListDto ordersListDto) throws Exception {
        AdaptedOrdersListDto adaptedOrdersListDto = new AdaptedOrdersListDto();
        adaptedOrdersListDto.setId(ordersListDto.getId());
        adaptedOrdersListDto.setOrderNumber(ordersListDto.getOrderNumber());
        adaptedOrdersListDto.setGoodsName(ordersListDto.getGoodsName());
        adaptedOrdersListDto.setPrice(ordersListDto.getPrice());
        adaptedOrdersListDto.setAmount(ordersListDto.getAmount());
        adaptedOrdersListDto.setPriceSum(ordersListDto.getPriceSum());
        return adaptedOrdersListDto;
    }
}
