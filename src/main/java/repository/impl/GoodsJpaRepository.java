package repository.impl;

import entity.impl.GoodsEntity;
import repository.AbstractJpaRepository;

import javax.ejb.Stateless;

/**
 * @author Fedor Zholud
 *
 */

@Stateless
public class GoodsJpaRepository extends AbstractJpaRepository<GoodsEntity> {

    public GoodsJpaRepository() {
        super(GoodsEntity.class);
    }

}