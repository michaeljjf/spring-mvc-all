<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>index</title>
    <script src="static/js/index.js"></script>
    <link type="text/css" href="static/css/index.css" rel="stylesheet">
</head>
<body>
    <%--<h1>index page</h1>
    <img src="static/img/logo.png">--%>
    <form action="jjf/testRequest" method="post">
        <input type="submit" value="提交方式测试">
    </form>
    <br/>
    <form action="jjf/testRequest2" method="get">
        <input type="text" name="username">
        <input type="submit" value="提交参数测试">
    </form>
    <br/>
    <form action="jjf/testRequest3" method="get">
        <input type="text" name="username">
        <input type="password" name="password">
        <input type="submit" value="提交参数测试">
    </form>

    <a href="testData.jsp">参数测试类</a>
    <br>
    <a href="testAnnotation.jsp">参数注解类</a>
</body>
</html>
