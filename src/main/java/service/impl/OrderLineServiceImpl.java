package service.impl;

import entity.impl.GoodsEntity;
import entity.impl.OrderLineEntity;
import mapper.jpa.JpaSymmetricMapper;
import model.impl.OrderLineDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import repository.impl.GoodsJpaRepository;
import repository.impl.OrderLineJpaRepository;
import service.OrderLineService;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Fedor Zholud
 *
 */

@Stateless
public class OrderLineServiceImpl implements OrderLineService {

    static final Logger logger =
            LoggerFactory.getLogger(OrderLineServiceImpl.class);

    @EJB
    OrderLineJpaRepository orderLineJpaRepository;

    @EJB(beanName = "OrdersLineJpaSymmetricMapper")
    JpaSymmetricMapper<OrderLineEntity, OrderLineDto> orderLineDtoJpaSymmetricMapper;

//    @Override
//    public OrderLineDto createOrderLine(long orderNumber, long goodsId, int amount) {
//        return orderLineDtoJpaSymmetricMapper.entityToDto(createOrdersListEntity(orderNumber, goodsId, amount));
//    }
//
//    @Override
//    public long createOrderLineAsId(long orderNumber, long goodsId, int amount) {
//        return createOrdersListEntity(orderNumber, goodsId, amount).getId();
//    }

    @Override
    @Transactional
    public long createOrderLineAsId(OrderLineDto orderLineDto) {
        OrderLineEntity orderLineEntity = orderLineDtoJpaSymmetricMapper.dtoToEntity(orderLineDto);
        orderLineJpaRepository.create(orderLineEntity);
        logger.info(orderLineEntity.toString());
        return orderLineEntity.getId();
    }

    @Override
    @Transactional
    public OrderLineDto createOrderLine(OrderLineDto orderLineDto) {
        OrderLineEntity orderLineEntity = orderLineDtoJpaSymmetricMapper.dtoToEntity(orderLineDto);
        orderLineJpaRepository.create(orderLineEntity);
        logger.info(orderLineEntity.toString());
        return orderLineDtoJpaSymmetricMapper.entityToDto(orderLineEntity);
    }

//    private OrderLineEntity createOrdersListEntity(long orderNumber, long goodsId, int amount) {
//        GoodsEntity goodsEntity = goodsRepository.find(goodsId);
//
//        OrderLineEntity orderLineEntity = new OrderLineEntity();
//        orderLineEntity.setOrderNumber(orderNumber);
//        orderLineEntity.setGoodsId(goodsEntity.getId());
//        orderLineEntity.setPrice(goodsEntity.getPrice());
//        orderLineEntity.setAmount(amount);
//        orderLineEntity.setPriceSum(goodsEntity.getPrice() * amount);
//
//        orderLineJpaRepository.create(orderLineEntity);
//
//        return orderLineEntity;
//    }

    @Override
    @Transactional
    public List<OrderLineDto> getOrderLine(long orderNumber) {
        List<OrderLineEntity> ordersListEntities = orderLineJpaRepository.findAll(orderNumber);

        return ordersListEntities.stream()
                .peek(orderLineEntity -> logger.info(orderLineEntity.toString()))
                .map(orderLineDtoJpaSymmetricMapper::entityToDto)
                .collect(Collectors.toList());
    }

//    @Override
//    public long deleteOrderLine(long id) {
//        OrderLineEntity orderLineEntity = orderLineJpaRepository.find(id);
//        orderLineJpaRepository.delete(orderLineEntity);
//
//        return orderLineEntity.getId();
//    }

    @Override
    @Transactional
    public long deleteOrderLine(OrderLineDto orderLineDto) {
        OrderLineEntity orderLineEntity = orderLineJpaRepository.find(orderLineDto.getId());
        orderLineJpaRepository.delete(orderLineEntity);
        logger.info(orderLineEntity.toString());

        return orderLineEntity.getId();
    }


//    @Override
//    public long updateOrderLine(long id, int amount) {
//        OrderLineEntity orderLineEntity = orderLineJpaRepository.find(id);
//        orderLineEntity.setAmount(amount);
//        orderLineEntity.setPriceSum(orderLineEntity.getPrice() * amount);
//
//        orderLineJpaRepository.update(orderLineEntity);
//
//        return orderLineEntity.getId();
//    }


    @Override
    @Transactional
    public long updateOrderLine(OrderLineDto orderLineDto) {
        OrderLineEntity orderLineEntity = orderLineJpaRepository.find(orderLineDto.getId());
        orderLineEntity.setAmount(orderLineDto.getAmount());
        orderLineEntity.setPriceSum(orderLineEntity.getPrice() * orderLineDto.getAmount());

        orderLineJpaRepository.update(orderLineEntity);
        logger.info(orderLineEntity.toString());

        return orderLineEntity.getId();
    }
}
