package model;


import model.marshaling.OrdersDtoAdapter;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.sql.Timestamp;
import java.util.List;

/**
 * @author Fedor Zholud
 *
 */

@XmlRootElement
@XmlJavaTypeAdapter(OrdersDtoAdapter.class)
public class OrdersDto extends BaseDto {

    private final int id;
    private final int orderNumber;
    private final String customer;
    private final Timestamp orderTime;
    private final List<OrdersListDto> orderList;

    public int getId() {
        return id;
    }

    public int getOrderNumber() {
        return orderNumber;
    }

    public String getCustomer() {
        return customer;
    }

    public Timestamp getOrderTime() {
        return orderTime;
    }

    public List<OrdersListDto> getOrderList() {
        return orderList;
    }

    @SuppressWarnings("unused")
    private OrdersDto() {
        this(0, 0, null, null, null);
    }

    private OrdersDto(
            int id,
            int orderNumber,
            String customer,
            Timestamp orderTime,
            List<OrdersListDto> orderList) {
        this.id = id;
        this.orderNumber = orderNumber;
        this.customer = customer;
        this.orderTime = orderTime;
        this.orderList = orderList;
    }

    public static OrdersDtoBuilder builder() {
        return new OrdersDtoBuilder();
    }

    public static class OrdersDtoBuilder {

        private int id;
        private int orderNumber;
        private String customer;
        private Timestamp orderTime;
        private List<OrdersListDto> orderList;

        private OrdersDtoBuilder() {

        }

        public OrdersDtoBuilder setId(int id) {
            this.id = id;
            return this;
        }

        public OrdersDtoBuilder setOrderNumber(int orderNumber) {
            this.orderNumber = orderNumber;
            return this;
        }

        public OrdersDtoBuilder setCustomer(String customer) {
            this.customer = customer;
            return this;
        }

        public OrdersDtoBuilder setOrderTime(Timestamp orderTime) {
            this.orderTime = orderTime;
            return this;
        }

        public OrdersDtoBuilder setOrderList(List<OrdersListDto> orderList) {
            this.orderList = orderList;
            return this;
        }

        public OrdersDto build() {
            return new OrdersDto(this.id, this.orderNumber, this.customer, this.orderTime, this.orderList);
        }
    }
}
