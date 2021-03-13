package com.theoldzheng.servlet;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;

public class servletContext2 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ServletContext servletContext = getServletContext();
        servletContext.setAttribute("key","value");
        System.out.println("the key is " + servletContext.getAttribute("key"));
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
