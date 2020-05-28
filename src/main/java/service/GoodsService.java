package service;

import model.impl.GoodsDto;

import java.util.List;

/**
 * @author Fedor Zholud
 *
 */

public interface GoodsService {

    List<GoodsDto> findAllGoods(int page, int pageSize);

    GoodsDto findGoodsById(long id);
}
