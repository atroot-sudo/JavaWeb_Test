<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <%
        String BasePath = request.getScheme() + "://"
                + request.getServerName() +
                ":" + request.getServerPort() +request.getContextPath() + "/";
    %>

    <base href="<%=BasePath%>">
    <meta http-equiv="pragma" content="no-cache" />
    <meta http-equiv="cache-control" content="no-cache" />
    <meta http-equiv="Expires" content="0" />
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Cookie</title>
    <title>JSP - Hello World</title>
</head>
<body>
<h1><%= "Hello World!" %>
</h1>
<br/>
<a href="hello-servlet">Hello Servlet</a>

<iframe name="target" width="500" height="500" style="float: left;"></iframe>
<div style="float: left;">
    <ul>
        <li><a href="cookieServlet?action=createCookie" target="target">Cookie的创建</a></li>
        <li><a href="cookieServlet?action=getCookie" target="target">Cookie的获取</a></li>
        <li><a href="cookieServlet?action=updateCookie" target="target">Cookie值的修改</a></li>
        <li>Cookie的存活周期</li>
        <li>
            <ul>
                <li><a href="cookieServlet?action=defaultLife" target="target">Cookie的默认存活时间（会话）</a></li>
                <li><a href="cookieServlet?action=deleteNow" target="target">Cookie立即删除</a></li>
                <li><a href="cookieServlet?action=life3600" target="target">Cookie存活3600秒（1小时）</a></li>
            </ul>
        </li>
        <li><a href="cookieServlet?action=testPath" target="target">Cookie的路径设置</a></li>
        <li><a href="" target="target">Cookie的用户免登录练习</a></li>
    </ul>



</div>
<div style="float: left;">
    <ul>
        <li><a href="sessionServlet?action=createOrGetSession" target="target">Session的创建和获取（id号、是否为新创建）</a></li>
        <li><a href="sessionServlet?action=setAttribute" target="target">Session域数据的存储</a></li>
        <li><a href="sessionServlet?action=getAttribute" target="target">Session域数据的获取</a></li>
        <li>Session的存活</li>
        <li>
            <ul>
                <li><a href="http://localhost:8080/Cookie_Test/sessionServlet?action=defaultLife" target="target">Session的默认超时及配置</a></li>
                <li><a href="http://localhost:8080/Cookie_Test/sessionServlet?action=life3" target="target">Session3秒超时销毁</a></li>
                <li><a href="http://localhost:8080/Cookie_Test/sessionServlet?action=deleteNow" target="target">Session马上销毁</a></li>
            </ul>
        </li>
        <li><a href="" target="target">浏览器和Session绑定的原理</a></li>
    </ul>
</div>

</body>
</html>