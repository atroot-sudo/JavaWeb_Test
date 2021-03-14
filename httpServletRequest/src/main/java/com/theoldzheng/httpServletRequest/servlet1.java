package com.theoldzheng.httpServletRequest;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Description: 用于测试请求转发
 * @author theoldzheng@163.com  @ZYD
 * @create 2021.3.14 15:28
 */
public class servlet1 extends HttpServlet {
    /**
     * 请求转发的过程
     * servlet程序
     * 1.查看请求的额参数
     * 2.执行程序后，设置一个标记
     * 3.获取servlet2的地址，准备进行转发
     * 4.转发
     *
     * 请求转发的特点：
     * 1.浏览器的地址不会发生变化
     * 2.他们是一次请求
     * 3.他们共享Request域中的数据
     * 4.不可以转发到WEB-INF目录下
     */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("servlet1: ");
        //        获取请求信息
        String username = req.getParameter("username");
        System.out.println(username);
        //执行servlet1
        System.out.println("执行servlet1");
//        加标记信息
        req.setAttribute("key","servlet1");
//        获取servlet位置
        RequestDispatcher servlet2 = req.getRequestDispatcher("/servlet2");
        //进行转发到servlet2
        servlet2.forward(req,resp);
    }
}
