package model.marshaling;

/**
 * @author Fedor Zholud
 *
 */

public class AdaptedOrderLineDto {

    private long id;
    private long orderNumber;
    private String goodsName;
    private double price;
    private int amount;
    private double priceSum;

    public void setId(long id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }

    public void setOrderNumber(long orderNumber) {
        this.orderNumber = orderNumber;
    }

    public long getOrderNumber() {
        return orderNumber;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getPrice() {
        return price;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public int getAmount() {
        return amount;
    }

    public void setPriceSum(double priceSum) {
        this.priceSum = priceSum;
    }

    public double getPriceSum() {
        return priceSum;
    }
}
