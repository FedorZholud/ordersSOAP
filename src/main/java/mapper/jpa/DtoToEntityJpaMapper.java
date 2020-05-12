package mapper.jpa;

import entity.JpaBaseEntity;
import mapper.DtoToEntityMapper;
import model.BaseDto;

public interface DtoToEntityJpaMapper<EntityT extends JpaBaseEntity, DtoT extends BaseDto> extends DtoToEntityMapper<EntityT, DtoT> {


}
