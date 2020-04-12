package controller.impl;

import controller.GoodsController;
import model.Goods;
import service.GoodsService;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.jws.WebService;
import java.util.List;

@Stateless
@WebService(endpointInterface = "controller.GoodsController")
public class GoodsControllerImpl implements GoodsController {

    @EJB
    GoodsService goodsService;

    public List<Goods> getAllGoods() {
        return goodsService.getGoods();
    }

    public Goods getGoodsById(int id) {
        return goodsService.getGoodsById(id);
    }
}
