<%--
  Created by IntelliJ IDEA.
  User: 86189
  Date: 2021/4/20
  Time: 22:19
  To change this template use File | Settings | File Templates.
--%>
<%@include file="header.jsp"%>

<h1>Login</h1>

<%

    if(request.getAttribute("message")!=null){

        out.println(request.getAttribute("message"));

    }

%>

<form method="post" action="/2019211001001024ZhouXiaoBing_war_exploded/login">

    <table>

        <tr> <td>Username:</td> <td><input type="text" name="Username" required><br/></td></tr>

        <tr> <td>password:</td> <td><input type="password" name="password" required minlength="8"><br/></td></tr>

        <tr> <td></td><td><input type="submit" value="Login"/></td>  </tr>

    </table>

</form>

<%@include file="footer.jsp"%>
