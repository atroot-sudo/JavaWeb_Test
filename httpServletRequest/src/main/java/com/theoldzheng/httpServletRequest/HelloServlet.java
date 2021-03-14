package com.theoldzheng.httpServletRequest;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;

/**
 * HttpServletRequest类用来获取对应的响应头、响应行、资源信息等信息
 */
@WebServlet(name = "helloServlet", value = "/hello-servlet")
public class HelloServlet extends HttpServlet {
    private String message;

    public void init() {
        message = "Hello World!";
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        System.out.println("doGet:");
        System.out.println("获取请求的资源路径：" + request.getRequestURI());
        System.out.println("获取请求的统一资源定位符(绝对路径)：" + request.getRequestURL());
        System.out.println("获取到的客户端的地址：" + request.getRemoteHost());
        System.out.println("获取到的请求头里的代理：" + request.getHeader("User-Agent"));
        System.out.println("获取到的请求头里的代理：" + request.getHeader("Accept-Language"));
        System.out.println("获取到的请求方法：" + request.getMethod());

        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String[] mores = request.getParameterValues("more");
        System.out.println(username + password + Arrays.toString(mores));
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        解决Post请求时，发送数据乱码
        System.out.println("doPost:");
        req.setCharacterEncoding("UTF-8");
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String[] mores = req.getParameterValues("more");
        System.out.println(username);
        System.out.println(password);
        System.out.println(Arrays.toString(mores));

    }

    public void destroy() {
    }
}