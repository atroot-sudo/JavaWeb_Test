package src.main.servlet;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Description: 这里是Servlet2
 * @author theoldzheng@163.com  @ZYD
 * @create 2021.3.12 21:49
 */
public class HelloServlet2 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        System.out.println("执行了Servlet2的doGet方法");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        System.out.println("执行了Servlet2的doPost方法");
    }
    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        HttpServletRequest httpServlet = (HttpServletRequest) servletRequest;
        HttpServletResponse httpServletResponse = (HttpServletResponse) servletResponse;
        String method = httpServlet.getMethod();
        if ("GET".equals(method)){
            doGet(httpServlet,httpServletResponse);
        }else if ("POST".equals(method)){
            doPost(httpServlet,httpServletResponse);
        }
        System.out.println("3. hello servlet");
    }
    @Override
    public String getServletInfo() {
        return null;
    }
    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
        System.out.println("2.init初始化");
    }
    public void destroy() {
        System.out.println("销毁方法执行");
    }
    @Override
    public ServletConfig getServletConfig() {
        return null;
    }

    public HelloServlet2() {
    }

    /**
     * 在重写init方法时，一定要实现对其super()的调用，否则在 获取ServletConfig里的一些内容时就会报异常(空指针)
     * @throws ServletException
     */
    @Override
    public void init() throws ServletException {
        super.init();
    }
}
