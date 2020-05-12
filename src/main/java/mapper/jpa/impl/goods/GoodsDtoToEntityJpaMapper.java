package mapper.jpa.impl.goods;

import entity.impl.GoodsEntity;
import mapper.jpa.DtoToEntityJpaMapper;
import mapper.jpa.EntityToDtoJpaMapper;
import model.impl.GoodsDto;

import javax.ejb.Stateless;

@Stateless
public class GoodsDtoToEntityJpaMapper implements DtoToEntityJpaMapper<GoodsEntity, GoodsDto> {

    //TODO need implement
    @Override
    public GoodsEntity dtoToEntity(GoodsDto dto) {
        throw new RuntimeException("not yet implemented");
    }
}