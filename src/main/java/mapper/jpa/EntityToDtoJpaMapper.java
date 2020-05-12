package mapper.jpa;

import entity.JpaBaseEntity;
import mapper.EntityToDtoMapper;
import model.BaseDto;

public interface EntityToDtoJpaMapper<EntityT extends JpaBaseEntity, DtoT extends BaseDto> extends EntityToDtoMapper<EntityT, DtoT> {


}
