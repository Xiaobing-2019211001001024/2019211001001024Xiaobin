package com.XiaoBing.week2.demo;

import javax.servlet.http.HttpServlet;

import javax.servlet.http.HttpServletRequest;

import javax.servlet.http.HttpServletResponse;

import java.io.IOException;

import java.io.PrintWriter;

import java.util.Date;



public class HelloWorldServlet extends HttpServlet {



    public void doGet(HttpServletRequest request, HttpServletResponse response)

            throws IOException {



        PrintWriter writer= response.getWriter();

        writer.println("Name:Xiaoping");

        writer.println("ID:2019211001001024");

        Date today = new Date();

        writer.println("Date and time "+today);

    }

    public void doPost(HttpServletRequest request, HttpServletResponse response){



    }

}
