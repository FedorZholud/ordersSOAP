<%@ page import="javax.naming.InitialContext" %>
<%@ page import="controller.OrderController" %><%--
  Created by IntelliJ IDEA.
  User: fzholud
  Date: 05.06.2020
  Time: 17:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>CreatingOrder</title>
</head>
<body>
<%
    InitialContext ic = new InitialContext();
    OrderController orderController = (OrderController) ic.lookup("java:app/" + application.getContextPath() + "/OrderControllerImpl");

    orderController.createOrder(request.getParameter("customer"));
%>
<script>
    function goToOrderLine() {
        location.href='orders.jsp';
    }
    const nextPage = goToOrderLine();
</script>
</body>
</html>
