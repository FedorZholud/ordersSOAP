package app.impl;

import app.OrdersSOAPService;
import entity.OrdersListEntity;
import model.GoodsDto;
import model.OrdersListDto;
import service.GoodsService;
import service.OrdersListService;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.jws.WebService;
import java.util.List;

@Stateless
@WebService(endpointInterface = "app.OrdersSOAPService")
public class OrdersSOAPServiceImpl implements OrdersSOAPService {

    @EJB
    GoodsService goodsService;

    @EJB
    OrdersListService ordersListService;

    @Override
    public List<GoodsDto> getAllGoods() {
        return goodsService.getGoods();
    }

    @Override
    public GoodsDto getGoodsById(int id) {
        return goodsService.getGoodsById(id);
    }

    @Override
    public List<OrdersListDto> getOrdersList(int orderNumber) {
        return ordersListService.getOrdersList(orderNumber);
    }

    @Override
    public int createOrdersList(int orderNumber, int goodsId, int amount) {
        return ordersListService.createOrdersListAsId(orderNumber, goodsId, amount);
    }
}