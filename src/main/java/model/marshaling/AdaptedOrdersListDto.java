package model.marshaling;

public class AdaptedOrdersListDto {

    private int id;
    private int orderNumber;
    private String goodsName;
    private double price;
    private int amount;
    private double priceSum;

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setOrderNumber(int orderNumber) {
        this.orderNumber = orderNumber;
    }

    public int getOrderNumber() {
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
