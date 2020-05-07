package service.impl;

import entity.OrdersEntity;
import model.OrdersDto;
import repository.impl.OrdersRepository;
import service.OrdersListService;
import service.OrdersService;

import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 * @author Fedor Zholud
 *
 */

@Stateless
public class OrdersServiceImpl implements OrdersService {

    @EJB
    OrdersRepository ordersRepository;

    @EJB
    OrdersListService ordersListService;

    private OrdersDto entityToDto(OrdersEntity ordersEntity) {
        return OrdersDto.builder()
                .setId(ordersEntity.getId())
                .setOrderNumber(ordersEntity.getOrderNumber())
                .setCustomer(ordersEntity.getCustomer())
                .setOrderTime(ordersEntity.getOrderTime())
                .setOrderList(ordersListService.getOrdersList(ordersEntity.getOrderNumber()))
                .build();
    }

    public OrdersDto getOrder(int id) {
        OrdersEntity ordersEntity = ordersRepository.find(id);
        return entityToDto(ordersEntity);
    }
}
