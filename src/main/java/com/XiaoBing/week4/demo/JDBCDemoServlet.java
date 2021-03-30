package com.XiaoBing.week4.demo;;

import javax.servlet.*;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

//use @webservlet - no web.xml code
@WebServlet(
        urlPatterns = {"/bc"},
        initParams = {
                @WebInitParam(name ="driver", value = "com.microsoft.sqlserver.jdbc.SQLServerDriver"),
                @WebInitParam(name ="url", value = "jdbc:sqlserver://localhost:1433;DatabaseName=Userdb;"),
                @WebInitParam(name ="username", value = "sa"),
                @WebInitParam(name ="password", value = "xb284710")
        }

)//end of webservlet
public class JDBCDemoServlet extends HttpServlet {
    Connection con=null;
    public void init() throws ServletException {
        // connection within do get
        //String driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
        //String url = "jdbc:sqlserver://localhost;databaseName=userdb;";
        //String username = "sa";
        //String password = "123456";

        //get servletconfig --> getInitParameters
        ServletConfig config= getServletConfig();
        String driver=config.getInitParameter("driver");//<param-name>driver</param-name>
        String url=config.getInitParameter("url");
        String username=config.getInitParameter("username");
        String password=config.getInitParameter("password");

        System.out.println(driver);

        try {
            Class.forName(driver);
            con = DriverManager.getConnection(url,username,password);
            System.out.println("init()-->"+con);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("i am in doGet()");
   /* String  sql="select * from Usertable";
        try {
            ResultSet rs=con.createStatement().executeQuery(sql);
            while(rs.next()) {
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
            */
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
    public void destroy(){
        super.destroy();
        try {
            con.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}

