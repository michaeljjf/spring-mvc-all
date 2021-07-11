<%--
  Created by IntelliJ IDEA.
  User: jiangjf
  Date: 2021/7/2
  Time: 21:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>ssm login</title>
</head>
<body>
    <form action="login.do" method="post">
        <p>用户名：<input type="text" name="uname"></p>
        <p>密 码：<input type="password" name="password"></p>
        <input type="submit" value="登录">
    </form>
</body>
</html>
