package mapper.jpa.impl.goods;

import entity.impl.GoodsEntity;
import mapper.jpa.JpaSymmetricMapper;
import model.impl.GoodsDto;

import javax.ejb.Stateless;

@Stateless(name = "GoodsJpaSymmetricMapper")
public class GoodsSymmetricJpaMapper implements JpaSymmetricMapper<GoodsEntity, GoodsDto> {

    GoodsDtoToEntityJpaMapper goodsDtoToEntityJpaMapper;
    GoodsEntityToDtoJpaMapper goodsEntityToDtoJpaMapper;

    @Override
    public GoodsDto entityToDto(GoodsEntity entity) {
        return goodsEntityToDtoJpaMapper.entityToDto(entity);
    }

    @Override
    public GoodsEntity dtoToEntity(GoodsDto dto) {
        return goodsDtoToEntityJpaMapper.dtoToEntity(dto);
    }
}
