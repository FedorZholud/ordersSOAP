package mapper.jpa;

import entity.JpaBaseEntity;
import mapper.SymmetricMapper;
import model.BaseDto;

/**
 * it works for both sides
 * @param <EntityT>
 * @param <DtoT>
 */
public interface JpaSymmetricMapper<EntityT extends JpaBaseEntity, DtoT extends BaseDto> extends SymmetricMapper<EntityT, DtoT> {

}
