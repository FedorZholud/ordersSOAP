package service;

import model.impl.GoodsDto;

import java.util.List;

/**
 * @author Fedor Zholud
 *
 */

public interface GoodsService {

    List<GoodsDto> findAllGoods();

    GoodsDto findGoodsById(long id);
}
