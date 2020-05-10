package entity;



import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;
import java.sql.Timestamp;

/**
 * @author Fedor Zholud
 *
 */

@Entity
@Table(name = "orders")
public class OrdersEntity extends BaseEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "order_number")
    private long orderNumber;

    @Column(name = "customer")
    private String customer;

    @Column(name = "order_time")
    private Timestamp orderTime;

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

}