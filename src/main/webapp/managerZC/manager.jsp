<%--
  Created by IntelliJ IDEA.
  User: 25778
  Date: 2020/2/17
  Time: 14:05
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
    <title>综测管理员界面</title>
</head>
<frameset rows="10%,*" noresize="noresize" frameborder="no" >
    <frame src="managerCX/navbar.jsp">
    <frame src="managerCX/frame_secend.jsp">
</frameset>
</html>
