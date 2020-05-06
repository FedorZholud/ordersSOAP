package service;

import entity.OrdersListEntity;
import model.OrdersListDto;

import java.util.List;

/**
 * @author Fedor Zholud
 *
 */

public interface OrdersListService {

    OrdersListDto createOrdersList(int orderNumber, int goodsId, int amount);

    int createOrdersListAsId(int orderNumber, int goodsId, int amount);

    List<OrdersListDto> getOrdersList(int orderNumber);

    int deleteOrdersList(int id);

    int updateOrdersList(int id, int amount);

}
