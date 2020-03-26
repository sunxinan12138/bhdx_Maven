<%--
  Created by IntelliJ IDEA.
  User: 25778
  Date: 2020/3/25
  Time: 21:55
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
    <title>Welcome！！！</title>
</head>
<body>
<strong> Welcome！！！</strong>
</body>
</html>
