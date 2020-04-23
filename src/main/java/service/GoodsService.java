package service;


import entity.GoodsEntity;
import model.GoodsDto;
import repository.GoodsRepository;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import java.util.List;
import java.util.stream.Collectors;

@Stateless
public class GoodsService {

    @EJB
    GoodsRepository goodsRepository;

    private GoodsDto entityToDto(GoodsEntity goodsEntity) {
        return GoodsDto.builder()
                .setId(goodsEntity.getId())
                .setName(goodsEntity.getName())
                .setPrice(goodsEntity.getPrice())
                .build();
    }

    public List<GoodsDto> getGoods() {
        List<GoodsEntity> goodsEntities = goodsRepository.findAll();

        return goodsEntities.stream()
                .map(this::entityToDto)
                .collect(Collectors.toList());
    }

    public GoodsDto getGoodsById(int id) {
        GoodsEntity goodsEntity = goodsRepository.read(id);

        return entityToDto(goodsEntity);
    }
}