package service.impl;


import entity.impl.GoodsEntity;
import mapper.jpa.EntityToDtoJpaMapper;
import model.impl.GoodsDto;
import repository.impl.GoodsJpaRepository;
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
    GoodsJpaRepository goodsRepository;

    @EJB(beanName = "GoodsEntityToDtoJpaMapper")
    EntityToDtoJpaMapper<GoodsEntity, GoodsDto> goodsEntityToDtoJpaMapper;

    @Override
    public List<GoodsDto> getGoods() {
        List<GoodsEntity> goodsEntities = goodsRepository.findAll();

        return goodsEntities.stream()
                .map(goodsEntityToDtoJpaMapper::entityToDto)
                .collect(Collectors.toList());
    }

    @Override
    public GoodsDto getGoodsById(long id) {
        GoodsEntity goodsEntity = goodsRepository.find(id);

        return goodsEntityToDtoJpaMapper.entityToDto(goodsEntity);
    }
}