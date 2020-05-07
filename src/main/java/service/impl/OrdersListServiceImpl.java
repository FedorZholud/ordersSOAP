package service.impl;

import entity.GoodsEntity;
import entity.OrdersListEntity;
import mapper.impl.OrdersListMapper;
import model.OrdersListDto;
import repository.GoodsRepository;
import repository.OrdersListRepository;
import repository.impl.GoodsRepositoryImpl;
import repository.impl.OrdersListRepositoryImpl;
import service.OrdersListService;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Fedor Zholud
 *
 */

@Stateless
public class OrdersListServiceImpl implements OrdersListService {

    @EJB
    GoodsRepositoryImpl goodsRepository;

    @EJB
    OrdersListRepositoryImpl ordersListRepository;

    //@EJB
    OrdersListMapper ordersListMapper = new OrdersListMapper();

    @Override
    public OrdersListDto createOrdersList(int orderNumber, int goodsId, int amount) {
        return ordersListMapper.entityToDto(createOrdersListEntity(orderNumber, goodsId, amount));
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
                .map(ordersListEntity -> ordersListMapper.entityToDto(ordersListEntity))
                .collect(Collectors.toList());
    }

    @Override
    public int deleteOrdersList(int id) {
        OrdersListEntity ordersListEntity = ordersListRepository.find(id);
        ordersListRepository.delete(ordersListEntity);

        return ordersListEntity.getId();
    }

    @Override
    public int updateOrdersList(int id, int amount) {
        OrdersListEntity ordersListEntity = ordersListRepository.find(id);
        ordersListEntity.setAmount(amount);
        ordersListEntity.setPriceSum(ordersListEntity.getPrice() * amount);

        ordersListRepository.update(ordersListEntity);

        return ordersListEntity.getId();
    }

}
