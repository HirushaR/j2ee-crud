<%--
  Created by IntelliJ IDEA.
  User: Danuja Fernando
  Date: 8/25/2020
  Time: 10:01 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Edit</title>
</head>
<body>
<h1>Edit</h1>
<form action="edit" method="post">
    <c:forEach items="${GetNewsById}" var="p">
        <input type="hidden" name="id" value="${p.id}">
        Name: <br>
        <input type="text" name="name" value="${p.name}" style="width: 200px"><br>
        School: <br>
        <input type="text" name="school" value="${p.school}" style="width: 200px"><br>
        Age: <br>
        <input type="number" name="age"value="${p.age}" style="width: 200px"><br>
        <input type="submit" value="Submit">
    </c:forEach>

</form>
</body>
</html>
