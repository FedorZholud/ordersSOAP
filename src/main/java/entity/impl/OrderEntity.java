package entity.impl;



import entity.JpaBaseEntity;

import javax.persistence.*;
import javax.persistence.Entity;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Fedor Zholud
 *
 */

@Entity
@NamedQuery(name = "entity.impl.OrderEntity.findAll", query = "select o from OrderEntity o")
@Table(name = "orders")
public class OrderEntity extends JpaBaseEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "order_number")
    private long orderNumber;

    @Column(name = "customer")
    private String customer;

    @Column(name = "order_time")
    private Timestamp orderTime;

    @OneToMany
    @JoinColumn(name = "order_number")
    List<OrderLineEntity> orderLineEntities;

    public long getOrderNumber() {
        return orderNumber;
    }

    public void setCustomer(String customer) {
        this.customer = customer;
    }

    public String getCustomer() {
        return customer;
    }

    public void setOrderTime(Timestamp orderTime) {
        this.orderTime = orderTime;
    }

    public Timestamp getOrderTime() {
        return orderTime;
    }

    public void setOrdersListEntities(List<OrderLineEntity> ordersListEntities) {
        this.orderLineEntities = ordersListEntities;
    }

    public List<OrderLineEntity> getOrdersListEntities() {
        return orderLineEntities;
    }

    @Override
    public String toString() {
        return "OrdersEntity{" +
                "orderNumber=" + orderNumber +
                ", customer='" + customer + '\'' +
                ", orderTime=" + orderTime +
                ", ordersListEntities=" + orderLineEntities +
                '}';
    }
}