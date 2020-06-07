package controller.impl;

import controller.OrderController;
import model.impl.OrderDto;
import service.OrderService;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import java.util.List;

@Stateless
public class OrderControllerImpl implements OrderController {

    @EJB
    OrderService orderService;

    @Override
    public OrderDto getOrder(long orderNumber) {
        return orderService.getOrder(orderNumber);
    }

    @Override
    public long createOrder(String customer) {
        return orderService.createOrderAsId(customer);
    }

    @Override
    public List<OrderDto> getAllOrders(int page, int pageSize) {
        return orderService.getAllOrders(page, pageSize);
    }

    @Override
    public long deleteOrder(long orderNumber) {
        return orderService.deleteOrder(orderNumber);
    }

    @Override
    public long updateOrder(OrderDto orderDto) {
        return orderService.updateOrder(orderDto);
    }
}
