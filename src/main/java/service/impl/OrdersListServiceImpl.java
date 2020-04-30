package service.impl;

import entity.GoodsEntity;
import entity.OrdersListEntity;
import model.OrdersListDto;
import repository.GoodsRepository;
import repository.OrdersListRepository;
import service.OrdersListService;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import java.util.List;
import java.util.stream.Collectors;

@Stateless
public class OrdersListServiceImpl implements OrdersListService {

    @EJB
    GoodsRepository goodsRepository;

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
    public OrdersListDto createOrdersList(int orderNumber, int goodsId, int amount) {
        return entityToDto(createOrdersListEntity(orderNumber, goodsId, amount));
    }

    @Override
    public int createOrdersListAsId(int orderNumber, int goodsId, int amount) {
        return createOrdersListEntity(orderNumber, goodsId, amount).getId();
    }

    private OrdersListEntity createOrdersListEntity(int orderNumber, int goodsId, int amount) {
        GoodsEntity goodsEntity = goodsRepository.find(goodsId);

        OrdersListEntity ordersListEntity = new OrdersListEntity();
        ordersListEntity.setOrderNumber(orderNumber);
        ordersListEntity.setGoodsName(goodsEntity.getName());
        ordersListEntity.setPrice(goodsEntity.getPrice());
        ordersListEntity.setAmount(amount);
        ordersListEntity.setPriceSum(goodsEntity.getPrice() * amount);

        ordersListRepository.create(ordersListEntity);

        return ordersListEntity;
    }

    @Override
    public List<OrdersListDto> getOrdersList(int orderNumber) {
        List<OrdersListEntity> ordersListEntities = ordersListRepository.findAll(orderNumber);

        return ordersListEntities.stream()
                .map(this::entityToDto)
                .collect(Collectors.toList());
    }
}
