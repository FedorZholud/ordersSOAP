package model.marshaling;

import model.impl.OrderDto;

import javax.xml.bind.annotation.adapters.XmlAdapter;
import java.text.SimpleDateFormat;

/**
 * @author Fedor Zholud
 *
 */

public class OrderDtoAdapter extends XmlAdapter<AdaptedOrderDto, OrderDto> {

    private SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    @Override
    public OrderDto unmarshal(AdaptedOrderDto adaptedOrderDto) throws Exception {
        return OrderDto.builder()
                .setOrderNumber(adaptedOrderDto.getOrderNumber())
                .setCustomer(adaptedOrderDto.getCustomer())
                .setOrderTime(dateFormat.parse(adaptedOrderDto.getOrderTime()))
                .setOrderList(adaptedOrderDto.getOrderList())
                .build();
    }

    @Override
    public AdaptedOrderDto marshal(OrderDto orderDto) throws Exception {
        AdaptedOrderDto adaptedOrderDto = new AdaptedOrderDto();
        adaptedOrderDto.setOrderNumber(orderDto.getOrderNumber());
        adaptedOrderDto.setCustomer(orderDto.getCustomer());
        adaptedOrderDto.setOrderTime(dateFormat.format(orderDto.getOrderTime()));
        adaptedOrderDto.setOrderList(orderDto.getOrderList());
        return adaptedOrderDto;
    }
}
