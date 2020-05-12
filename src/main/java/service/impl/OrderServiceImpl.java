package service.impl;

import entity.impl.OrderEntity;
import mapper.jpa.EntityToDtoJpaMapper;
import mapper.jpa.impl.order.OrderEntityToDtoJpaMapper;
import model.impl.OrderDto;
import repository.impl.OrderJpaRepository;
import service.OrderService;

import javax.ejb.EJB;
import javax.ejb.Stateless;
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
    public OrderDto getOrder(long orderNumber) {
        OrderEntity orderEntity = ordersRepository.find((int) orderNumber);
        return orderEntityToDtoJpaMapper.entityToDto(orderEntity);
    }

    @Override
    public long createOrderAsId(String customer) {
        return createOrdersEntity(customer).getOrderNumber();
    }

    @Override
    public OrderDto createOrder(String customer) {
        return orderEntityToDtoJpaMapper.entityToDto(createOrdersEntity(customer));
    }

    private OrderEntity createOrdersEntity(String customer) {
        Date currentDate = new Date();

        OrderEntity orderEntity = new OrderEntity();
        orderEntity.setCustomer(customer);
        orderEntity.setOrderTime(new Timestamp(currentDate.getTime()));

        ordersRepository.create(orderEntity);

        return orderEntity;
    }

    @Override
    public List<OrderDto> getAllOrders() {
        List<OrderEntity> ordersEntities = ordersRepository.findAll();

        return ordersEntities.stream()
                .map(orderEntityToDtoJpaMapper::entityToDto)
                .collect(Collectors.toList());
    }
}
