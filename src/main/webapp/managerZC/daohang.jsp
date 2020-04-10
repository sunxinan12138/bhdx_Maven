<%--
  Created by IntelliJ IDEA.
  User: 25778
  Date: 2020/3/25
  Time: 21:53
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
    <title>导航页面</title>
    <link rel="stylesheet" href="../css/bootstrap.min.css">
    <link rel="stylesheet" href="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://cdn.staticfile.org/jquery/2.1.1/jquery.min.js"></script>
    <script src="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>
<ul class="nav-pills nav-stacked" >
    <li style="padding: 15px"><a href="managerZC/selectClass.jsp" target="right">按班级查找和导出</a></li>
    <li style="padding: 15px"><a href="managerZC\selectZCByClass.jsp"  target="right">查看所有综测证书</a></li>
    <li style="padding: 15px"><a href="managerZC\addStuMark.jsp" target="-_blank">添加学生分数</a></li>
    <li style="padding: 15px"><a href="outFile\outZCExcel.jsp" target="right">证书导出</a></li>
</ul>
</body>
</html>
