<%--
  Created by IntelliJ IDEA.
  User: fzholud
  Date: 05.06.2020
  Time: 15:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link href="index.css" rel="stylesheet">
    <title>Create Order</title>
</head>
<body>
<h1>Create new order</h1>
<form action="createOrder.jsp">
    Enter your E-Mail: <input name="customer" type="text"
                    onchange="this.form.submit()">
</form>
</body>
</html>
