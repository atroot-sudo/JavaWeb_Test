package com.theoldzheng.Filter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Description:
 *
 * @author theoldzheng@163.com  @ZYD
 * @create 2021.3.21 9:46
 */
public class loginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");

        if ("abc".equals(username) && "123456".equals(password)){
            //登陆成功
            req.getSession().setAttribute("username",username);

            req.getRequestDispatcher("/admin/helloAdmin.jsp").forward(req,resp);
            resp.getWriter().write("success ！");
        }else{
            //登录失败
            req.getRequestDispatcher("/login.jsp").forward(req,resp);

        }
    }
}
