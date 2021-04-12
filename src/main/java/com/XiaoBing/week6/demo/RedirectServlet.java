package com.XiaoBing.week6.demo;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "RedirectServlet", value = "/redirect")
public class RedirectServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //1.
        System.out.println("before redirect ");

        response.sendRedirect("/2019211001001024Xiaobing_war_exploded/index.jsp");
        //http://localhost:8080/2019211001001024Xiaobing_war_exploded/register
        //http://localhost:8080/2019211001001024Xiaobing_war_exploded/index.jsp

        //2.
        System.out.println("after redirect ");
        response.sendRedirect("/index.jsp");
        //http://localhost:8080/2019211001001024Xiaobing_war_exploded/register
        //localhost:8080/index.jsp

        response.sendRedirect("https://www.baidu.com");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
doGet(request, response);
    }
}
