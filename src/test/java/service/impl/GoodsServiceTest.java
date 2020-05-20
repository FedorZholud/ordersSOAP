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
import repository.Repository;
import repository.impl.GoodsJpaRepository;
import service.GoodsService;

import javax.ejb.EJB;
import javax.inject.Inject;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(Arquillian.class)
public class GoodsServiceTest {

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
        goodsEntity.setName("Cheese");
        goodsEntity.setPrice(100.0);

        System.out.println(goodsEntity.toString());

        goodsJpaRepository.create(goodsEntity);
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
    public void getGoods() {
        List<GoodsDto> goodsDtos = goodsService.getGoods();
        System.out.println("goodsDtos size: " + goodsDtos.size());
        assertNotNull(goodsDtos);
        assertEquals(2, goodsDtos.size());
    }

    @Test
    public void getGoodsById() {
        goodsDto = goodsService.getGoodsById(goodsEntity.getId());
        System.out.println("goodsDto id: " + goodsDto.getId());
        System.out.println("goodsDto name" + goodsDto.getName());
        assertNotNull(goodsDto);
        assertEquals("Cheese", goodsDto.getName());
    }
}
