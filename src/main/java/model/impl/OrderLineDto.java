package model.impl;

import model.BaseDto;
import model.marshaling.OrderLineDtoAdapter;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

/**
 * @author Fedor Zholud
 *
 */

@XmlRootElement
@XmlJavaTypeAdapter(OrderLineDtoAdapter.class)
public class OrderLineDto extends BaseDto {

    private final long id;
    private final long orderNumber;
    private final long goodsId;
    private final double price;
    private final int amount;
    private final double priceSum;

    public long getId() {
        return id;
    }

    public long getOrderNumber() {
        return orderNumber;
    }

    public long getGoodsId() {
        return goodsId;
    }

    public double getPrice() {
        return price;
    }

    public int getAmount() {
        return amount;
    }

    public double getPriceSum() {
        return priceSum;
    }

    @SuppressWarnings("unused")
    private OrderLineDto() {
        this(0, 0, 0, 0, 0, 0);
    }

    private OrderLineDto(long id, long orderNumber, long goodsId, double price, int amount, double priceSum) {
        this.id = id;
        this.orderNumber = orderNumber;
        this.goodsId = goodsId;
        this.price = price;
        this.amount = amount;
        this.priceSum = priceSum;
    }

    public static OrdersListDtoBuilder builder() {
        return new OrdersListDtoBuilder();
    }

    public static class OrdersListDtoBuilder {

        private long id;
        private long orderNumber;
        private long goodsId;
        private double price;
        private int amount;
        private double priceSum;

        private OrdersListDtoBuilder() {

        }

        public OrdersListDtoBuilder setId(long id) {
            this.id = id;
            return this;
        }

        public OrdersListDtoBuilder setOrderNumber(long orderNumber) {
            this.orderNumber = orderNumber;
            return this;
        }

        public OrdersListDtoBuilder setGoodsId(long goodsId) {
            this.goodsId = goodsId;
            return this;
        }

        public OrdersListDtoBuilder setPrice(double price) {
            this.price = price;
            return this;
        }

        public OrdersListDtoBuilder setAmount(int amount) {
            this.amount = amount;
            return this;
        }
        public OrdersListDtoBuilder setPriceSum(double priceSum) {
            this.priceSum = priceSum;
            return this;
        }

        public OrderLineDto build() {
            return new OrderLineDto(
                    this.id,
                    this.orderNumber,
                    this.goodsId,
                    this.price,
                    this.amount,
                    this.priceSum);
        }
    }
}
