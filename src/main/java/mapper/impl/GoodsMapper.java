package mapper.impl;

import entity.GoodsEntity;
import mapper.Mapper;
import model.GoodsDto;

import javax.ejb.Stateless;

@Stateless(name = "GoodsMapper")
public class GoodsMapper implements Mapper<GoodsEntity, GoodsDto> {

    @Override
    public GoodsDto entityToDto(GoodsEntity entity) {
        return GoodsDto.builder()
                .setId(entity.getId())
                .setName(entity.getName())
                .setPrice(entity.getPrice())
                .build();
    }
}
