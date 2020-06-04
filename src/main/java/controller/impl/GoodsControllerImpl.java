package controller.impl;

import controller.GoodsController;
import model.impl.GoodsDto;
import service.GoodsService;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import java.util.List;

@Stateless
public class GoodsControllerImpl implements GoodsController {

    @EJB
    GoodsService goodsService;

    @Override
    public List<GoodsDto> getAllGoods(int page, int pageSize) {
        return goodsService.findAllGoods(page, pageSize);
    }

    @Override
    public GoodsDto getGoodsById(long id) {
        return goodsService.findGoodsById(id);
    }
}
