package app.impl;

import app.OrdersSOAPService;
import model.GoodsDto;
import model.OrdersDto;
import model.OrdersListDto;
import service.GoodsService;
import service.OrdersListService;
import service.OrdersService;

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

    @EJB
    OrdersService ordersService;

    @Override
    public List<GoodsDto> getAllGoods() {
        return goodsService.getGoods();
    }

    @Override
    public GoodsDto getGoodsById(long id) {
        return goodsService.getGoodsById(id);
    }

    @Override
    public List<OrdersListDto> getOrdersList(long orderNumber) {
        return ordersListService.getOrdersList(orderNumber);
    }

    @Override
    public long createOrdersList(long orderNumber, long goodsId, int amount) {
        return ordersListService.createOrdersListAsId(orderNumber, goodsId, amount);
    }

    @Override
    public long updateOrdersList(long ordersListId, int amount) {
        return ordersListService.updateOrdersList(ordersListId, amount);
    }

    @Override
    public long deleteOrdersList(long id) {
        return ordersListService.deleteOrdersList(id);
    }

    @Override
    public OrdersDto getOrder(long orderNumber) {
        return ordersService.getOrder(orderNumber);
    }

    @Override
    public long createOrder(String customer) {
        return ordersService.createOrderAsId(customer);
    }
}