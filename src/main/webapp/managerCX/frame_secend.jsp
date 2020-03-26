<%--
  Created by IntelliJ IDEA.
  User: 25778
  Date: 2020/3/25
  Time: 22:03
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
    <title>Title</title>
</head>
<frameset cols="25%,*" noresize="noresize" >
    <frame name="left" src="managerCX/daohang.jsp">
    <frame name="right" src="managerCX/welcome.jsp">
</frameset>
</html>
