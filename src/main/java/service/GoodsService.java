package service;

import entity.GoodsEntity;
import model.GoodsDto;

import java.util.List;

/**
 * @author Fedor Zholud
 *
 */

public interface GoodsService {

    List<GoodsDto> getGoods();

    GoodsDto getGoodsById(int id);
}
