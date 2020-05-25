package service.impl;


import entity.Entity;
import entity.impl.OrderEntity;
import mapper.EntityToDtoMapper;
import model.Dto;
import model.impl.OrderDto;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.arquillian.transaction.api.annotation.TransactionMode;
import org.jboss.arquillian.transaction.api.annotation.Transactional;
import org.jboss.shrinkwrap.api.Archive;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import repository.Repository;
import repository.impl.OrderJpaRepository;
import service.GoodsService;
import service.OrderService;

import javax.ejb.EJB;
import javax.inject.Inject;
import java.util.List;

/**
 * @author Fedor Zholud
 *
 */

@RunWith(Arquillian.class)
@Transactional(TransactionMode.ROLLBACK)
public class OrderServiceTest {

    static final Logger logger =
            LoggerFactory.getLogger(OrderServiceTest.class);

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

    @Inject
    OrderEntity orderEntity;

    @Inject
    OrderDto orderDto;

    @EJB
    OrderJpaRepository orderJpaRepository;

    @EJB
    OrderService orderService;

    @Test
    public void getOrder() {

    };

    @Test
    public void createOrderAsId() {

    };

    @Test
    public void createOrder() {

    };

    @Test
    public void getAllOrders() {

    };

    @Test
    public void deleteOrder() {

    };

    @Test
    public void update() {

    };
}
