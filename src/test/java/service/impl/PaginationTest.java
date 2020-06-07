package service.impl;

import entity.Entity;
import entity.impl.GoodsEntity;
import mapper.EntityToDtoMapper;
import model.Dto;
import model.impl.GoodsDto;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.Archive;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import repository.Repository;
import repository.impl.GoodsJpaRepository;
import service.GoodsService;

import static org.junit.Assert.*;

import javax.ejb.EJB;
import java.util.List;

@RunWith(Arquillian.class)
public class PaginationTest {

    static final Logger logger =
            LoggerFactory.getLogger(PaginationTest.class);

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
    public void createEntities() {
        for (int i = 0; i < 10; i++) {
            GoodsEntity goodsEntity = new GoodsEntity();
            goodsEntity.setName("goods" + i);
            goodsEntity.setPrice(10.0 + i);

            goodsJpaRepository.create(goodsEntity);
            logger.info("GoodsEntity id: " + goodsEntity.getId());
        }
    }

    @EJB
    GoodsJpaRepository goodsJpaRepository;

    @EJB
    GoodsService goodsService;

    @Test
    public void paginationTest() {
        logger.info("Start paginationTest");
        List<GoodsDto> firstPage = goodsService.findAllGoods(1, 5);
        assertEquals(5, firstPage.get(firstPage.size() - 1).getId());
        List<GoodsDto> secondPage = goodsService.findAllGoods(2, 5);
        assertEquals(10, secondPage.get(secondPage.size() - 1).getId());
        List<GoodsDto> thirdPage = goodsService.findAllGoods(3, 5);
        assertEquals(0, thirdPage.size());
        logger.info("End paginationTest");
    }
}