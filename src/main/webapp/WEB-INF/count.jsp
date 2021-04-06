<%--
  Created by IntelliJ IDEA.
  User: 86189
  Date: 2021/4/6
  Time: 18:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Count JSP</title>
</head>
<body>
This is Count JSP page.<br>
<%!int count=0;  %>
this Page count is now :<%out.println(++count); %>
</body>
</html>
