<%--
  Created by IntelliJ IDEA.
  User: bolaj
  Date: 7/17/2019
  Time: 6:51 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Flights</title>
</head>
<body>
<h1>Flights</h1>
<table>
    <c:forEach var="flight" items="${flights}">
        <tr>
            <td>${flight.id}</td>
            <td>${flight.flightNumber}</td>
            <td>${flight.departureDate}</td>
            <td>${flight.arrivalDate}</td>
            <td>${flight.airplane}</td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
