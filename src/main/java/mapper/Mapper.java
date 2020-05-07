package mapper;

import entity.BaseEntity;
import model.BaseDto;

public interface Mapper<EntityT extends BaseEntity, DtoT extends BaseDto> {

    DtoT entityToDto(EntityT entity);

}
