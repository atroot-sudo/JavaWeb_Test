package com.theoldzheng.Cookie.CreatCookie;

import javax.servlet.http.*;

/**
 * Description:
 *
 * @author theoldzheng@163.com  @ZYD
 * @create 2021.3.20 15:14
 */
public class loginTest extends HttpServlet {
    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) {

        String name = req.getParameter("username");
        String password = req.getParameter("password");
        String code = req.getParameter("code");

        HttpSession session = req.getSession();
        String  kaptcha = (String) session.getAttribute("KAPTCHA_SESSION_KEY");
        session.removeAttribute("KAPTCHA_SESSION_KEY");

        if ("abcde".equals(name) && "123456".equals(password) && kaptcha.equals(code)) {
            //success
            System.out.println("success");
            Cookie cookie = new Cookie("username", name);
            cookie.setMaxAge(60 * 60 * 24);
            resp.addCookie(cookie);
        } else {
            //false
            System.out.println("false");

        }

    }
}
