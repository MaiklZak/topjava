<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://topjava.javawebinar.ru/functions" %>
<html>
<head>
    <title>Meals</title>
</head>
<body>
    <h3><a href="index.html">Home</a></h3>
    <h2>Look at meals.jsp</h2>
    <table border="1" cellspacing="0" cellpadding="8">
        <tr>
            <th>Description</th>
            <th>Date</th>
            <th>Calories</th>
        </tr>
        <c:forEach var="num" items="${listMealTo}">
            <jsp:useBean id="num" type="ru.javawebinar.topjava.model.MealTo"></jsp:useBean>
            <tr style="color:${num.excess ? 'green' : 'red'}">
                <td>${fn:formatDateTime(num.dateTime)}</td>
                <td>${num.description}</td>
                <td>${num.calories}</td>
            </tr>
        </c:forEach>
    </table>
</body>
</html>
