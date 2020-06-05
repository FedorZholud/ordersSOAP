<%@ page import="model.impl.OrderLineDto" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.Arrays" %>
<%@ page import="javax.naming.InitialContext" %>
<%@ page import="service.OrderService" %>
<%@ page import="service.GoodsService" %>
<%@ page import="app.OrdersSOAPService" %>
<%@ page import="controller.OrderController" %>
<%@ page import="controller.GoodsController" %>
<%@ page import="controller.OrderLineController" %><%--
  Created by IntelliJ IDEA.
  User: fzholud
  Date: 02.06.2020
  Time: 13:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <link href="index.css" rel="stylesheet">
    <title>OrderLine</title>
</head>
<body>
<%
    InitialContext ic = new InitialContext();
    OrderController orderController = (OrderController) ic.lookup("java:app/" + application.getContextPath() + "/OrderControllerImpl");

    OrderLineController orderLineController = (OrderLineController) ic.lookup("java:app/" + application.getContextPath() + "/OrderLineControllerImpl");
    request.setAttribute("orderLineController", orderLineController);

    GoodsController goodsController = (GoodsController) ic.lookup("java:app/" + application.getContextPath() + "/GoodsControllerImpl");
    request.setAttribute("goodsController", goodsController);

    long orderNumber = Long.parseLong(request.getParameter("orderNumber"));

    List<OrderLineDto> orderLineDtos = orderController.getOrder(orderNumber).getOrderList();
    request.setAttribute("orderLineDtos", orderLineDtos);
%>
<table border="1" cellpadding="5" style="border-collapse: collapse; margin: 10px; border: black 2px solid">
    <tr bgcolor="#a9a9a9">
        <th style="border: black 2px solid; padding-left: 10px; padding-right: 10px">GoodsName</th>
        <th style="border: black 2px solid; padding-left: 10px; padding-right: 10px">Amount</th>
        <th style="border: black 2px solid; padding-left: 10px; padding-right: 10px">Price</th>
        <th style="border: black 2px solid; padding-left: 10px; padding-right: 10px">PriceSum</th>
        <th style="border: black 2px solid"/>
        <th style="border: black 2px solid"/>
    </tr>
    <c:set var="j" value="0"/>
    <c:forEach var="orderLine" items="${orderLineDtos}">
        <tr>
            <td><c:out value="${goodsController.getGoodsById(orderLineDtos.get(j).goodsId).name}"/></td>
            <td><c:out value="${orderLineDtos.get(j).amount}"/></td>
            <td><c:out value="${orderLineDtos.get(j).price}"/></td>
            <td><c:out value="${orderLineDtos.get(j).priceSum}"/></td>
            <td>
                <button onclick="location.href = 'updateOrderLine.jsp?orderNumber=<%=orderNumber%>&id=${orderLineDtos.get(j).id}'">
                    Update
                </button>
            </td>
            <td>
<%--                <button onclick="${orderLineController.deleteOrderLine(orderLineDtos.get(j))}--%>
<%--                        location.href='orderLine.jsp?orderNumber=<%=orderNumber%>'">Delete</button>--%>
                <button onclick="location.href='deletingOrderLine.jsp?orderNumber=<%=orderNumber%>&id=${orderLineDtos.get(j).id}'">Delete</button>
<%--                <button>Delete</button>--%>
            </td>
        </tr>
        <c:set var="j" value="${j+1}"/>
    </c:forEach>
</table>
<button onclick="location.href = 'createOrderLine.jsp?orderNumber=<%=orderNumber%>'" style="margin-left: 10px">
    Create OrderLine
</button>
<script>
    window.onunload = refreshParent;
    function refreshParent() {
        window.opener.location.reload();
    }
</script>
</body>
</html>
