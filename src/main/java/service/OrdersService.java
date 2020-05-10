package service;

import model.OrdersDto;

/**
 * @author Fedor Zholud
 *
 */

public interface OrdersService {

    OrdersDto getOrder(long orderNumber);

    long createOrderAsId(String customer);

    OrdersDto createOrder(String customer);
}
