package com.XiaoBing.week5.demo;

import javax.servlet.ServletException;

import javax.servlet.annotation.WebServlet;

import javax.servlet.http.HttpServlet;

import javax.servlet.http.HttpServletRequest;

import javax.servlet.http.HttpServletResponse;

import java.io.IOException;

import java.io.PrintWriter;

import java.sql.*;





@WebServlet(name = "LoginServlet",value = "/login")

public class LoginServlet extends HttpServlet {

    private String driver;

    private String url;

    private String username;

    private String password;

    Connection con = null;

    ResultSet rs = null;

    PreparedStatement stat = null;

    public void init() throws ServletException {

        super.init();

        driver = getServletContext().getInitParameter("driver");

        url = getServletContext().getInitParameter("url");

        username = getServletContext().getInitParameter("username");

        password = getServletContext().getInitParameter("password");

        try {

            Class.forName(driver);

        } catch (ClassNotFoundException e) {

            e.printStackTrace();

        }

        // 建立数据库连接，获得连接对象conn

        try {

            con = DriverManager.getConnection(url, username,password);

        } catch (SQLException e) {

            e.printStackTrace();

        }

    }



    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        username = request.getParameter("username");

        password = request.getParameter("password");



        String sql = "select * from usertable where username = ? and password = ?";

        try {

            stat = con.prepareStatement(sql);

            stat.setString(1,username);

            stat.setString(2,password);



            rs = stat.executeQuery();



            PrintWriter pw = response.getWriter();

            if (rs.next()) {

                //pw.write("<h1>Login Success!!!</h1>");

                //pw.write("<h1>Welcome,"+username+"</h1>");

                request.setAttribute("username",rs.getInt("id"));
                request.setAttribute("useranme",rs.getString("username"));
                request.setAttribute("password",rs.getString("password"));
                request.setAttribute("email",rs.getString("email"));
                request.setAttribute("gender",rs.getString("gender"));
                request.setAttribute("birthdate",rs.getString("birthdate"));

                request.getRequestDispatcher("userInfo.jsp").forward(request,response);


            }
            else {

                //pw.write("<h1>Login Error!</h1>");

                request.setAttribute("massage","Username or Password Error!!!");
                request.getRequestDispatcher("login.jsp").forward(request,response);
            }



        } catch (SQLException e) {

            e.printStackTrace();

        }



    }



    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        doPost(request,response);

    }



    public void destory(){

        super.destroy();

        try {

            con.close();

            stat.close();

            rs.close();

        } catch (SQLException e) {

            e.printStackTrace();

        }

    }

}
