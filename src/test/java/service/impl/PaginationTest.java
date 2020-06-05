package service.impl;

import entity.Entity;
import mapper.EntityToDtoMapper;
import model.Dto;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.Archive;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.junit.runner.RunWith;
import repository.Repository;
import service.GoodsService;

@RunWith(Arquillian.class)
public class PaginationTest {

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
}
