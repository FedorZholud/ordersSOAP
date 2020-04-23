package service;

import entity.OrdersListEntity;
import model.OrdersListDto;

import java.util.List;

public interface OrdersListService {

    void createOrdersList(OrdersListEntity ordersList);

    List<OrdersListDto> getOrdersList();

}
