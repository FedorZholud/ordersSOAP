package service;

import entity.impl.OrderLineEntity;
import model.impl.OrderLineDto;

import java.util.List;

/**
 * @author Fedor Zholud
 *
 */

public interface OrderLineService {

    OrderLineDto createOrderLine(long orderNumber, long goodsId, int amount);

    long createOrderLineAsId(long orderNumber, long goodsId, int amount);

    long createOrderLineAsId(OrderLineDto orderLineDto);

    List<OrderLineDto> getOrderLine(long orderNumber);

    long deleteOrderLine(long id);

    long updateOrderLine(long id, int amount);

}
