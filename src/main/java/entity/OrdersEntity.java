package entity;



import javax.persistence.*;
import java.io.Serializable;
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
    @Column(name = "id")
    private int id;

    @Column(name = "order_number")
    private int orderNumber;

    @Column(name = "customer")
    private String customer;

    @Column(name = "order_time")
    private Timestamp orderTime;

    public int getId() {
        return id;
    }

    public void setOrderNumber(int orderNumber) {
        this.orderNumber = orderNumber;
    }

    public int getOrderNumber() {
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