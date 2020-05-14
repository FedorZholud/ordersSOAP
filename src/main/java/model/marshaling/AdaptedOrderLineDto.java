package model.marshaling;

/**
 * @author Fedor Zholud
 *
 */

public class AdaptedOrderLineDto {

    private long id;
    private long orderNumber;
    private long goodsId;
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

    public void setGoodsId(long goodsId) {
        this.goodsId = goodsId;
    }

    public long getGoodsId() {
        return goodsId;
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
