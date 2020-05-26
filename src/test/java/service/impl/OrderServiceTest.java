package service.impl;


import entity.Entity;
import entity.impl.OrderEntity;
import entity.impl.OrderState;
import mapper.EntityToDtoMapper;
import mapper.jpa.EntityToDtoJpaMapper;
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
import org.junit.Before;
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
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;

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

    @Before
    public void createEntity() {
        logger.info("Before createEntities");
        Date currentDate = new Date();
        orderEntity.setCustomer("asd@mail.ru");
        orderEntity.setOrderTime(new Timestamp(currentDate.getTime()));
        orderEntity.setOrderState(OrderState.ACTIVE);

        orderJpaRepository.create(orderEntity);
        logger.info(orderEntity.toString());
    }

    @Inject
    OrderEntity orderEntity;

    @Inject
    OrderDto orderDto;

    @EJB(beanName = "OrderEntityToDtoJpaMapper")
    EntityToDtoJpaMapper<OrderEntity, OrderDto> orderEntityToDtoJpaMapper;

    @EJB
    OrderJpaRepository orderJpaRepository;

    @EJB
    OrderService orderService;

    @Test
    public void getOrder() {
        logger.info("Start test getOrder");
        OrderDto orderDto = orderService.getOrder(orderEntity.getOrderNumber());
        logger.info("orderNumber: " + orderDto.getOrderNumber());
        assertNotNull(orderDto);
        logger.info("End test getOrder\n");
    }

    @Test
    public void createOrderAsId() {
        logger.info("Start test createOrderAsId");
        long orderNumber = orderService.createOrderAsId("asdasd@mail.ru");
        logger.info("orderNumber: " + orderNumber);
        assertNotNull(orderJpaRepository.find(orderNumber));
        logger.info("End test createOrderAsId\n");
    }

    @Test
    public void createOrder() {
        logger.info("Start test createOrder");
        OrderDto dto = orderService.createOrder("asdasdad@mail.ru");
        logger.info("dto orderNumber: " + dto.getOrderNumber());
        assertNotNull(dto);
        logger.info("End test createOrder\n");
    }

    @Test
    public void getAllOrders() {
        logger.info("Start test getAllOrder");
        List<OrderDto> orderDtos = orderService.getAllOrders();
        assertNotNull(orderDtos);
        assertEquals(1, orderDtos.size());
        logger.info("End test getAllOrder\n");
    }

    @Test
    public void deleteOrder() {
        logger.info("Start test deleteOrder");
        long id = orderService.deleteOrder(orderEntity.getOrderNumber());
        logger.info("orderNumber: " + id);
        assertEquals(OrderState.DELETED, orderEntity.getOrderState());
        logger.info("End test deleteOrder\n");
    }

    @Test
    public void updateOrder() {
        logger.info("Start test updateOrder");
        orderEntity.setCustomer("1@mail.ru");
        orderDto = orderEntityToDtoJpaMapper.entityToDto(orderEntity);
        long id = orderService.updateOrder(orderDto);
        logger.info("orderNumber: " + id);
        assertEquals("1@mail.ru", orderJpaRepository.find(orderEntity.getOrderNumber()).getCustomer());
        logger.info("End test updateOrder\n");
    }
}
