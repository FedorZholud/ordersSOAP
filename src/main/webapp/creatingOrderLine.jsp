<%@ page import="javax.naming.InitialContext" %>
<%@ page import="service.OrderLineService" %>
<%@ page import="model.impl.OrderLineDto" %>
<%@ page import="controller.OrderLineController" %><%--
  Created by IntelliJ IDEA.
  User: fzholud
  Date: 04.06.2020
  Time: 15:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>CreatingOrderLine</title>
</head>
<body>
<%
    InitialContext ic = new InitialContext();
    OrderLineController orderLineController = (OrderLineController) ic.lookup("java:app/" + application.getContextPath() + "/OrderLineControllerImpl");

    OrderLineDto orderLineDto = OrderLineDto.builder()
            .setId(1)
            .setOrderNumber(Long.parseLong(request.getParameter("orderNumber")))
            .setGoodsId(Long.parseLong(request.getParameter("goodsId")))
            .setAmount(Integer.parseInt(request.getParameter("amount")))
            .setPrice(1)
            .setPriceSum(1)
            .build();

    orderLineController.createOrderLine(orderLineDto);
%>
<script>
    function goToOrderLine() {
        location.href='orderLine.jsp?orderNumber=<%=request.getParameter("orderNumber")%>';
    }
    const nextPage = goToOrderLine();
</script>
</body>
</html>
