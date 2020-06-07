package controller;

import model.impl.OrderDto;

import java.util.List;

public interface OrderController {

    OrderDto getOrder(long orderNumber);

    long createOrder(String customer);

    List<OrderDto> getAllOrders(int page, int pageSize);

    long deleteOrder(long orderNumber);

    long updateOrder(OrderDto orderDto);
}
