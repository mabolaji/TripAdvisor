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
    <title>Restaurants</title>
</head>
<body>
<h1>restaurants</h1>
<table>
    <c:forEach var="item" items="${restaurants}">
        <tr>
            <td>${item.name}</td>
            <td> <img src="${item.img_url}"></td>
            <td>
                <form action="book/${item.id}" method="post">
                    <button type="submit">Select</button>
                    <sec:csrfInput />
                </form>
            </td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
