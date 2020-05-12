package mapper;

import entity.Entity;
import model.Dto;

@FunctionalInterface
public interface EntityToDtoMapper<EntityT extends Entity, DtoT extends Dto> {

    DtoT entityToDto(EntityT entity);

}
