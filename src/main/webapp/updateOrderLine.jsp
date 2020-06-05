<%@ page import="javax.naming.InitialContext" %>
<%@ page import="model.impl.OrderLineDto" %>
<%@ page import="model.impl.GoodsDto" %>
<%@ page import="controller.OrderLineController" %>
<%@ page import="controller.GoodsController" %>
<%--
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
    OrderLineController orderLineController = (OrderLineController) ic.lookup("java:app/" + application.getContextPath() + "/OrderLineControllerImpl");

    GoodsController goodsController = (GoodsController) ic.lookup("java:app/" + application.getContextPath() + "/GoodsControllerImpl");

    long id = Long.parseLong(request.getParameter("id"));

    request.setAttribute("orderLineController", orderLineController);

    OrderLineDto orderLineDto = orderLineController.getOrderLine(id);
    request.setAttribute("orderLineDto", orderLineDto);

    GoodsDto goodsDto = goodsController.getGoodsById(orderLineDto.getGoodsId());
    request.setAttribute("goodsDto", goodsDto);
    request.setAttribute("amount", 15);

    int amount = request.getParameter("amount") == null ? orderLineDto.getAmount() : Integer.parseInt(request.getParameter("amount"));
%>
<div style="margin-top: 10px; margin-left: 10px">GoodsName: <%=goodsDto.getName()%>
</div>
<br/>
<div style="margin-left: 10px">
    <form id="form1" action="updateOrderLine.jsp">

        <input type="hidden" name="orderNumber" value="<%=orderLineDto.getOrderNumber()%>">
        <input type="hidden" name="id" value="<%=orderLineDto.getId()%>">
        Amount: <input id="amount" name="amount" type="number"
                       value="<%=amount%>" onchange="this.form.submit()">
    </form>
</div>
<br/>
<div style="margin-left: 10px">Price: <%=orderLineDto.getPrice()%>
</div>
<br/>
<div style="margin-left: 10px">PriceSum: <%=orderLineDto.getPriceSum()%>
</div>
<br/>
<%--<form action="updateOrderLine.jsp">--%>
<%--    <select name="goodsId">--%>
<%--        <c:set var="i" value="0"/>--%>
<%--        <c:forEach var="good" items="${goods}">--%>
<%--            <option value="${goods.get(i).id}">${goods.get(i).name}</option>--%>
<%--            <c:set var="i" value="${i+1}"/>--%>
<%--        </c:forEach>--%>
<%--    </select>--%>
<%--</form>--%>
<%
    if (request.getParameter("amount") != null) {
        OrderLineDto updatedOrderLineDto = OrderLineDto.builder()
                .setId(orderLineDto.getId())
                .setOrderNumber(orderLineDto.getOrderNumber())
                .setGoodsId(orderLineDto.getGoodsId())
                .setAmount(amount)
                .setPrice(orderLineDto.getPrice())
                .setPriceSum(orderLineDto.getPriceSum())
                .build();

        orderLineController.updateOrderLine(updatedOrderLineDto);
    }
%>
<button style="margin-left: 10px; font-size: 16px" onclick="location.href = 'orderLine.jsp?orderNumber=<%=orderLineDto.getOrderNumber()%>'">
    Save
</button>
</body>
</html>
