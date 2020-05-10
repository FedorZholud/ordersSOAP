package service;

import entity.OrdersListEntity;
import model.OrdersListDto;

import java.util.List;

/**
 * @author Fedor Zholud
 *
 */

public interface OrdersListService {

    OrdersListDto createOrdersList(long orderNumber, long goodsId, int amount);

    long createOrdersListAsId(long orderNumber, long goodsId, int amount);

    List<OrdersListDto> getOrdersList(long orderNumber);

    long deleteOrdersList(long id);

    long updateOrdersList(long id, int amount);

}
