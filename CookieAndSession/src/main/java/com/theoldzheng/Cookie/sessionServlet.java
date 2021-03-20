package com.theoldzheng.Cookie;

import com.theoldzheng.Cookie.BaseServlet.BaseServlet;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Description:
 *
 * @author theoldzheng@163.com  @ZYD
 * @create 2021.3.20 15:32
 */
public class sessionServlet extends BaseServlet {
    public void  createOrGetSession(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        //通过getSession()方法获取Session对象 第一次为创建新的额Session对象 之后的为获取前面创建的
        HttpSession session = req.getSession();

//        System.out.println(session.isNew()); //查看当前session是否是最新的 是返回true
        String id = session.getId();
        System.out.println("当前session的唯一标识符ID：" + id);
        resp.getWriter().write("当前session的唯一标识符ID：" + id);
        resp.getWriter().write(session.isNew()?"新的":"旧的");

        //设置session超时时长 两次请求之前的最短时间间隔
//        session.setMaxInactiveInterval();  默认超时时长为30分钟  正数，表示设置时间多少秒 负数表示永不超时
//        session.invalidate();  表示立即失效
//        session.setAttribute("key","value");
//
//        req.getSession().setAttribute("key1","value1");
//
//        Object key = session.getAttribute("key");


    }
}
