package service.impl;

import entity.OrdersListEntity;
import model.OrdersListDto;
import repository.OrdersListRepository;
import service.OrdersListService;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import java.util.List;
import java.util.stream.Collectors;

@Stateless
public class OrdersListServiceImpl implements OrdersListService {

    @EJB
    OrdersListRepository ordersListRepository;

    private OrdersListDto entityToDto(OrdersListEntity ordersListEntity) {
        return OrdersListDto.builder()
                .setId(ordersListEntity.getId())
                .setOrderNumber(ordersListEntity.getOrderNumber())
                .setGoodsName(ordersListEntity.getGoodsName())
                .setPrice(ordersListEntity.getPrice())
                .setAmount(ordersListEntity.getAmount())
                .setPriceSum(ordersListEntity.getPriceSum())
                .build();
    }

    @Override
    public void createOrdersList(OrdersListEntity ordersList) {
        ordersListRepository.create(ordersList);
    }

    @Override
    public List<OrdersListDto> getOrdersList() {
        List<OrdersListEntity> ordersListEntities = ordersListRepository.findAll();

        return ordersListEntities.stream()
                .map(this::entityToDto)
                .collect(Collectors.toList());
    }
}
