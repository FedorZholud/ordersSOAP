package app.impl;

import app.OrdersSOAPService;
import model.impl.GoodsDto;
import model.impl.OrderDto;
import model.impl.OrderLineDto;
import service.GoodsService;
import service.OrderLineService;
import service.OrderService;

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
    OrderLineService orderLineService;

    @EJB
    OrderService orderService;

    @Override
    public List<GoodsDto> getAllGoods() {
        return goodsService.findAllGoods();
    }

    @Override
    public GoodsDto getGoodsById(long id) {
        return goodsService.findGoodsById(id);
    }

    @Override
    public List<OrderLineDto> getOrderLine(long orderNumber) {
        return orderLineService.getOrderLine(orderNumber);
    }

    @Override
    public long createOrderLine(OrderLineDto orderLineDto) {
        return orderLineService.createOrderLineAsId(orderLineDto);
    }

//    @Override
//    public long updateOrderLine(long orderLineId, int amount) {
//        return orderLineService.updateOrderLine(orderLineId, amount);
//    }


    @Override
    public long updateOrderLine(OrderLineDto orderLineDto) {
        return orderLineService.updateOrderLine(orderLineDto);
    }

//    @Override
//    public long deleteOrderLine(long id) {
//        return orderLineService.deleteOrderLine(id);
//    }


    @Override
    public long deleteOrderLine(OrderLineDto orderLineDto) {
        return orderLineService.deleteOrderLine(orderLineDto);
    }

    @Override
    public OrderDto getOrder(long orderNumber) {
        return orderService.getOrder(orderNumber);
    }

    @Override
    public long createOrder(String customer) {
        return orderService.createOrderAsId(customer);
    }

    @Override
    public List<OrderDto> getAllOrders() {
        return orderService.getAllOrders();
    }

    @Override
    public long deleteOrder(long orderNumber) {
        return orderService.deleteOrder(orderNumber);
    }

    @Override
    public long updateOrder(OrderDto orderDto) {
        return orderService.update(orderDto);
    }
}