package service;


import entity.GoodsEntity;
import model.GoodsDto;
import repository.GoodsRepository;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import java.util.ArrayList;
import java.util.List;

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
        List<GoodsDto> goodsDtoList = new ArrayList<GoodsDto>();

        for (GoodsEntity goodsEntity: goodsEntities) {
            GoodsDto goodsDto = entityToDto(goodsEntity);

            goodsDtoList.add(goodsDto);
        }

        return goodsDtoList;

//        return goodsEntities.stream()
//                .map(goodsEntity -> entityToDto(goodsEntity));
    }

    public GoodsDto getGoodsById(int id) {
        GoodsEntity goodsEntity = goodsRepository.read(id);

        return entityToDto(goodsEntity);
    }
}