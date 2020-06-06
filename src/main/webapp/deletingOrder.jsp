<%@ page import="javax.naming.InitialContext" %>
<%@ page import="controller.OrderController" %><%--
  Created by IntelliJ IDEA.
  User: fzholud
  Date: 06.06.2020
  Time: 13:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>DeletingOrder</title>
</head>
<body>
<%
    InitialContext ic = new InitialContext();
    OrderController orderController = (OrderController) ic.lookup("java:app/" + application.getContextPath() + "/OrderControllerImpl");

    long orderNumber = Long.parseLong(request.getParameter("orderNumber"));

    orderController.deleteOrder(orderNumber);

    int ordersPage = 1;

    if(request.getParameter("page") != null)
        ordersPage = Integer.parseInt(request.getParameter("page"));

    request.setAttribute("ordersPage", ordersPage);
%>

<script>
    function goToOrderLine() {
        location.href='orders.jsp?page=${ordersPage}';
    }
    const nextPage = goToOrderLine();
</script>
</body>
</html>
