package service.impl;


import entity.GoodsEntity;
import mapper.Mapper;
import model.GoodsDto;
import repository.impl.GoodsRepository;
import service.GoodsService;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Fedor Zholud
 *
 */

@Stateless
public class GoodsServiceImpl implements GoodsService {

    @EJB
    GoodsRepository goodsRepository;

    @EJB(beanName = "GoodsMapper")
    Mapper<GoodsEntity, GoodsDto> goodsMapper;

    @Override
    public List<GoodsDto> getGoods() {
        List<GoodsEntity> goodsEntities = goodsRepository.findAll();

        return goodsEntities.stream()
                .map(goodsEntity -> goodsMapper.entityToDto(goodsEntity))
                .collect(Collectors.toList());
    }

    @Override
    public GoodsDto getGoodsById(long id) {
        GoodsEntity goodsEntity = goodsRepository.find(id);

        return goodsMapper.entityToDto(goodsEntity);
    }
}