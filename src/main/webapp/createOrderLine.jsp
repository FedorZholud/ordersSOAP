<%@ page import="app.OrdersSOAPService" %>
<%@ page import="javax.naming.InitialContext" %>
<%@ page import="model.impl.OrderLineDto" %>
<%@ page import="model.impl.GoodsDto" %>
<%@ page import="java.util.List" %>
<%@ page import="service.OrderLineService" %>
<%@ page import="service.GoodsService" %><%--
  Created by IntelliJ IDEA.
  User: fzholud
  Date: 03.06.2020
  Time: 15:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Create OrderLine</title>
</head>
<body>
<%
    InitialContext ic = new InitialContext();
    OrderLineService orderLineService = (OrderLineService) ic.lookup("java:app/" + application.getContextPath() + "/OrderLineServiceImpl");

    GoodsService goodsService = (GoodsService) ic.lookup("java:app/" + application.getContextPath() + "/GoodsServiceImpl");

//    long id = Long.parseLong(request.getParameter("id"));
//
//    OrderLineDto orderLineDto = orderLineService.getOrderLine(id);

    List<GoodsDto> goodsDtos = goodsService.findAllGoods(1, 10);
    request.setAttribute("goods", goodsDtos);
%>
<input type="number" value="amount">
<form action="createOrderLine.jsp">
    <select name="goodsId">
        <c:set var="i" value="0"/>
        <c:forEach var="good" items="${goods}">
            <option value="${goods.get(i).id}">${goods.get(i).name}</option>
            <c:set var="i" value="${i+1}"/>
        </c:forEach>
    </select>
<%--    <input type="submit" value="Submit">--%>
</form>
<button onclick="location.href = 'orderLine.jsp?orderNumber=<%=request.getParameter("orderNumber")%>'">Create</button>
</body>
</html>
