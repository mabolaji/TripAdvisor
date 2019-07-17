<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    <!--script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.4.1/jquery.min.js"/-->
    <script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>

    <script type="text/javascript">

        $(document).ready(function () {
            $('#originId').change(function () {
                $( "#booking" ).submit();
            })
            
            $('#search').click(function () {
                $( "#booking" ).submit({url: '/search', type: 'post'});
            })
        });
    </script>

    <title>Home Page</title>
</head>
<body>
<h1>Hello</h1>

<form:form modelAttribute="booking" method="post">
    <form:errors path="*" element="div" cssClass="error"/>
    <table>
        <tr>
            <td>Origin:</td>
            <td>
                <form:select path="originId" itemValue="id" title="country">
                    <form:option value="">--select origin--</form:option>
                    <form:options itemValue="id" itemLabel="name" items="${origins}"/>
                </form:select>
            </td>
            <td>
                <form:errors path="originId"/>
            </td>
        </tr>
        <tr>
            <td>destinations:</td>
            <td>
                <form:select path="destinationId" itemValue="id" title="country">
                    <form:option value="">--select origin--</form:option>
                    <form:options itemValue="id" itemLabel="name" items="${destinations}"/>
                </form:select>
            </td>
            <td>
                <form:errors path="originId"/>
            </td>
        </tr>

        <tr>
            <td>Departure Date</td>
            <td>
                <form:input type="date" pattern="yyyy-MM-dd" path="from" class="date-picker" />
            </td>
        </tr>
        <tr>
            <td>Return Date</td>
            <td>
                <form:input type="date" path="to" pattern="yyyy-MM-dd" class="date-picker" />
            </td>
        </tr>
    <%--<tr>
                <td>Title:</td>
                <td>
                    <form:input path="title" />
                </td>
                <td>
                    <form:errors path="title" />
                </td>
            </tr>
            <tr>
                <td>ISBN:</td>
                <td>
                    <form:input path="ISBN" />
                </td>
                <td>
                    <form:errors path="ISBN" />
                </td>
            </tr>
            <tr>
                <td>Author:</td>
                <td>
                    <form:input path="author" />
                </td>
                <td>
                    <form:errors path="author" />
                </td>
            </tr>
            <tr>
                <td>Price:</td>
                <td>
                    <form:input path="price" />
                </td>
                <td>
                    <form:errors path="price" />
                </td>
            </tr>  --%>
    </table>
    <button id="search" name="search" type="button">Search</button>
</form:form>

</body>
</html>