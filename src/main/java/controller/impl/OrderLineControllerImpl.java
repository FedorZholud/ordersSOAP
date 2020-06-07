package controller.impl;

import controller.OrderLineController;
import model.impl.OrderLineDto;
import service.OrderLineService;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import java.util.List;

@Stateless
public class OrderLineControllerImpl implements OrderLineController {

    @EJB
    OrderLineService orderLineService;

    @Override
    public List<OrderLineDto> getOrderLineForOrder(long orderNumber, int page, int pageSize) {
        return orderLineService.getOrderLineForOrder(orderNumber, page, pageSize);
    }

    @Override
    public OrderLineDto getOrderLine(long id) {
        return orderLineService.getOrderLine(id);
    }

    @Override
    public long createOrderLine(OrderLineDto orderLineDto) {
        return orderLineService.createOrderLineAsId(orderLineDto);
    }

    @Override
    public long updateOrderLine(OrderLineDto orderLineDto) {
        return orderLineService.updateOrderLine(orderLineDto);
    }

    @Override
    public long deleteOrderLine(OrderLineDto orderLineDto) {
        return orderLineService.deleteOrderLine(orderLineDto);
    }
}
