<%@ page import="model.impl.OrderDto" %>
<%@ page import="javax.naming.InitialContext" %>
<%@ page import="controller.OrderController" %><%--
  Created by IntelliJ IDEA.
  User: fzholud
  Date: 05.06.2020
  Time: 12:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>UpdatingOrder</title>
</head>
<body>
<%
    InitialContext ic = new InitialContext();
    OrderController orderController = (OrderController) ic.lookup("java:app/" + application.getContextPath() + "/OrderControllerImpl");

    long orderNumber = Long.parseLong(request.getParameter("orderNumber"));
    OrderDto orderDto = orderController.getOrder(orderNumber);
    orderDto = OrderDto.builder()
            .setOrderNumber(orderDto.getOrderNumber())
            .setCustomer(request.getParameter("customer"))
            .setOrderTime(orderDto.getOrderTime())
            .setOrderList(orderDto.getOrderList())
            .build();
    orderController.updateOrder(orderDto);

    int ordersPage = 1;

    if(request.getParameter("page") != null)
        ordersPage = Integer.parseInt(request.getParameter("page"));

    request.setAttribute("ordersPage", ordersPage);
%>
<script>
    function goToOrderLine() {
        location.href='orders.jsp?page=${ordersPage}';
    }
    const nextPage = goToOrderLine();
</script>
</body>
</html>
