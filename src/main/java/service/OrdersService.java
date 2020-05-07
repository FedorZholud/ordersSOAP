package service;

import model.OrdersDto;

/**
 * @author Fedor Zholud
 *
 */

public interface OrdersService {

    OrdersDto getOrder(int id);
}
