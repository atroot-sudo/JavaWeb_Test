<%@ page import="java.util.HashMap" %>
<%@ page import="java.util.Map" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
<h1><%= "Hello World!" %>
</h1>
<br/>
<%
    request.setAttribute("key", "value1");
%>
表达式：<%=request.getAttribute("key")%> <br>
EL表达式的结果为：${key} <br>

关系运算：${ 5 == 5 } 或者 ${5 eq 5} <br>
逻辑关系运算：${1==1 || 1==0} 或者 ${1==1 or 0==0} <br>
算数运算结果：${1 + 2} <br>

empty判断是否为空,空返回true，非空返回false <br>
判空的规则：空串(一个空格也不能有)，Object类型的数组的长度为0的时候，值为null的时候，list、map集合为0的时候 <br>
<%
    Map map = new HashMap();
    List list = new ArrayList();
    Object[] obj = new Object[20];
%>
${empty map} <br>
${empty obj} <br>
${empty list} <br>
<hr>
三目运算符:${5 == 5? "true" : "false"} <br>
<hr>
<%--
EL表达式的11个隐含对象
1.pageContext   pageContextImpl  他可以获取jsp中的九大内置对象
2.pageScope     Map<String,Object> 他可以获取pageContext域中的数据
3.requestScope  Map<String ,Object> 可以获取request中的所有数据
4.sessionScope  Map<String,Object> 他可以获取session域中的数据
5.applicationScope Map<String,Object> 他可以获取ServletContext域中的数据

6.param         Map<String,String> 他可以获取请求参数的值
7.paraValues    Map(String,String[]) 他在获取请求参数的多个值的时候使用
8.header        Map(String,String)  他可以在获取请求头的时候使用
9.headerValues  Map(String,String[]) 他获取请求头的多个信息的时候使用

10.cookie       Map<String,Cookie> 用来获取当前请求的Cookie信息
11.initParam    Map<String,String> 他可以用来获取在web.xml文件中配置的context-param上下文参数
--%>
EL获取四个特定域中的属性 <br>
<%
    pageContext.setAttribute("keyPageContext","pageContext");
    request.setAttribute("keyRequest","request");
    session.setAttribute("keySession","session");
    application.setAttribute("keyApplication","application");
%>
<%--搜索以上四种域的顺序是: 从上到下！--%>
${pageScope.key} <br>
${requestScope.key} <br>
${keyPageContext} <br>

pageContext的使用： <br>
获取当前的协议：${pageContext.request.scheme } <br>
服务器ip：${pageContext.request.serverName} <br>
服务器端口: ${ pageContext.request.serverPort} <br>
工程路径：${pageContext.request.contextPath} <br>
获取请求方法：${pageContext.request.method} <br>
获取客户端： ${pageContext.request.remoteHost} <br>
获取会话的id编号：${pageContext.session.id} <br>


</body>
</html>