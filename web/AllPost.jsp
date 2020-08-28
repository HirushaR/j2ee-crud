<%--
  Created by IntelliJ IDEA.
  User: Danuja Fernando
  Date: 8/25/2020
  Time: 8:02 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>All Post</title>
</head>
<body>
<table cellpadding="10">
    <tr>
        <th>ID</th>
        <th>Name</th>
        <th>School</th>
        <th>Age</th>
    </tr>
    <c:forEach items ="${AllPost}" var ="p">
        <tr>
            <td>${p.id}</td>
            <td>${p.name}</td>
            <td>${p.school}</td>
            <td>${p.age}</td>
            <td>
                <a href="edit?id=${p.id}">Edit</a>
                <a href="delete?id=${p.id}">Delete</a>
            </td>
        </tr>
    </c:forEach>
</table>

</body>
</html>
