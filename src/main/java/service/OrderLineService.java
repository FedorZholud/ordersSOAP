package service;

import entity.impl.OrderLineEntity;
import model.impl.OrderLineDto;

import java.util.List;

/**
 * @author Fedor Zholud
 *
 */

public interface OrderLineService {

//    OrderLineDto createOrderLine(long orderNumber, long goodsId, int amount);
//
//    long createOrderLineAsId(long orderNumber, long goodsId, int amount);

    long createOrderLineAsId(OrderLineDto orderLineDto);

    OrderLineDto createOrderLine(OrderLineDto orderLineDto);

    List<OrderLineDto> getOrderLine(long orderNumber, int page, int pageSize);

//    long deleteOrderLine(long id);

    long deleteOrderLine(OrderLineDto orderLineDto);

//    long updateOrderLine(long id, int amount);

    long updateOrderLine(OrderLineDto orderLineDto);

}
