<%--
  Created by IntelliJ IDEA.
  User: 25778
  Date: 2020/3/25
  Time: 22:06
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
    <title>tab</title>
    <link rel="stylesheet" href="../css/bootstrap.min.css">
    <link rel="stylesheet" href="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://cdn.staticfile.org/jquery/2.1.1/jquery.min.js"></script>
    <script src="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>
<nav class="navbar navbar-inverse" role="navigation">
    <div class="container-fluid">
        <div class="navbar-header">
            <a class="navbar-brand" target="_parent" href="managerCX/manager.jsp">综测证书管理系统</a>
            <p id="idAname" class="navbar-brand" style="display: none;margin-left: 550px"></p>
            <a id="out" class="navbar-brand" target="_parent" href="../login.jsp">退出</a>
            <a class="navbar-brand" target="_parent" style="margin-left: 600px" href="../login.jsp">登录</a>
        </div>
    </div>
</nav>
<script type="text/javascript">
    $(document).ready(
        function () {
            var name = '<%=session.getAttribute("UserName")%>';
            var id = '<%=session.getAttribute("ID")%>';
            if (name != null && id != null) {
                var msg = name + "---" + id;
                $("#idAname").html(msg);
                $("#idAname").css('display', 'inline');
                $("#usermsg").css('display', 'none');
            } else {
                alert("请登录")
            }


        }
    )
</script>
</body>
</html>
