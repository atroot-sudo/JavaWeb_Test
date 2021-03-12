package com.theoldzheng.HelloServlet;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

/**
 * Servlet的生命周期
 * 1.执行Servlet构造器
 * 2.执行init初始化方法
 * 3.执行service方法
 * 4.执行destroy销毁方法
 */
@WebServlet(name = "helloServlet", value = "/hello-servlet")
public class HelloServlet extends HttpServlet  implements Servlet  {
    private String message;

    public HelloServlet() {
        System.out.println("1.构造器被调用");
    }

    public void init() {
        message = "Hello World!";
    }

    public void doGet()  {

        message = "this is a Get request.";
        System.out.println(message);
    }
    public void doPost() throws IOException {

        message = "this is a Post request.";
        // Hello
        System.out.println(message);
    }

    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
        System.out.println("2.init初始化");
    }

    @Override
    public ServletConfig getServletConfig() {
        return null;
    }

    /**
     * 该方法主要来处理请求和响应的方法的
     * @param servletRequest
     * @param servletResponse
     * @throws ServletException
     * @throws IOException
     */
    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        HttpServletRequest httpServlet = (HttpServletRequest) servletRequest;
        String method = httpServlet.getMethod();
        if ("GET".equals(method)){
            doGet();
        }else if ("POST".equals(method)){
            doPost();
        }
        System.out.println("3. hello servlet");
    }

    @Override
    public String getServletInfo() {
        return null;
    }

    public void destroy() {
        System.out.println("4.销毁方法执行");
    }
}