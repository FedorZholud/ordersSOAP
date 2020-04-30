package app;

import model.GoodsDto;
import model.OrdersListDto;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import java.util.List;

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
}
