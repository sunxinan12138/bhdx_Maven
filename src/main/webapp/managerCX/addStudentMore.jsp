<%--
  Created by IntelliJ IDEA.
  User: 25778
  Date: 2020/4/10
  Time: 19:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%
        String path = request.getContextPath();
        String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
    %>
    <base href="<%=basePath%>">
    <link rel="stylesheet" href="../css/bootstrap.min.css">
    <link rel="stylesheet" href="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://cdn.staticfile.org/jquery/2.1.1/jquery.min.js"></script>
    <script src="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <title>批量添加</title>
</head>
<body>
<form action="addStudentMore" style="margin: 0 auto ;height: auto; width: 40%" role="form" method="POST"
      enctype="multipart/form-data">
    <div class="form-group">
        <label>Excel表格添加</label>
        <input name="file" type="file" id="file">
    </div>
    <button type="submit" class="btn btn-default">提交</button>
</form>
</body>
</html>
