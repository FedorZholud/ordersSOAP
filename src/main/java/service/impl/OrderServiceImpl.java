package service.impl;

import entity.impl.OrderEntity;
import entity.impl.OrderState;
import mapper.jpa.EntityToDtoJpaMapper;
import model.impl.OrderDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import repository.impl.OrderJpaRepository;
import service.OrderService;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.transaction.Transactional;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Fedor Zholud
 *
 */

@Stateless
public class OrderServiceImpl implements OrderService {

    static final Logger logger =
            LoggerFactory.getLogger(OrderServiceImpl.class);

    @EJB
    OrderJpaRepository orderJpaRepository;

    @EJB(beanName = "OrderEntityToDtoJpaMapper")
    EntityToDtoJpaMapper<OrderEntity, OrderDto> orderEntityToDtoJpaMapper;

    @Override
    @Transactional
    public OrderDto getOrder(long orderNumber) {
        OrderEntity orderEntity = orderJpaRepository.find((int) orderNumber);
        return orderEntityToDtoJpaMapper.entityToDto(orderEntity);
    }

    @Override
    @Transactional
    public long createOrderAsId(String customer) {
        return createOrdersEntity(customer).getOrderNumber();
    }

    @Override
    @Transactional
    public OrderDto createOrder(String customer) {
        return orderEntityToDtoJpaMapper.entityToDto(createOrdersEntity(customer));
    }

    private OrderEntity createOrdersEntity(String customer) {
        Date currentDate = new Date();

        OrderEntity orderEntity = new OrderEntity();
        orderEntity.setCustomer(customer);
        orderEntity.setOrderTime(new Timestamp(currentDate.getTime()));
        orderEntity.setOrderState(OrderState.ACTIVE);

        orderJpaRepository.create(orderEntity);

        return orderEntity;
    }

    @Override
    @Transactional
    public List<OrderDto> getAllOrders() {
        List<OrderEntity> ordersEntities = orderJpaRepository.findAll();

        return ordersEntities.stream()
                .map(orderEntityToDtoJpaMapper::entityToDto)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional
    public long deleteOrder(long orderNumber) {
        orderJpaRepository.delete(orderJpaRepository.find(orderNumber));
        return orderNumber;
    }

    @Override
    public long updateOrder(OrderDto orderDto) {
        OrderEntity orderEntity = orderJpaRepository.find(orderDto.getOrderNumber());
        orderEntity.setCustomer(orderDto.getCustomer());

        orderJpaRepository.update(orderEntity);

        return orderEntity.getOrderNumber();
    }
}
