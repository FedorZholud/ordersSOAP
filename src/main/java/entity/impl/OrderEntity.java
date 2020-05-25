package entity.impl;



import entity.JpaBaseEntity;
import org.hibernate.annotations.ResultCheckStyle;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import javax.persistence.Entity;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;

/**
 * @author Fedor Zholud
 *
 */

@Entity
@SQLDelete(sql = "UPDATE orders SET state = 'DELETED' where order_number = ?", check = ResultCheckStyle.COUNT)
@Where(clause = "state <> 'DELETED'")
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

    @Column(name = "state")
    @Enumerated(EnumType.STRING)
    private OrderState orderState;

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

    public OrderState getOrderState() {
        return orderState;
    }

    public void setOrderState(OrderState orderState) {
        this.orderState = orderState;
    }

    @PreRemove
    public void deleteOrder() {
        this.orderState = OrderState.DELETED;
    }

    @Override
    public String toString() {
        return "OrderEntity{" +
                "orderNumber=" + orderNumber +
                ", customer='" + customer + '\'' +
                ", orderTime=" + orderTime +
                ", orderState=" + orderState +
                ", orderLineEntities=" + orderLineEntities +
                '}';
    }
}