<%--
  Created by IntelliJ IDEA.
  User: zheng
  Date: 2021.3.16
  Time: 13:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" errorPage="/errorPage.jsp" %>
<%--JSP的page指令可以修改jsp页面的一些属性，或者行为--%>

<html>
<head>
    <title>Title</title>
</head>
<body>
这是一个JSP页面！<br>
language 属性：表示jsp翻译后是什么语言的文件，暂时只支持java<br>
contentType属性 表示jsp返回单额数据类型是什么 与源码中的response.setContentType()的参数值对应<br>
pageEncoding属性：表示当前jsp页面文件本身的字符集<br>
import属性： 与java一样用于导包<br>

authFlush属性：设置当out输出缓存区满了之后，是否自动刷新缓冲区，默认打开true<br>
buffer属性：设置out缓冲区的大小。默认为8KB<br>
<%--<% int a = 10 / 0; %>--%>
errorPage属性：表示错误后自动跳转的路径<br>
isErrorPage属性:表示当前jsp页面是否是错误信息页面。默认是false。如果是true可以获取异常信息<br>
session属性：设置访问当前jsp页面，是否会创建HttpSession对象，默认是true<br>
extends属性：设置jsp翻译出来的java类默认继承谁<br>

<%--声明类中属性、类方法等演示  极其不常用！！--%>
<%!
    private static String name;
    private int age;
%>
<%!
    static {
        name = "abc";
    }
%>
<%!
    public int add() {
        int a = 1;
        int b = 2;
        a = a + b;
        return a;
    }
%>
<%--表达式脚本 常用--%>
<%--格式为<%=表达式%>--%>
<%=666%>
<%=66.66%>
<%="我爱你中国！"%>
<%=request.getParameter("username")%>
jsp中的九大内置对象，可以直接使用
1.request 请求对象 <br>
2.response 响应对象 <br>
3.pageContext jsp的上下文对象 <br>
4.session 会话对象 <br>
5.application ServletContext对象 <br>
6.config ServletConfig对象 <br>
7.out jsp的输出流对象 <br>
8.page 指向当前的jsp对象 <br>
9.exception 异常对象 <br>

jsp四大域对象<br>
pageContext pageContextImpl类 只对当前jsp页面范围内有效<br>
request HttpServletRequest类 一次请求有效<br>
session HttpSession类 一个会话范围内有效(直到浏览器关闭)<br>
application ServletContext 整个web工程范围内有效(只要web工程不停止，就不会影响到数据)<br>

域对象的作用: 是可以Map一样存取数据的对象，四个域对象功能一样，不同的是他们对数据的存取范围 <br>
先后顺序(从内存的占用释放角度看使用的优先级)分别是 pageContext、request、session、application <br>

jsp中的out输出和和response.getWriter()方法的比较，区别 <br>
jsp中out.write()输出 和 response.getWriter().write() 都是用来给用户输出使用的 <br>
但是其中 response中的底层源码中是经过out实现的，以防止网页乱序，我们通常都使用out来写输出——————>由于全部的jsp代码执行后会执行out.flush()的操作，会将 <br>
out的缓冲区的内容直接拿到response的缓存区的尾部。 <br>

其中out有两种方法print()、write()用来输出 <br>
write不能用于输出数字、print可以输出任意字符(底层是将是将所有信息转换为字符串后调用的write()输出的，所以我们通常采用print() <br>

jsp的常用标签 <br>
jsp静态包含 <br>
静态包含的格式 <br>
<%--<%@include file=""%>--%>
静态包含的特点: <br>
1.静态包含不会翻译被包含的jsp页面,只是将jsp页面的代码拷贝到对应的位置执行输出 <br>

jsp的动态包含 <br>

动态包含的格式 <br>
<%--<jsp:include page="errorPage.jsp">

</jsp:include>--%>
page是指定的你要包含的jsp页面的路径 <br>
动态包含也像静态包含一样，把被包含的内容执行输出到包含位置 <br>
动态包含的特点： <br>
1.动态包含会把包含的jsp页面翻译成java代码 <br>
2.动态包含底层代码使用如下代码去调用jsp页面执行输出 <br>
<%--<jsp:include page="errorPage.jsp">
    <jsp:param name="username" value="123"></jsp:param>
    <jsp:param name="password" value="123" ></jsp:param>
</jsp:include>--%>


可以更简单的实现转发操作 <br>
<%--<jsp:forward page="errorPage.jsp"></jsp:forward>--%>
<h1>实现乘法表</h1>
<table cellspacing="15" cellpadding="1">
    <tr><%
        for (int i = 1; i <= 9; i++) {
            for (int j = 1; j <= i; j++) { %>
    <td> <%=(j + "*" + i + "=" + i * j + "  ")%></td>
    <% } %>
    <br>
    </tr>
    <% }

    %>
</table>
</body>
</html>
