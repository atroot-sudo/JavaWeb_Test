package com.theoldzheng.servlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * ServletContext 上下文
 * 它是一个接口，表示Servlet对象的上下文
 * 一个web工程，只可存在一个ServletContext对象实例
 * ServletContext对象是一个域对象
 * <p>
 * 域对象：向Map一样可以存取数据的对象，叫做域对象
 * 这里的域指定是存取操作的操作范围
 * <p>
 * ServletContext类的四个用途
 * <p>
 * 1.获取web.xml中配置的上下文参数 context-param
 * 2.获取当前工程路劲
 * 3.获取工程部署后在硬盘上的绝对路径
 * 4.像Map存取数据
 */
public class servletContext extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取ServletContext对象进行操作
        //通过ServletConfig来获取
        ServletContext servletContext = getServletConfig().getServletContext();
        String username = servletContext.getInitParameter("username");
        System.out.println("username 的值是：" + username);
        String contextPath = servletContext.getContextPath();
        System.out.println("获取当前工程路径为:" + contextPath);
        String realPath = servletContext.getRealPath("/");
        System.out.println(realPath);
//        斜杠表示对应到当前的工程的路径下，还可以获取文件内对应的各种文件的路径
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
