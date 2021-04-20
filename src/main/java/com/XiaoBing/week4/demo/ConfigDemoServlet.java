package com.XiaoBing.week4.demo;

import javax.servlet.*;

import javax.servlet.http.*;

import javax.servlet.annotation.*;

import java.io.IOException;

import java.io.PrintWriter;



@WebServlet(

        urlPatterns = {"/config"},

        initParams = {

                @WebInitParam(name="name",value="XiaoBing"),

                @WebInitParam(name="studentId",value="2019211001001024"),

        }

)

public class ConfigDemoServlet extends HttpServlet {

    @Override

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        ServletConfig config=getServletConfig();

        String name=config.getInitParameter("name");

        String studentId=config.getInitParameter("studentId");

        PrintWriter writer= response.getWriter();

        writer.println("Name : "+name);

        writer.println("StudentID : "+studentId);

    }



    @Override

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {



    }

}
