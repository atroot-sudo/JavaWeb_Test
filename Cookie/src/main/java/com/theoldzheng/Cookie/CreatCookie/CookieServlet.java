package com.theoldzheng.Cookie.CreatCookie;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Description:
 *
 * @author theoldzheng@163.com  @ZYD
 * @create 2021.3.19 21:12
 */
public class CookieServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        resp.setContentType("text/html; charset:utf-8");

        System.out.println(resp.getCharacterEncoding());

        //首先创建cookie对象
        Cookie cookie = new Cookie("cookie", "cookieValue");

        //通知客户端保存cookie
        resp.addCookie(cookie);

        resp.getWriter().write("Cookie 创建成功！");
    }

}
