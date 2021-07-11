<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>index</title>
    <script src="static/js/index.js"></script>
    <link type="text/css" href="static/css/index.css" rel="stylesheet">
</head>
<body>
<form action="getParamByRequest" method="get">
    <input type="text" name="username">
    <input type="password" name="password">
    <input type="submit" value="getParamByRequest">
</form>
<hr/>
<br/>
<form action="getParamByArgNmae" method="get">
    <input type="text" name="username">
    <input type="password" name="password">
    <input type="submit" value="getParamByArgNmae">
</form>
<hr/>
<br/>
<form action="getParamByPojo" method="post">
    <input type="text" name="username">
    <input type="password" name="password">
    <input type="submit" value="getParamByPojo">
</form>

<hr/>
<br/>
<form action="getParamByPojo2" method="post">
    <p>姓名：
        <input type="text" name="name">
    </p>
    <p>年龄：
        <input type="text" name="age">
    </p>
    <p>性别：
        <input type="radio" name="gender" value="1">男
        <input type="radio" name="gender" value="0">女
    </p>
    <p>爱好：
        <input type="checkbox" name="hobby" value="1">篮球
        <input type="checkbox" name="hobby" value="2">足球
        <input type="checkbox" name="hobby" value="3">羽毛球
    </p>
    <p>生日：
        <input type="text" name="birthdate">
    </p>
    <p>
        宠物List：
    </p>
    <p>宠物1：名字：<input type="text" name="pets[0].petName">类型：<input type="text" name="pets[0].petType"></p>
    <p>宠物2：名字：<input type="text" name="pets[1].petName">类型：<input type="text" name="pets[1].petType"></p>
    <p>
        宠物Map：
    </p>
    <p>宠物1：名字：<input type="text" name="petMap['a'].petName">类型：<input type="text" name="petMap['a'].petType"></p>
    <p>宠物2：名字：<input type="text" name="petMap['b'].petName">类型：<input type="text" name="petMap['b'].petType"></p>
    <input type="submit" value="getParamByPojo2">
</form>
</body>
</html>
