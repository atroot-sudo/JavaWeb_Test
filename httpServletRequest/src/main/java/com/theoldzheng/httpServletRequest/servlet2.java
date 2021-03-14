package com.theoldzheng.httpServletRequest;

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
public class servlet2 extends HttpServlet {
    /**
     * servlet2 首先进行获取信息
     * 其次进行验证，是否有标记来自于servlet1
     * 最后根据需求处理业务
     */

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("servlet2: ");
        //获取信息
        String username = req.getParameter("username");
        System.out.println(username);
//        进行验证
        Object key = req.getAttribute("key");

        //执行servlet2的代码
        System.out.println("执行servlet2");


    }


}
