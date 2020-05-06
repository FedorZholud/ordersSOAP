package app;

import model.GoodsDto;
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
    GoodsDto getGoodsById(@WebParam(name = "id") int id);

    @WebMethod
    List<OrdersListDto> getOrdersList(@WebParam(name = "orderNumber") int orderNumber);

    @WebMethod
    @WebResult(name = "ordersListId") int createOrdersList(
            @WebParam(name = "orderNumber") int orderNumber,
            @WebParam(name = "goodsId") int goodsId,
            @WebParam(name = "amount") int amount);

    @WebMethod
    @WebResult(name = "ordersListId") int updateOrdersList(
            @WebParam(name = "ordersListId") int ordersListId,
            @WebParam(name = "amount") int amount);

    @WebMethod
    @WebResult(name = "ordersListId") int deleteOrdersList(@WebParam(name = "ordersListId") int id);
}
