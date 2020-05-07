package model.marshaling;

import model.OrdersListDto;

import java.sql.Timestamp;
import java.util.List;

/**
 * @author Fedor Zholud
 *
 */

public class AdaptedOrdersDto {

    private int id;
    private int orderNumber;
    private String customer;
    private String orderTime;
    private List<OrdersListDto> orderList;

    public void setId(int id) {
        this.id = id;
    }

    public void setOrderNumber(int orderNumber) {
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

    public int getId() {
        return id;
    }

    public int getOrderNumber() {
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
