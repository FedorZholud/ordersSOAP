package service.impl;

import entity.OrdersEntity;
import mapper.Mapper;
import model.OrdersDto;
import repository.impl.OrdersRepository;
import service.OrdersService;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Date;

/**
 * @author Fedor Zholud
 *
 */

@Stateless
public class OrdersServiceImpl implements OrdersService {

    @EJB
    OrdersRepository ordersRepository;

    @EJB(beanName = "OrdersMapper")
    Mapper<OrdersEntity, OrdersDto> ordersMapper;

    @Override
    public OrdersDto getOrder(long orderNumber) {
        OrdersEntity ordersEntity = ordersRepository.find((int) orderNumber);
        return ordersMapper.entityToDto(ordersEntity);
    }

    @Override
    public long createOrderAsId(String customer) {
        return createOrdersEntity(customer).getOrderNumber();
    }

    @Override
    public OrdersDto createOrder(String customer) {
        return ordersMapper.entityToDto(createOrdersEntity(customer));
    }

    private OrdersEntity createOrdersEntity(String customer) {
        Date currentDate = new Date();

        OrdersEntity ordersEntity = new OrdersEntity();
        ordersEntity.setCustomer(customer);
        ordersEntity.setOrderTime(new Timestamp(currentDate.getTime()));

        ordersRepository.create(ordersEntity);

        return ordersEntity;
    }
}
