package src.main.servlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class servletContext2 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        像Map一样存取数据
//        可以通过getServletContext() 来获取Context对象
        ServletContext servletContext = getServletContext();
        servletContext.setAttribute("key", "value");
        System.out.println("the key is " + servletContext.getAttribute("key"));
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
