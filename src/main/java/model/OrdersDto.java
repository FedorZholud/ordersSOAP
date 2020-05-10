package model;


import model.marshaling.OrdersDtoAdapter;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.util.Date;
import java.util.List;

/**
 * @author Fedor Zholud
 *
 */

@XmlRootElement
@XmlJavaTypeAdapter(OrdersDtoAdapter.class)
public class OrdersDto extends BaseDto {

    private final long orderNumber;
    private final String customer;
    private final Date orderTime;
    private final List<OrdersListDto> orderList;

    public long getOrderNumber() {
        return orderNumber;
    }

    public String getCustomer() {
        return customer;
    }

    public Date getOrderTime() {
        return orderTime;
    }

    public List<OrdersListDto> getOrderList() {
        return orderList;
    }

    @SuppressWarnings("unused")
    private OrdersDto() {
        this(0, null, null, null);
    }

    private OrdersDto(
            long orderNumber,
            String customer,
            Date orderTime,
            List<OrdersListDto> orderList) {
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
        private List<OrdersListDto> orderList;

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

        public OrdersDtoBuilder setOrderList(List<OrdersListDto> orderList) {
            this.orderList = orderList;
            return this;
        }

        public OrdersDto build() {
            return new OrdersDto(this.orderNumber, this.customer, this.orderTime, this.orderList);
        }
    }
}
