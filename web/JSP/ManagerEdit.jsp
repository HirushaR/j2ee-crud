<%@ page import="model.News" %>
<%@ page import="dao.DataAccess" %><%--
  Created by IntelliJ IDEA.
  User: Danuja Fernando
  Date: 8/25/2020
  Time: 10:03 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%

    int id = Integer.parseInt(request.getParameter("id"));
    String name = request.getParameter("name");
    String school = request.getParameter("school");
    int age = Integer.parseInt(request.getParameter("age"));

    News n = new News(id,name,school,age);
    DataAccess da = new DataAccess();
    da.edit(n);

    response.sendRedirect("/test01_war_exploded/AllPost");
%>
</body>
</html>
