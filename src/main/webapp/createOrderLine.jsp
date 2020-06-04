<%@ page import="app.OrdersSOAPService" %>
<%@ page import="javax.naming.InitialContext" %>
<%@ page import="model.impl.OrderLineDto" %>
<%@ page import="model.impl.GoodsDto" %>
<%@ page import="java.util.List" %>
<%@ page import="service.OrderLineService" %>
<%@ page import="service.GoodsService" %>
<%@ page import="controller.GoodsController" %>
<%@ page import="controller.OrderLineController" %><%--
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
    GoodsController goodsController = (GoodsController) ic.lookup("java:app/" + application.getContextPath() + "/GoodsControllerImpl");

    List<GoodsDto> goodsDtos = goodsController.getAllGoods(1, 10);
    request.setAttribute("goods", goodsDtos);
%>
<form action="creatingOrderLine.jsp" method="post">
    <div style="margin-left: 10px; margin-top: 10px">
        <input type="hidden" name="orderNumber" value="<%=request.getParameter("orderNumber")%>"/>
        <select name="goodsId">
            <c:set var="i" value="0"/>
            <c:forEach var="good" items="${goods}">
                <option value="${goods.get(i).id}" style="font-size: 16px">${goods.get(i).name}</option>
                <c:set var="i" value="${i+1}"/>
            </c:forEach>
        </select>
    </div>
    <div style="margin-left: 10px; margin-top: 10px">
        <input id="amount" name="amount" type="number">
    </div>
    <button style="margin-left: 10px; margin-top: 10px; font-size: 16px"
            onclick="this.form.submit();
                    location.href = 'orderLine.jsp?orderNumber=<%=request.getParameter("orderNumber")%>'">Create
    </button>
</form>
</body>
</html>
