package com.Lab3;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "HitCountServlet", value = "/HitCountServlet")
public class HitCountServlet extends HttpServlet {
    private int Count;
    @Override
    public void init() throws ServletException {
        Count=0;
        super.init();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Count++;
        PrintWriter out=response.getWriter();
        out.println("<html><head><title>Total Number of Hits</title></head>");
        out.println("<body><center><h1>Total Number of Hits</h1><h2>"+Count+"</h2></center></body></html>");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}