<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 8/13/2022
  Time: 9:10 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Order Details</title>
    <jsp:include page="../include/css.jsp"/>
</head>
<body>
    <div class="container">
    <table class="table">
        <thead class="thead-light">
        <tr>
            <th scope="col">SN</th>
            <th scope="col">Username</th>
            <th scope="col">Quantity</th>
            <th scope="col">Total Amount</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach varStatus="iStat" var="order" items="${orderDetails}">
            <tr>
                <td>${iStat.index + 1}</td>
                <td>${order.username}</td>
                <td>${order.quantity}</td>
                <td>${order.total}</td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>

</body>
</html>
