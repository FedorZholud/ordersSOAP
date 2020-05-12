package model.impl;


import model.BaseDto;
import model.marshaling.OrderDtoAdapter;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.util.Date;
import java.util.List;

/**
 * @author Fedor Zholud
 *
 */

@XmlRootElement
@XmlJavaTypeAdapter(OrderDtoAdapter.class)
public class OrderDto extends BaseDto {

    private final long orderNumber;
    private final String customer;
    private final Date orderTime;
    private final List<OrderLineDto> orderList;

    public long getOrderNumber() {
        return orderNumber;
    }

    public String getCustomer() {
        return customer;
    }

    public Date getOrderTime() {
        return orderTime;
    }

    public List<OrderLineDto> getOrderList() {
        return orderList;
    }

    @SuppressWarnings("unused")
    private OrderDto() {
        this(0, null, null, null);
    }

    private OrderDto(
            long orderNumber,
            String customer,
            Date orderTime,
            List<OrderLineDto> orderList) {
        this.orderNumber = orderNumber;
        this.customer = customer;
        this.orderTime = orderTime;
        this.orderList = orderList;
    }

    public static OrdersDtoBuilder builder() {
        return new OrdersDtoBuilder();
    }

    public static class OrdersDtoBuilder {

        private long orderNumber;
        private String customer;
        private Date orderTime;
        private List<OrderLineDto> orderList;

        private OrdersDtoBuilder() {

        }

        public OrdersDtoBuilder setOrderNumber(long orderNumber) {
            this.orderNumber = orderNumber;
            return this;
        }

        public OrdersDtoBuilder setCustomer(String customer) {
            this.customer = customer;
            return this;
        }

        public OrdersDtoBuilder setOrderTime(Date orderTime) {
            this.orderTime = orderTime;
            return this;
        }

        public OrdersDtoBuilder setOrderList(List<OrderLineDto> orderList) {
            this.orderList = orderList;
            return this;
        }

        public OrderDto build() {
            return new OrderDto(this.orderNumber, this.customer, this.orderTime, this.orderList);
        }
    }
}
