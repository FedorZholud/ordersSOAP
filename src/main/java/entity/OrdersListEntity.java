package entity;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @author Fedor Zholud
 *
 */

@Entity
@NamedQuery(name = "entity.OrdersListEntity.findAll", query = "select o from OrdersListEntity o where o.orderNumber = :param")
@Table(name = "orders_list")
public class OrdersListEntity extends BaseEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id")
    private long id;

    @Column(name = "order_number")
    private long orderNumber;

    @Column(name = "goods_name")
    private String goodsName;

    @Column(name = "price")
    private double price;

    @Column(name = "amount")
    private int amount;

    @Column(name = "price_sum")
    private double priceSum;

    public long getId() {
        return id;
    }

    public long getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(long orderNumber) {
        this.orderNumber = orderNumber;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public double getPriceSum() {
        return priceSum;
    }

    public void setPriceSum(double priceSum) {
        this.priceSum = priceSum;
    }
}
