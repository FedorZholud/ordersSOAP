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
    <title>Update OrderLine</title>
</head>
<body>
<%
    InitialContext ic = new InitialContext();
    OrderLineService orderLineService = (OrderLineService) ic.lookup("java:app/" + application.getContextPath() + "/OrderLineServiceImpl");

    GoodsService goodsService = (GoodsService) ic.lookup("java:app/" + application.getContextPath() + "/GoodsServiceImpl");

    long id = Long.parseLong(request.getParameter("id"));

    request.setAttribute("orderLineService", orderLineService);

    OrderLineDto orderLineDto = orderLineService.getOrderLine(id);
    request.setAttribute("orderLineDto", orderLineDto);

    GoodsDto goodsDto = goodsService.findGoodsById(orderLineDto.getGoodsId());
    request.setAttribute("goodsDto", goodsDto);
%>
<div style="margin: 10px">GoodsName: <%=goodsDto.getName()%></div><br/>
Amount: <input type="number" value="amount" content="<%=orderLineDto.getAmount()%>"><br/>
<%--<form action="updateOrderLine.jsp">--%>
<%--    <select name="goodsId">--%>
<%--        <c:set var="i" value="0"/>--%>
<%--        <c:forEach var="good" items="${goods}">--%>
<%--            <option value="${goods.get(i).id}">${goods.get(i).name}</option>--%>
<%--            <c:set var="i" value="${i+1}"/>--%>
<%--        </c:forEach>--%>
<%--    </select>--%>
<%--</form>--%>
<button onclick="location.href='orderLine.jsp?orderNumber=<%=orderLineDto.getOrderNumber()%>'">Save</button>
</body>
</html>
