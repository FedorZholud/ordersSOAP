package service;

import entity.GoodsEntity;
import model.GoodsDto;

import java.util.List;

public interface GoodsService {

    List<GoodsDto> getGoods();

    GoodsDto getGoodsById(int id);
}
