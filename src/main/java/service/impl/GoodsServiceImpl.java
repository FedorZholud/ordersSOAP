package service.impl;


import entity.GoodsEntity;
import model.GoodsDto;
import repository.GoodsRepository;
import service.GoodsService;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import java.util.List;
import java.util.stream.Collectors;

@Stateless
public class GoodsServiceImpl implements GoodsService {

    @EJB
    GoodsRepository goodsRepository;

    private GoodsDto entityToDto(GoodsEntity goodsEntity) {
        return GoodsDto.builder()
                .setId(goodsEntity.getId())
                .setName(goodsEntity.getName())
                .setPrice(goodsEntity.getPrice())
                .build();
    }

    @Override
    public List<GoodsDto> getGoods() {
        List<GoodsEntity> goodsEntities = goodsRepository.findAll();

        return goodsEntities.stream()
                .map(this::entityToDto)
                .collect(Collectors.toList());
    }

    @Override
    public GoodsDto getGoodsById(int id) {
        GoodsEntity goodsEntity = goodsRepository.find(id);

        return entityToDto(goodsEntity);
    }
}