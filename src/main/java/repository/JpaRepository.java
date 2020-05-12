package repository;

import entity.JpaBaseEntity;

import java.util.List;

/**
 * @author Fedor Zholud
 *
 */

public interface JpaRepository<T extends JpaBaseEntity> extends Repository<T> {

}
