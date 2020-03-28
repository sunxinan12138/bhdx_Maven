<%--
  Created by IntelliJ IDEA.
  User: 25778
  Date: 2020/3/28
  Time: 15:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<head>
    <base href="<%=basePath%>">
    <title>学生管理</title>
    <link rel="stylesheet" href="../css/bootstrap.min.css">
    <link rel="stylesheet" href="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://cdn.staticfile.org/jquery/2.1.1/jquery.min.js"></script>
    <script src="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>
<ul class="nav-pills nav-stacked" >
    <li style="padding: 15px"><a href="managerCX\changeClass.jsp" target="_blank">转专业</a></li>
    <li style="padding: 15px"><a href="managerCX\addStudent.jsp"  target="_blank">添加新学生</a></li>
    <li style="padding: 15px"><a href="#"  target="_blank">需要删除的学生</a></li>
    <li style="padding: 15px"><a href="#"  target="_blank">查看所有学生及管理</a></li>

</ul>
</body>
</html>
