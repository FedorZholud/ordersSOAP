<%@ page import="javax.naming.InitialContext" %>
<%@ page import="controller.OrderLineController" %><%--
  Created by IntelliJ IDEA.
  User: fzholud
  Date: 04.06.2020
  Time: 16:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>DeletingOrderLine</title>
</head>
<body>
<%
    InitialContext ic = new InitialContext();

    OrderLineController orderLineController = (OrderLineController) ic.lookup("java:app/" + application.getContextPath() + "/OrderLineControllerImpl");
    long id = orderLineController.deleteOrderLine(orderLineController.getOrderLine(Long.parseLong(request.getParameter("id"))));
%>
<script>
    function goToOrderLine() {
        location.href='orderLine.jsp?orderNumber=<%=request.getParameter("orderNumber")%>';
    }
    const nextPage = goToOrderLine();
</script>
</body>
</html>
