<%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 2020/3/14
  Time: 20:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>登录</title>
    <link rel="stylesheet" type="text/css" href="css/style.css" />
    <link rel="stylesheet" type="text/css" href="css/body.css"/>
</head>
<body>
<div class="container">
    <section id="content">
        <form action="dologin">
            <h1>登录</h1>
            <div><input type="text" placeholder="账号" id="username" name="ID" /></div>
            <div><input type="password" placeholder="密码"  id="password" name="password" /></div>
            <div class=""><span class="help-block u-errormessage" id="js-server-helpinfo">&nbsp;</span></div>
            <div><input type="submit" value="登录" class="btn btn-primary" id="js-btn-login"/></div>
        </form><!-- form -->
    </section><!-- content -->
</div>
</body>
</html>