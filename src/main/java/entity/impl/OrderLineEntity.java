package entity.impl;

import entity.JpaBaseEntity;

import javax.persistence.*;
import javax.persistence.Entity;
import java.io.Serializable;

/**
 * @author Fedor Zholud
 *
 */

@Entity
@NamedQuery(name = "entity.impl.OrderLineEntity.findAll", query = "select o from OrderLineEntity o where o.orderNumber = :param")
@Table(name = "orders_list")
public class OrderLineEntity extends JpaBaseEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id")
    private long id;

    @Column(name = "order_number")
    private long orderNumber;

    @Column(name = "goods_id")
    private long goodsId;

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

    public long getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(long goodsId) {
        this.goodsId = goodsId;
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

    @Override
    public String toString() {
        return "OrderLineEntity{" +
                "id=" + id +
                ", orderNumber=" + orderNumber +
                ", goodsId=" + goodsId +
                ", price=" + price +
                ", amount=" + amount +
                ", priceSum=" + priceSum +
                '}';
    }
}
