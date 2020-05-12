package mapper;

import entity.Entity;
import model.Dto;

@FunctionalInterface
public interface DtoToEntityMapper<EntityT extends Entity, DtoT extends Dto> {

    EntityT dtoToEntity(DtoT dto);

}
