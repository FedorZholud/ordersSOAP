package repository;

import entity.OrdersListEntity;

import java.util.List;

/**
 * @author Fedor Zholud
 *
 */
@Deprecated
public interface OrdersListRepository {

    //create
    OrdersListEntity create(OrdersListEntity ordersList);

    //read
    OrdersListEntity find(int id);

    //read all
    List<OrdersListEntity> findAll(int orderNumber);

    //update
    void update(OrdersListEntity ordersList);

    //delete
    void delete(OrdersListEntity ordersList);
}
