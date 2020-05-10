package repository.impl;

import entity.GoodsEntity;

import javax.ejb.Stateless;

/**
 * @author Fedor Zholud
 *
 */

@Stateless
public class GoodsRepository extends AbstractRepository<GoodsEntity> {

    public GoodsRepository() {
        super(GoodsEntity.class);
    }

}