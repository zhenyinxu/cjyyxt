<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>login</title>
</head>
<body>

<form action="/user/login" method="post">
    用户名：<input name ="passport">
    <br/>
    密码：<input name ="password">
    <br/>
    <input type="submit" value="提交">
</form>
</body>
</html>