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
<%@ page import="controller.OrderController" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <link href="index.css" rel="stylesheet">
    <title>Orders</title>
</head>
<body style="margin: 0 auto">
<%--<%--%>
<%--    InitialContext ic = new InitialContext();--%>
<%--    OrderJpaRepository orderJpaRepository = (OrderJpaRepository) ic.lookup("java:app/" + application.getContextPath() + "/OrderJpaRepository");--%>
<%--%>--%>
<%
    InitialContext ic = new InitialContext();
    OrderController orderController = (OrderController) ic.lookup("java:app/" + application.getContextPath() + "/OrderControllerImpl");
%>
<header style="background-image: linear-gradient(to bottom,deepskyblue, white); height: 10%">
    <h1>Active Orders</h1>
</header>
<script>
    function winOpen(orderNumber) {
        // window.open("index.jsp", null, scrollbars="1", height="150", width="250", toolbar="no", menubar="no", status="yes");
        window.open("orderLine.jsp?orderNumber=" + orderNumber, null,
            "height=400,width=600,status=yes,toolbar=no,menubar=no,location=no")
    }
</script>
<div style="display: table; margin: 0 auto">
<div class="dataTables">
    <%--    <%List<OrderEntity> orderEntities = orderJpaRepository.findAll(1, 10);%>--%>
    <%--    <%request.setAttribute("orders", orderEntities);%>--%>
    <%
        int ordersPage = 1;

        if (request.getParameter("page") != null) {
            ordersPage = Integer.parseInt(request.getParameter("page"));
        }

        request.setAttribute("ordersPage", ordersPage);

        final int PAGE_SIZE = 5;

        int nextPage = orderController.getAllOrders(ordersPage + 1, PAGE_SIZE).size();
        request.setAttribute("nextPage", nextPage);

        List<OrderDto> orderDtos = orderController.getAllOrders(ordersPage, PAGE_SIZE);
        request.setAttribute("orders", orderDtos);
    %>
<%--    <%!--%>
<%--        public OrderDto findOrder(List<OrderDto> list, long orderNumber) {--%>
<%--            return list.stream()--%>
<%--                    .filter(orderDto -> orderDto.getOrderNumber() == orderNumber)--%>
<%--                    .collect(Collectors.toList()).get(0);--%>
<%--        }--%>
<%--    %>--%>
    <table border="1" cellpadding="5" align="center" style="border-collapse: collapse; border: black 2px solid; margin: 5px">
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
                <td id="customerRow + ${i}"><c:out value="${orders.get(i).customer}"/></td>
                <td><c:out value="${orders.get(i).orderTime}"/></td>
                <td>
                    <c:if test="${orders.get(i).orderList.size() != 0}">
                        <button onclick="winOpen(${orders.get(i).orderNumber})">Show OrderLine</button>
                    </c:if>
                    <c:if test="${orders.get(i).orderList.size() == 0}">
                        <button onclick="winOpen(${orders.get(i).orderNumber})">Add OrderLine</button>
                    </c:if>
                </td>
                <td>
                    <button onclick="document.getElementById('customerRow + ${i}').contentEditable = 'true';
                document.getElementById('customerRow + ${i}').focus(); this.style = 'display: none;';
                            document.getElementById('saveButton + ${i}').style.display = 'block'">Update</button>
                    <script>
                        function getNewUrlWithCustomer() {
                            let baseUrl = 'orders.jsp?'

                            let customerParam = 'customer=' + document.getElementById('customerRow${i}').textContent;
                            let orderNumberParam = 'orderNumber=' + ${orders.get(i).orderNumber};

                            return baseUrl + orderNumberParam + '&' + customerParam;
                        }
                    </script>
<%--                    <button id="saveButton + ${i}" style="display: none" onclick="location.reload()">Save</button>--%>
                    <button id="saveButton + ${i}" style="display: none"
                            onclick="location.href = 'updatingOrder.jsp?orderNumber=' + ${orders.get(i).orderNumber} + '&customer=' + document.getElementById('customerRow + ${i}').textContent">Save</button>
                </td>
                <td><button onclick="location.href = 'deletingOrder.jsp?orderNumber=${orders.get(i).orderNumber}&page=${ordersPage}'">Delete</button></td>
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
    <div>
        <button onclick="location.href = 'createOrder.jsp'">Create new order</button>
    </div>
    <div>
        <c:if test="${ordersPage != 1}">
            <button onclick="location.href = 'orders.jsp?page=${ordersPage - 1}'">< Previous</button>
        </c:if>
        <c:if test="${nextPage != 0}">
            <button style="float: right" onclick="location.href = 'orders.jsp?page=${ordersPage + 1}'">Next ></button>
        </c:if>
    </div>
</div>
<script>
    if (window.performance && window.performance.navigation.type == window.performance.navigation.TYPE_BACK_FORWARD) {
        location.href = "index.jsp";
    }
</script>
</body>
</html>
