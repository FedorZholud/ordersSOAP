package service.impl;


import entity.impl.GoodsEntity;
import mapper.jpa.EntityToDtoJpaMapper;
import model.impl.GoodsDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import repository.impl.GoodsJpaRepository;
import service.GoodsService;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Fedor Zholud
 *
 */

@Stateless
public class GoodsServiceImpl implements GoodsService {

    static final Logger logger =
            LoggerFactory.getLogger(GoodsServiceImpl.class);

    @EJB
    GoodsJpaRepository goodsRepository;

    @EJB(beanName = "GoodsEntityToDtoJpaMapper")
    EntityToDtoJpaMapper<GoodsEntity, GoodsDto> goodsEntityToDtoJpaMapper;

    @Override
    @Transactional
    public List<GoodsDto> findAllGoods(int page, int pageSize) {
        List<GoodsEntity> goodsEntities = goodsRepository.findAll(page, pageSize);

        return goodsEntities.stream()
                .peek(goodsEntity -> logger.info(goodsEntity.toString()))
                .map(goodsEntityToDtoJpaMapper::entityToDto)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional
    public GoodsDto findGoodsById(long id) {
        GoodsEntity goodsEntity = goodsRepository.find(id);
        logger.info(goodsEntity.toString());

        return goodsEntityToDtoJpaMapper.entityToDto(goodsEntity);
    }
}