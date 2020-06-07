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
<body style="margin: 0 auto">
<header style="background-image: linear-gradient(to bottom,deepskyblue, white); height: 10%">
    <h1>Create new order</h1>
</header>
<div style="text-align: center">
    <form action="creatingOrder.jsp" method="post">
        Enter your E-Mail: <input name="customer" type="text">
        <button type="submit" onclick="this.form.submit()">Create</button>
    </form>
</div>
</body>
</html>
