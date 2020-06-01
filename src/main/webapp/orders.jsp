<%--
  Created by IntelliJ IDEA.
  User: fzholud
  Date: 29.05.2020
  Time: 15:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" import="app.impl.OrdersSOAPServiceImpl" %>
<%@ page import="app.OrdersSOAPService" %>
<%@ page import="javax.ejb.EJB" %>
<%@ page import="service.OrderService" %>
<%@ page import="service.impl.OrderServiceImpl" %>
<%@ page import="java.util.List" %>
<%@ page import="entity.impl.GoodsEntity" %>
<html>
<head>
    <link href="index.css" rel="stylesheet">
    <title>Orders</title>
</head>
<body>
<header>
    <h1>Active Orders</h1>
</header>
<div class="dataTables">
<%--        <jsp:useBean id="OrderService" class="service.impl.OrderServiceImpl" scope="session"/>--%>

<%--        OrdersSOAPService: <%= OrderService.getAllOrders(1, 10)%>--%>
    <jsp:useBean id="Goods" class="entity.impl.GoodsEntity" />
    <jsp:useBean id="GoodsJpaRepository" class="repository.impl.GoodsJpaRepository"/>
    <%
        Goods = GoodsJpaRepository.find(1);
    %>
</div>
</body>
</html>
