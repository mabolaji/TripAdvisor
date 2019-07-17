<%--
  Created by IntelliJ IDEA.
  User: bolaj
  Date: 7/17/2019
  Time: 6:51 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>


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
            <td>
                <form action="book/${flight.id}" method="post">
                    <button type="submit">Book</button>
                    <sec:csrfInput />
                </form>
            </td>
        </tr>
    </c:forEach>
</table>
</body>
</html>