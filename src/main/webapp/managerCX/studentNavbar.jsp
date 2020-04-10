<%--
  Created by IntelliJ IDEA.
  User: 25778
  Date: 2020/3/28
  Time: 19:40
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
    <title>学生管理</title>
    <link rel="stylesheet" href="../css/bootstrap.min.css">
    <link rel="stylesheet" href="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://cdn.staticfile.org/jquery/2.1.1/jquery.min.js"></script>
    <script src="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script>
<body>
<div>
    <ul class="nav nav-pills">
        <li onclick="changea()" class="a active" style="padding: 15px"><a href="managerCX\changeClass.jsp"
                                                                          target="down">转专业</a></li>
        <li onclick="change()" class="e" style="padding: 15px"><a href="managerCX\addStudent.jsp"
                                                                  target="down">添加新学生</a></li>
        <li onclick="changec()" class="c" style="padding: 15px"><a href="managerCX\delStudent.jsp" target="down">需要删除的学生</a></li>
        <%--<li onclick="changed()" class="d" style="padding: 15px"></li>--%>
    </ul>
</div>
<script type="text/javascript">
    function change() {
        $(".active").removeClass("active")
        $(".e").addClass("active")
    }

    function changea() {
        $(".active").removeClass("active")
        $(".a").addClass("active")
    }

    function changec() {
        $(".active").removeClass("active")
        $(".c").addClass("active")
    }

    function changed() {
        $(".active").removeClass("active")
        $(".d").addClass("active")
    }
</script>
</body>
</html>
