package com.theoldzheng.Filter;


import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Description:
 * Filter 使用步骤  三种拦截方式  文件夹、后缀名(不能以/打头)、具体对象xxx.jsp
 * 创建Filter实现类 重写doFilter()
 * 配置web.xml文件 filter
 * 在实现类中获取Session域中的信息 进行逻辑编写
 *
 * @author theoldzheng@163.com  @ZYD
 * @create 2021.3.20 21:49
 */
public class AdminFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        //准备获取session
        HttpServletRequest req = (HttpServletRequest) servletRequest;
        HttpSession session = req.getSession();
        Object username = session.getAttribute("username");

        if (username == null) {
            req.getRequestDispatcher("/login.jsp").forward(servletRequest,servletResponse);
            return;
        }else{
            //过滤器放行，继续向下执行
            filterChain.doFilter(servletRequest,servletResponse);
        }


    }
}
