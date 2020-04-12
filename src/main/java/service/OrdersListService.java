package service;

import entity.OrdersListEntity;
import repository.OrdersListRepository;

import javax.ejb.EJB;
import javax.ejb.Stateless;

@Stateless
public class OrdersListService {

    @EJB
    OrdersListRepository ordersListRepository;

    public void createOrdersList(OrdersListEntity ordersList) {
        ordersListRepository.create(ordersList);
    }
}
