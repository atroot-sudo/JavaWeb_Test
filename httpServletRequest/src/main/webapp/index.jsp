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
<a href="hello-servlet">Hello Servlet</a>
<form action="http://localhost:8080/httpServletRequest_war/helloServlet" method="get">
    用户名：<input type="text" name="username"> <br>
    密码：<input type="password" name="password"><br>
    多选项：
    <input type="checkbox" name="more" value="多选项0">
    <input type="checkbox" name="more" value="多选项1">
    <input type="checkbox" name="more" value="多选项2">
    <input type="checkbox" name="more" value="多选项3">
    <input type="submit">
</form>
</body>
</html>