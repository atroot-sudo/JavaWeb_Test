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
<a href="http://localhost:8080/HelloServlet_war/hello2" > hello servlet2</a>

<%--这里提交的action地址必须要和后面配置的web.xml文件中的指定的servlet的访问地址是一样的，否则将找不到牌资源--%>
<form action="http://localhost:8080/HelloServlet_war/hello" method="post">
    <input type="submit">
</form>
<br>
<form action="http://localhost:8080/HelloServlet_war/hello3" method="get">
    <input type="submit" value="提交3">
</form>

</body>
</html>