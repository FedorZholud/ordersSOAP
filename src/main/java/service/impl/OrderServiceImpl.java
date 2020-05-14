package service.impl;

import entity.impl.OrderEntity;
import entity.impl.OrderState;
import mapper.jpa.EntityToDtoJpaMapper;
import mapper.jpa.impl.order.OrderEntityToDtoJpaMapper;
import model.impl.OrderDto;
import org.hibernate.criterion.Order;
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

    @EJB
    OrderJpaRepository ordersRepository;

    @EJB(beanName = "OrderEntityToDtoJpaMapper")
    EntityToDtoJpaMapper<OrderEntity, OrderDto> orderEntityToDtoJpaMapper;

    @Override
    @Transactional
    public OrderDto getOrder(long orderNumber) {
        OrderEntity orderEntity = ordersRepository.find((int) orderNumber);
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

        ordersRepository.create(orderEntity);

        return orderEntity;
    }

    @Override
    @Transactional
    public List<OrderDto> getAllOrders() {
        List<OrderEntity> ordersEntities = ordersRepository.findAll();

        return ordersEntities.stream()
                .map(orderEntityToDtoJpaMapper::entityToDto)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional
    public long deleteOrder(long orderNumber) {
        ordersRepository.delete(ordersRepository.find(orderNumber));
        return orderNumber;
    }
}
