package service.impl;

import entity.Entity;
import entity.impl.GoodsEntity;
import mapper.EntityToDtoMapper;
import model.Dto;
import model.impl.GoodsDto;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.arquillian.transaction.api.annotation.TransactionMode;
import org.jboss.arquillian.transaction.api.annotation.Transactional;
import org.jboss.shrinkwrap.api.Archive;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import repository.Repository;
import repository.impl.GoodsJpaRepository;
import service.GoodsService;

import javax.ejb.EJB;
import javax.inject.Inject;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.junit.Assert.*;

/**
 * @author Fedor Zholud
 *
 */

@RunWith(Arquillian.class)
@Transactional(TransactionMode.ROLLBACK)
public class GoodsServiceTest {

    static final Logger logger =
            LoggerFactory.getLogger(GoodsServiceTest.class);

    @Deployment
    public static Archive<?> createDeployment() {
        return ShrinkWrap.create(WebArchive.class)
                .addPackages(true, Entity.class.getPackage(), Repository.class.getPackage(),
                        EntityToDtoMapper.class.getPackage(), GoodsService.class.getPackage(),
                        Dto.class.getPackage())
                .addAsResource("META-INF/test-persistence.xml", "META-INF/persistence.xml")
                .addAsWebInfResource("arquillian-ds.xml")
                .addAsWebInfResource(EmptyAsset.INSTANCE, "beans.xml");
    }

    @Before
    public void createEntity() {
        logger.info("Before createEntity");
        goodsEntity.setName("Cheese");
        goodsEntity.setPrice(100.0);

        goodsJpaRepository.create(goodsEntity);

        logger.info(goodsEntity.toString());
    }

    @Inject
    GoodsDto goodsDto;

    @Inject
    GoodsEntity goodsEntity;

    @EJB
    GoodsJpaRepository goodsJpaRepository;

    @EJB
    GoodsService goodsService;

    @Test
    public void findAllGoods() {
        logger.info("Start test findAllGoods");
        List<GoodsDto> goodsDtos = goodsService.findAllGoods(1, 10);
        assertNotNull(goodsDtos);
        assertEquals(1, goodsDtos.size());
        logger.info("End test findAllGoods\n");
    }

    @Test
    public void findGoodsById() {
        logger.info("Start test findGoodsById");
        goodsDto = goodsService.findGoodsById(goodsEntity.getId());
        logger.info("goodsDto id: " + goodsDto.getId());
        assertNotNull(goodsDto);
        assertEquals("Cheese", goodsDto.getName());
        logger.info("End test findGoodsById\n");
    }
}