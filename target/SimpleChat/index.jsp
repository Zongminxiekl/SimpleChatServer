<%--
  Created by IntelliJ IDEA.
  User: Zongmin
  Date: 2020/7/3
  Time: 17:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <form action="user/login" method="post">
        <label> 账号：
            <input type="text" name="username"/>
        </label>
        <label> 密码：
            <input type="password" name="password"/>
        </label>
        <input type="submit" value="登录"/>
    </form>
</body>
</html>
