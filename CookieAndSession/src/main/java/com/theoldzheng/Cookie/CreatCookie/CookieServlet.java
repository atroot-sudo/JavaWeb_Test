package com.theoldzheng.Cookie.CreatCookie;

import com.theoldzheng.Cookie.BaseServlet.BaseServlet;
import com.theoldzheng.Cookie.Utils.CookieUtils;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Description:
 *
 * @author theoldzheng@163.com  @ZYD
 * @create 2021.3.19 21:12
 */
public class CookieServlet extends BaseServlet {


    public void createCookie(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        resp.setContentType("text/html; charset=UTF-8");
//        resp.setHeader("Content-Type","text/html; charset=UTF-8");

        //首先创建cookie对象
        Cookie cookie = new Cookie("cookie1", "cookieValue1");
//        Cookie cookie2 = new Cookie("cookie2", "cookieValue2");

        //通知客户端保存cookie
        resp.addCookie(cookie);
//        resp.addCookie(cookie2);

        resp.getWriter().write("Cookie 创建成功！" + "<br/>");
    }


    public void getCookie(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        resp.setContentType("text/html; charset=UTF-8");

        //获取Cookie
        Cookie[] cookies = req.getCookies();

        for (Cookie cookie : cookies) {
            String name = cookie.getName();
            String value = cookie.getValue();

//            System.out.println("Cookie：" + name + " Value " + value);
            PrintWriter writer = resp.getWriter();
            writer.write("Cookie 获取成功！" + "<br/>");
            writer.write("Cookie：" + name + " Value " + value + "<br/>");
        }
    }

    public void updateCookie(HttpServletRequest req, HttpServletResponse resp) {
        //修改Cookie有两种方法
        //方法一：直接new一个新的同名方法 进行覆盖 并通知客户端保存
//        Cookie cookie = new Cookie("cookie1", "updateCookieValue");
//        resp.addCookie(cookie);


        //方法二: 找到Cookie对应的值进行setValue()
        Cookie cookie1 = CookieUtils.findCookie("cookie1", req.getCookies());
        if (cookie1 != null) {
            cookie1.setValue("updateValueCookieValue2");
            resp.addCookie(cookie1);
        }


    }

    public void defaultLife(HttpServletRequest req, HttpServletResponse resp) {
        //首先创建cookie对象
        Cookie cookie = new Cookie("cookie3", "Value1");
        if (cookie != null) {
            cookie.setMaxAge(0); //立即删除
            cookie.setMaxAge(3600); //3600秒后 删除
            resp.addCookie(cookie);
        }
//        cookie.setMaxAge();  整数 在指定时间之后销毁  负数，浏览器关闭后立即销毁，零 立即销毁
    }

}
