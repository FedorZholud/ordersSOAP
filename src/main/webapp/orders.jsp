<%--
  Created by IntelliJ IDEA.
  User: fzholud
  Date: 29.05.2020
  Time: 15:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="entity.*" %>
<%@ page import="repository.*" %>
<%@ page import="service.*" %>
<%@ page import="model.*" %>
<%@ page import="mapper.*" %>
<%@ page import="app.*" %>
<%@ page import="javax.naming.Context" %>
<%@ page import="javax.naming.InitialContext" %>
<%@ page import="javax.ejb.EJB" %>
<%@ page import="service.impl.OrderServiceImpl" %>
<%@ page import="repository.impl.OrderJpaRepository" %>
<%@ page import="model.impl.OrderDto" %>
<%@ page import="java.util.List" %>
<%@ page import="entity.impl.OrderEntity" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.stream.Collectors" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <link href="index.css" rel="stylesheet">
    <title>Orders</title>
</head>
<body>
<%--<%--%>
<%--    InitialContext ic = new InitialContext();--%>
<%--    OrderJpaRepository orderJpaRepository = (OrderJpaRepository) ic.lookup("java:app/" + application.getContextPath() + "/OrderJpaRepository");--%>
<%--%>--%>
<%
    InitialContext ic = new InitialContext();
    OrderService orderService = (OrderService) ic.lookup("java:app/" + application.getContextPath() + "/OrderServiceImpl");
%>
<header>
    <h1>Active Orders</h1>
</header>
<script>
    function winOpen(orderNumber) {
        // window.open("index.jsp", null, scrollbars="1", height="150", width="250", toolbar="no", menubar="no", status="yes");
        window.open("orderLine.jsp?orderNumber=" + orderNumber, null,
            "height=400,width=600,status=yes,toolbar=no,menubar=no,location=no")
    }
</script>
<div class="dataTables">
    <%--    <%List<OrderEntity> orderEntities = orderJpaRepository.findAll(1, 10);%>--%>
    <%--    <%request.setAttribute("orders", orderEntities);%>--%>
    <%
        List<OrderDto> orderDtos = orderService.getAllOrders(1, 10);
        request.setAttribute("orders", orderDtos);
    %>
<%--    <%!--%>
<%--        public OrderDto findOrder(List<OrderDto> list, long orderNumber) {--%>
<%--            return list.stream()--%>
<%--                    .filter(orderDto -> orderDto.getOrderNumber() == orderNumber)--%>
<%--                    .collect(Collectors.toList()).get(0);--%>
<%--        }--%>
<%--    %>--%>
    <table border="1" cellpadding="5" align="center" style="border-collapse: collapse; border: black 2px solid">
        <caption><h2>List of orders</h2></caption>
        <tr bgcolor="#a9a9a9" style="border: black 2px solid">
            <th style="border: black 2px solid">OrderNumber</th>
            <th style="border: black 2px solid">Customer</th>
            <th style="border: black 2px solid">Timestamp</th>
            <th style="border: black 2px solid">OrderLine</th>
            <th style="border: black 2px solid"/>
            <th style="border: black 2px solid"/>
        </tr>
        <c:set var="i" value="0"/>
        <c:forEach var="order" items="${orders}">
            <tr>
                <td><c:out value="${orders.get(i).orderNumber}"/></td>
                <td><c:out value="${orders.get(i).customer}"/></td>
                <td><c:out value="${orders.get(i).orderTime}"/></td>
                <td>
                    <c:if test="${orders.get(i).orderList.size() != 0}">
                        <button onclick="winOpen(${orders.get(i).orderNumber})">Show OrderLine</button>
                    </c:if>
                </td>
                <td><button>Update</button></td>
                <td><button>Delete</button></td>
                    <%--                    <td>--%>
                    <%--                        <table align="center">--%>
                    <%--                            <tr>--%>
                    <%--                                <th>Id</th>--%>
                    <%--                                <th>GoodsId</th>--%>
                    <%--                                <th>Amount</th>--%>
                    <%--                                <th>Price</th>--%>
                    <%--                                <th>PriceSum</th>--%>
                    <%--                            </tr>--%>
                    <%--                            <c:set var="j" value="0"/>--%>
                    <%--                            <c:forEach var="order" items="${orders.get(i).orderList}">--%>
                    <%--                                <td><c:out value="${orders.get(i).orderList.get(j).id}"/></td>--%>
                    <%--                                <td><c:out value="${orders.get(i).orderList.get(j).goodsId}"/></td>--%>
                    <%--                                <td><c:out value="${orders.get(i).orderList.get(j).amount}"/></td>--%>
                    <%--                                <td><c:out value="${orders.get(i).orderList.get(j).price}"/></td>--%>
                    <%--                                <td><c:out value="${orders.get(i).orderList.get(j).priceSum}"/></td>--%>
                    <%--                                <c:set var="j" value="${j+1}"/>--%>
                    <%--                            </c:forEach>--%>
                    <%--                        </table>--%>
                    <%--                    </td>--%>
            </tr>
            <c:set var="i" value="${i+1}"/>
        </c:forEach>
    </table>
</div>
</body>
</html>
