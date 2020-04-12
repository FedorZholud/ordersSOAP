package controller;

import model.Goods;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import java.util.List;

@WebService
@SOAPBinding(style = SOAPBinding.Style.DOCUMENT)
public interface GoodsController {

    @WebMethod
    List<Goods> getAllGoods();

    @WebMethod
    Goods getGoodsById(int id);
}
