package app;

import model.impl.GoodsDto;
import model.impl.OrderDto;
import model.impl.OrderLineDto;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import java.util.List;

/**
 * @author Fedor Zholud
 *
 */

@WebService
@SOAPBinding(style = SOAPBinding.Style.DOCUMENT)
public interface OrdersSOAPService {

    @WebMethod
    List<GoodsDto> getAllGoods();

    @WebMethod
    GoodsDto getGoodsById(@WebParam(name = "id") long id);

    @WebMethod
    List<OrderLineDto> getOrderLine(@WebParam(name = "orderNumber") long orderNumber);

    @WebMethod
    @WebResult(name = "orderLineId") long createOrderLine(@WebParam(name = "orderLine") OrderLineDto orderLineDto);

//    @WebMethod
//    @WebResult(name = "orderLineId") long createOrderLine(
//            @WebParam(name = "orderNumber") long orderNumber,
//            @WebParam(name = "goodsId") long goodsId,
//            @WebParam(name = "amount") int amount);

//    @WebMethod
//    @WebResult(name = "orderLineId") long updateOrderLine(
//            @WebParam(name = "orderLineId") long orderLineId,
//            @WebParam(name = "amount") int amount);

    @WebMethod
    @WebResult(name = "orderLineId") long updateOrderLine(@WebParam(name = "orderLine") OrderLineDto orderLineDto);

//    @WebMethod
//    @WebResult(name = "orderLineId") long deleteOrderLine(@WebParam(name = "orderLineId") long id);

    @WebMethod
    @WebResult(name = "orderLineId") long deleteOrderLine(@WebParam(name = "orderLine") OrderLineDto orderLineDto);

    @WebMethod
    OrderDto getOrder(@WebParam(name = "orderNumber") long orderNumber);

    @WebMethod
    @WebResult(name = "orderNumber") long createOrder(@WebParam(name = "customer") String customer);

    @WebMethod
    List<OrderDto> getAllOrders();

    @WebMethod
    @WebResult(name = "orderNumber") long deleteOrder(@WebParam(name = "orderNumber") long orderNumber);
}
