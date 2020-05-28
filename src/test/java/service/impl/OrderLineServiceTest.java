package service.impl;

import entity.Entity;
import entity.impl.GoodsEntity;
import entity.impl.OrderEntity;
import entity.impl.OrderLineEntity;
import entity.impl.OrderState;
import mapper.EntityToDtoMapper;
import mapper.jpa.JpaSymmetricMapper;
import model.Dto;
import model.impl.OrderLineDto;
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
import repository.impl.GoodsJpaRepository;
import repository.impl.OrderJpaRepository;
import repository.impl.OrderLineJpaRepository;
import service.GoodsService;
import service.OrderLineService;

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
public class OrderLineServiceTest {

    static final Logger logger =
            LoggerFactory.getLogger(OrderLineServiceTest.class);

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
        logger.info("Before createEntities");
        goodsEntity.setName("Cheese");
        goodsEntity.setPrice(100.0);

        goodsJpaRepository.create(goodsEntity);
        logger.info(goodsEntity.toString());

        Date currentDate = new Date();
        orderEntity.setCustomer("asd@mail.ru");
        orderEntity.setOrderTime(new Timestamp(currentDate.getTime()));
        orderEntity.setOrderState(OrderState.ACTIVE);

        orderJpaRepository.create(orderEntity);
        logger.info(orderEntity.toString());

        orderLineDto = OrderLineDto.builder()
                .setOrderNumber(orderEntity.getOrderNumber())
                .setGoodsId(goodsEntity.getId())
                .setAmount(5)
                .setPrice(0)
                .setPriceSum(0)
                .build();

        orderLineEntity = orderLineDtoJpaSymmetricMapper.dtoToEntity(orderLineDto);

        orderLineJpaRepository.create(orderLineEntity);
        logger.info(orderLineEntity.toString());
    }

    @Inject
    OrderLineEntity orderLineEntity;

    @Inject
    OrderLineDto orderLineDto;

    @Inject
    GoodsEntity goodsEntity;

    @Inject
    OrderEntity orderEntity;

    @EJB(beanName = "OrdersLineJpaSymmetricMapper")
    JpaSymmetricMapper<OrderLineEntity, OrderLineDto> orderLineDtoJpaSymmetricMapper;

    @EJB
    OrderJpaRepository orderJpaRepository;

    @EJB
    GoodsJpaRepository goodsJpaRepository;

    @EJB
    OrderLineJpaRepository orderLineJpaRepository;

    @EJB
    OrderLineService orderLineService;

    @Test
    public void createOrderLineAsId() {
        logger.info("Start test createOrderLineAsId");
        long id = orderLineService.createOrderLineAsId(orderLineDto);
        logger.info("orderLineEntity id: " + id);
        assertNotNull(orderLineJpaRepository.find(id));
        logger.info("End test createOrderLineAsId\n");
    };

    @Test
    public void createOrderLine() {
        logger.info("Start test createOrderLine");
        OrderLineDto dto = orderLineService.createOrderLine(orderLineDto);
        logger.info("orderLineEntity id: " + dto.getId());
        assertNotNull(dto);
        assertNotNull(orderLineJpaRepository.find(dto.getId()));
        logger.info("End test createOrderLine\n");
    }

    @Test
    public void getOrderLine() {
        logger.info("Start test getOrderLine");
        List<OrderLineDto> orderLineDtos = orderLineService.getOrderLine(orderLineEntity.getOrderNumber(), 0, 10);
        assertNotNull(orderLineDtos);
        assertEquals(1, orderLineDtos.size());
        logger.info("End test getOrderLine\n");
    }

    @Test
    public void deleteOrderLine() {
        logger.info("Start test deleteOrderLine");
        orderLineService.deleteOrderLine(orderLineDtoJpaSymmetricMapper.entityToDto(orderLineEntity));
        assertNull(orderLineJpaRepository.find(orderLineDto.getId()));
        logger.info("End test deleteOrderLine\n");
    }

    @Test
    public void updateOrderLine() {
        logger.info("Start test updateOrderLine");
        orderLineEntity.setAmount(3);
        OrderLineDto dto = orderLineDtoJpaSymmetricMapper.entityToDto(orderLineEntity);
        orderLineService.updateOrderLine(dto);
        assertEquals(3, dto.getAmount());
        logger.info("End test updateOrderLine\n");
    }
}
