package mapper;

import entity.Entity;
import entity.JpaBaseEntity;
import model.BaseDto;
import model.Dto;

/**
 * хуячит в обе стороны
 */
public interface SymmetricMapper<EntityT extends Entity, DtoT extends Dto> extends DtoToEntityMapper<EntityT, DtoT>, EntityToDtoMapper<EntityT, DtoT> {

}
