package controller;

import model.impl.GoodsDto;

import java.util.List;

public interface GoodsController {

    List<GoodsDto> getAllGoods(int page, int pageSize);

    GoodsDto getGoodsById(long id);
}
