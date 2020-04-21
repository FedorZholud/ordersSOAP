package app;

import model.Goods;
import model.GoodsDto;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import java.util.List;

@WebService
@SOAPBinding(style = SOAPBinding.Style.DOCUMENT)
public interface OrdersSOAPService {

    @WebMethod
    List<Goods> getAllGoods();

    @WebMethod
    Goods getGoodsById(@WebParam(name = "id") int id);
}
