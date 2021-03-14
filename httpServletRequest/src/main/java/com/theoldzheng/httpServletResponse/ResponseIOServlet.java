package com.theoldzheng.httpServletResponse;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Description:
 * @author theoldzheng@163.com  @ZYD
 * @create 2021.3.14 18:03
 */
public class ResponseIOServlet extends HttpServlet {
    //通过两个流 getOutputStream() getWrite() 来对服务器的信息输出到客户端
    // 但是只能二者取其一，不能同时使用，否则报错

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //解决输出中文字符乱码问题  需要注意的是，设置头必须获取流的前面才能有效
        // 设置服务器端为UTF-8
        //通过响应头来设置字符集为UTF-8
//        resp.setCharacterEncoding("UTF-8");
//        resp.setHeader("Content-Type","text/html;charset=UTF-8");

        //更简单的方法：同时设定客户端服务端
        resp.setContentType("text/html; charset=UTF-8");

        PrintWriter writer = resp.getWriter();
        writer.write("it is message from server.");
        System.out.println(req.getContextPath());
        String characterEncoding = resp.getCharacterEncoding();
        System.out.println("服务器的编码集为: " + characterEncoding);
        writer.println("你好，北京！");
    }
}