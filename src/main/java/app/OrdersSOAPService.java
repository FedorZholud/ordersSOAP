package app;

import model.GoodsDto;
import model.OrdersListDto;

import javax.jws.WebMethod;
import javax.jws.WebParam;
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
    List<OrdersListDto> getOrdersList();
}
