<%--
  Created by IntelliJ IDEA.
  User: 25778
  Date: 2020/4/5
  Time: 14:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%
        Object name = request.getAttribute("name");
        Object lenth = request.getAttribute("lenth");
        String path = request.getContextPath();
        String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
    %>
    <base href="<%=basePath%>">
    <title>添加成功</title>
    <link rel="stylesheet" href="../css/bootstrap.min.css">
    <link rel="stylesheet" href="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://cdn.staticfile.org/jquery/2.1.1/jquery.min.js"></script>
    <script src="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>
<p id="lenth">成功添加<%=lenth%>条数据
</p>
<%=name %><br>
<a href="downCX?fileName=<%=name%>" download='<%=name%>'>下载</a>
<a href="outFile/outCXExcel.jsp">继续导出</a>
<script type="text/javascript" src="js/jquery-3.3.1.min.js"></script>
</body>
</html>
