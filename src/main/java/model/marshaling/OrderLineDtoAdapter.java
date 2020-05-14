package model.marshaling;

import model.impl.OrderLineDto;

/**
 * @author Fedor Zholud
 *
 */

import javax.xml.bind.annotation.adapters.XmlAdapter;

public class OrderLineDtoAdapter extends XmlAdapter<AdaptedOrderLineDto, OrderLineDto> {

    @Override
    public OrderLineDto unmarshal(AdaptedOrderLineDto adaptedOrderLineDto) throws Exception {
        return OrderLineDto.builder()
                .setId(adaptedOrderLineDto.getId())
                .setOrderNumber(adaptedOrderLineDto.getOrderNumber())
                .setGoodsId(adaptedOrderLineDto.getGoodsId())
                .setPrice(adaptedOrderLineDto.getPrice())
                .setAmount(adaptedOrderLineDto.getAmount())
                .setPriceSum(adaptedOrderLineDto.getPriceSum())
                .build();
    }

    @Override
    public AdaptedOrderLineDto marshal(OrderLineDto orderLineDto) throws Exception {
        AdaptedOrderLineDto adaptedOrderLineDto = new AdaptedOrderLineDto();
        adaptedOrderLineDto.setId(orderLineDto.getId());
        adaptedOrderLineDto.setOrderNumber(orderLineDto.getOrderNumber());
        adaptedOrderLineDto.setGoodsId(orderLineDto.getGoodsId());
        adaptedOrderLineDto.setPrice(orderLineDto.getPrice());
        adaptedOrderLineDto.setAmount(orderLineDto.getAmount());
        adaptedOrderLineDto.setPriceSum(orderLineDto.getPriceSum());
        return adaptedOrderLineDto;
    }
}
