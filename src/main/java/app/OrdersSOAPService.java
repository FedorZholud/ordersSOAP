package app;

import model.GoodsDto;
import model.OrdersDto;
import model.OrdersListDto;

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
    List<OrdersListDto> getOrdersList(@WebParam(name = "orderNumber") long orderNumber);

    @WebMethod
    @WebResult(name = "ordersListId") long createOrdersList(
            @WebParam(name = "orderNumber") long orderNumber,
            @WebParam(name = "goodsId") long goodsId,
            @WebParam(name = "amount") int amount);

    @WebMethod
    @WebResult(name = "ordersListId") long updateOrdersList(
            @WebParam(name = "ordersListId") long ordersListId,
            @WebParam(name = "amount") int amount);

    @WebMethod
    @WebResult(name = "ordersListId") long deleteOrdersList(@WebParam(name = "ordersListId") long id);

    @WebMethod
    OrdersDto getOrder(@WebParam(name = "orderNumber") long orderNumber);

    @WebMethod
    @WebResult(name = "orderNumber") long createOrder(@WebParam(name = "customer") String customer);
}
