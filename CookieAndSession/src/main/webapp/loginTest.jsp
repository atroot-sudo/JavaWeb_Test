<%--
  Created by IntelliJ IDEA.
  User: zheng
  Date: 2021.3.20
  Time: 14:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%--<%
        String BasePath = request.getScheme() + "://"
                + request.getServerName() +
                ":" + request.getServerPort() +request.getContextPath() + "/";
    %>

    <base href="<%=BasePath%>">--%>
    <title>Cookie</title>

</head>
<body>


<form action="http://localhost:8080/Cookie_Test/loginTest" method="get">
    <table border="0" align="center" cellspacing="0" >
        <tr >
            <td > 用户名:</td>
            <td colspan="3"><input type="text" name="username" value="${cookie.username.value }"></td>

        </tr>

        <tr>
            <td> 密码：</td>
            <td colspan="3"> <input type="password" name="password"></td>

        </tr>
        <tr>
            <td>验证码：</td>
            <td><input type="text" name="code"></td>
            <td><img src="http://localhost:8080/Cookie_Test/kaptcha.jpg" width="95px" height="22"></td>
        </tr>
        <tr  align="center">
            <td> <input type="submit" value="登录"></td>
            <td> <input type="reset"></td>

        </tr>
    </table>
    <br>
    <br>

      <br>

</form>


</body>
</html>
