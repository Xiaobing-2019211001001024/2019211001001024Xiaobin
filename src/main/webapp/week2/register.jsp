<%--
  Created by IntelliJ IDEA.
  User: 86189
  Date: 2021/5/18
  Time: 21:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>

<head>

    <title>Title</title>

    <style>

        td.right{

            text-align: right;

            height: 25px;

        }

    </style>

</head>

<body>

<%@include file="/header.jsp"%>

This is my JSP page.<br>

<h1>New User Registration</h1>

<form method="post" action="/2019211001000713ZhouWeiqiang_war_exploded/Register">

    <table>

        <tr> <td class="right">Username：</td> <td><input type="text" name="Username" required><br/></td></tr>

        <tr> <td class="right">password：</td> <td><input type="password" name="password" required minlength="8"><br/></td></tr>

        <tr> <td class="right">Email：</td> <td><input type="email" name="Email" required><br/></td></tr>

        <tr>

            <td class="right">Gender：</td>

            <td>

                <input type="radio" name="Gender" value="Male" checked="checked"/> Male <!-- checked="checked"默认选择项 -->

                <input type="radio" name="Gender" value="Female"/> Female

            </td>

        </tr>

        <tr> <td class="right">Date of Birth：</td> <td><input type="date" name="Date" required dataformatas="yyyy-dd-mm"><br/></td></tr>

        <tr> <td></td><td><input type="submit" value="Register"/></td>  </tr>

    </table>

</form>

<%@include file="/footer.jsp"%>

</body>

</html>
