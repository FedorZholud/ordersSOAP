package repository;

import entity.OrdersListEntity;

import java.util.List;

public interface OrdersListRepository {

    //create
    void create(OrdersListEntity ordersList);

    //read
    OrdersListEntity read(int id);

    //read all
    List<OrdersListEntity> findAll();

    //update
    void update(OrdersListEntity ordersList);

    //delete
    void delete(OrdersListEntity ordersList);
}
