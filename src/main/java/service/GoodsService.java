package service;

import model.impl.GoodsDto;

import java.util.List;

/**
 * @author Fedor Zholud
 *
 */

public interface GoodsService {

    List<GoodsDto> getGoods();

    GoodsDto getGoodsById(long id);
}
