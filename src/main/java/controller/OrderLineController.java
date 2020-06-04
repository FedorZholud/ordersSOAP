package controller;

import model.impl.OrderLineDto;

import java.util.List;

public interface OrderLineController {

    List<OrderLineDto> getOrderLineForOrder(long orderNumber, int page, int pageSize);

    OrderLineDto getOrderLine(long id);

    long createOrderLine(OrderLineDto orderLineDto);

    long updateOrderLine(OrderLineDto orderLineDto);

    long deleteOrderLine(OrderLineDto orderLineDto);
}
