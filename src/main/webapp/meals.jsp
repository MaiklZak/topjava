<%--
  Created by IntelliJ IDEA.
  User: zekar
  Date: 07.02.2021
  Time: 18:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
<html>
<head>
    <title>Meals</title>
</head>
<body>
    <h3><a href="index.html">Home</a></h3>
    <h2>Look at meals.jsp</h2>
    <table border="1" cellspacing="0" cellpadding="2">
        <tr>
            <th>Description</th>
            <th>Date</th>
            <th>Calories</th>
            <th>Excess</th>
            <th>id</th>
        </tr>
        <c:forEach var="num" items="${listMealTo}">
            <tr style="color:${num.excess ? 'green' : 'red'}">
                <td>${num.description}</td>
                <td>${num.dateForm}</td>
                <td>${num.calories}</td>
                <td>${num.excess}</td>
                <td>${num.id}</td>
            </tr>
        </c:forEach>
    </table>
</body>
</html>
