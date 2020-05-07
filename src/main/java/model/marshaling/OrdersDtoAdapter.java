package model.marshaling;

import model.OrdersDto;

import javax.xml.bind.annotation.adapters.XmlAdapter;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;

/**
 * @author Fedor Zholud
 *
 */

public class OrdersDtoAdapter extends XmlAdapter<AdaptedOrdersDto, OrdersDto> {

    private SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    @Override
    public OrdersDto unmarshal(AdaptedOrdersDto adaptedOrdersDto) throws Exception {
        return OrdersDto.builder()
                .setId(adaptedOrdersDto.getId())
                .setOrderNumber(adaptedOrdersDto.getOrderNumber())
                .setCustomer(adaptedOrdersDto.getCustomer())
                .setOrderTime((Timestamp) dateFormat.parse(adaptedOrdersDto.getOrderTime()))
                .setOrderList(adaptedOrdersDto.getOrderList())
                .build();
    }

    @Override
    public AdaptedOrdersDto marshal(OrdersDto ordersDto) throws Exception {
        AdaptedOrdersDto adaptedOrdersDto = new AdaptedOrdersDto();
        adaptedOrdersDto.setId(ordersDto.getId());
        adaptedOrdersDto.setOrderNumber(ordersDto.getOrderNumber());
        adaptedOrdersDto.setCustomer(ordersDto.getCustomer());
        adaptedOrdersDto.setOrderTime(dateFormat.format(ordersDto.getOrderTime()));
        adaptedOrdersDto.setOrderList(ordersDto.getOrderList());
        return adaptedOrdersDto;
    }
}
