package mapper.jpa.impl.goods;

import entity.impl.GoodsEntity;
import mapper.jpa.EntityToDtoJpaMapper;
import model.impl.GoodsDto;

import javax.ejb.Stateless;

@Stateless(name = "GoodsEntityToDtoJpaMapper")
public class GoodsEntityToDtoJpaMapper implements EntityToDtoJpaMapper<GoodsEntity, GoodsDto> {

    @Override
    public GoodsDto entityToDto(GoodsEntity entity) {
        return GoodsDto.builder()
                .setId(entity.getId())
                .setName(entity.getName())
                .setPrice(entity.getPrice())
                .build();
    }
}
