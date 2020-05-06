package app.impl;

import app.OrdersSOAPService;
import model.GoodsDto;
import model.OrdersListDto;
import service.GoodsService;
import service.OrdersListService;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.jws.WebService;
import java.util.List;

/**
 * @author Fedor Zholud
 *
 */

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

    @Override
    public int updateOrdersList(int ordersListId, int amount) {
        return ordersListService.updateOrdersList(ordersListId, amount);
    }

    @Override
    public int deleteOrdersList(int id) {
        return ordersListService.deleteOrdersList(id);
    }
}