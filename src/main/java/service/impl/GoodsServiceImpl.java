package service.impl;


import entity.GoodsEntity;
import mapper.Mapper;
import mapper.impl.GoodsMapper;
import model.GoodsDto;
import repository.GoodsRepository;
import repository.impl.GoodsRepositoryImpl;
import service.GoodsService;

import javax.annotation.ManagedBean;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.inject.Singleton;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Fedor Zholud
 *
 */

@Stateless
public class GoodsServiceImpl implements GoodsService {

    @EJB
    GoodsRepositoryImpl goodsRepository;

    //@EJB
    GoodsMapper goodsMapper = new GoodsMapper();

    @Override
    public List<GoodsDto> getGoods() {
        List<GoodsEntity> goodsEntities = goodsRepository.findAll();

        return goodsEntities.stream()
                .map(goodsEntity -> goodsMapper.entityToDto(goodsEntity))
                .collect(Collectors.toList());
    }

    @Override
    public GoodsDto getGoodsById(int id) {
        GoodsEntity goodsEntity = goodsRepository.find(id);

        return goodsMapper.entityToDto(goodsEntity);
    }
}