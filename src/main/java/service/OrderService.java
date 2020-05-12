package service;

import model.impl.OrderDto;

import java.util.List;

/**
 * @author Fedor Zholud
 *
 */

public interface OrderService {

    OrderDto getOrder(long orderNumber);

    long createOrderAsId(String customer);

    OrderDto createOrder(String customer);

    List<OrderDto> getAllOrders();
}
