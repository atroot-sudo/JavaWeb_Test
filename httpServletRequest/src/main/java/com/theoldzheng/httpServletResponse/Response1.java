package com.theoldzheng.httpServletResponse;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Description: 请求重定向
 * 方法一：设置状态码、设置定向的地址
 * 方法二：直接设置重定向地址
 * <p>
 * 特征：地址栏会发生变化、两次请求(这也是为什么不能共享Request域的原因)、不能访问WEB-INF下的资源(WEB-INF为安全路径，只能交由服务器访问)、可以访问工程外的资源
 * @author theoldzheng@163.com  @ZYD
 * @create 2021.3.14 20:46
 */
public class Response1 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("response1 is loading");
//        请求重定向的两种方式，第一种较繁琐不推荐
//        第一种
//       1. 设置状态码
//        resp.setStatus(302);//302表示重定向
//       2.设置重定向的地址
//        resp.setHeader("Location","http://localhost:8080/httpServletRequest_war/response2");

//        第二种(推荐使用 一行代码搞定)
        resp.sendRedirect("https://www.baidu.com"); //可以转到项目外的网站但是不能访问WEB-INF内的网站


    }
}
