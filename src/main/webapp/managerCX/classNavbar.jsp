<%--
  Created by IntelliJ IDEA.
  User: 25778
  Date: 2020/3/28
  Time: 19:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<head>
    <base href="<%=basePath%>">
    <title>班级管理</title>
    <link rel="stylesheet" href="../css/bootstrap.min.css">
    <link rel="stylesheet" href="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://cdn.staticfile.org/jquery/2.1.1/jquery.min.js"></script>
    <script src="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>
<ul class="nav nav-pills">
    <li onclick="changea()" class="a active" style="padding: 15px"><a href="managerCX\addClass.jsp" target="down">添加班级</a></li>
    <li onclick="changeb()" class="b" style="padding: 15px"><a href="#" target="down">删除班级</a></li>
    <li onclick="changec()" class="c" style="padding: 15px"><a href="#" target="down">查看班级信息及管理</a></li>
</ul>
<script type="text/javascript">
    function changea() {
        $(".active").removeClass("active")
        $(".a").addClass("active")
    }

    function changec() {
        $(".active").removeClass("active")
        $(".c").addClass("active")
    }

    function changeb() {
        $(".active").removeClass("active")
        $(".b").addClass("active")
    }
</script>
</body>
</html>
