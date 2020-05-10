package model.marshaling;

import model.OrdersListDto;


import java.util.List;

/**
 * @author Fedor Zholud
 *
 */

public class AdaptedOrdersDto {

    private long orderNumber;
    private String customer;
    private String orderTime;
    private List<OrdersListDto> orderList;

    public void setOrderNumber(long orderNumber) {
        this.orderNumber = orderNumber;
    }

    public void setCustomer(String customer) {
        this.customer = customer;
    }

    public void setOrderTime(String orderTime) {
        this.orderTime = orderTime;
    }

    public void setOrderList(List<OrdersListDto> orderList) {
        this.orderList = orderList;
    }

    public long getOrderNumber() {
        return orderNumber;
    }

    public String getCustomer() {
        return customer;
    }

    public String getOrderTime() {
        return orderTime;
    }

    public List<OrdersListDto> getOrderList() {
        return orderList;
    }
}
