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
<form action="http://localhost:8080/uploadFile_war/uploadFile" method="post" enctype="multipart/form-data" >
    用户名：<input type="text" name="username" > <br><br>
    文件：<input type="file" name="file" value="提交文件" >
    <input type="submit">
</form>
</body>
</html>