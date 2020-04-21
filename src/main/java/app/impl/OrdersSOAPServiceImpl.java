package app.impl;

import app.OrdersSOAPService;
import model.GoodsDto;
import service.GoodsService;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.jws.WebService;
import java.util.List;

@Stateless
@WebService(endpointInterface = "app.OrdersSOAPService")
public class OrdersSOAPServiceImpl implements OrdersSOAPService {

    @EJB
    GoodsService goodsService;

    public List<GoodsDto> getAllGoods() {
        return goodsService.getGoods();
    }

    public GoodsDto getGoodsById(int id) {
        return goodsService.getGoodsById(id);
    }
}
