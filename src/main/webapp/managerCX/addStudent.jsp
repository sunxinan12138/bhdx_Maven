<%--
  Created by IntelliJ IDEA.
  User: 25778
  Date: 2020/3/28
  Time: 17:00
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
    <title>学生添加</title>
    <link rel="stylesheet" href="../css/bootstrap.min.css">
    <link rel="stylesheet" href="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://cdn.staticfile.org/jquery/2.1.1/jquery.min.js"></script>
    <script src="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>

<div style="margin: 0 auto ;height: auto; width: 40%" class="panel-heading">
    <form action="#" role="form">
        <div class="form-group">
            <label>学号</label>
            <input style="width: 50%" type="text" class="form-control" name="stuid"
                   placeholder="请输入学号">
        </div>
        <div class="form-group">
            <label>姓名</label>
            <input style="width: 50%" type="text" class="form-control" name="name"
                   placeholder="请输入姓名">
        </div>
        <div class="form-group">
            <label>班级号</label>
            <div class="dropdown">
                <button style="width: 50%" type="button" class="btn dropdown-toggle" id="dropdownMenu1"
                        data-toggle="dropdown">
                    班级号
                </button>
                <ul style="width: 50%" class="dropdown-menu" role="menu" aria-labelledby="dropdownMenu1">
                    <li role="presentation">
                        <p id="chooseId" onclick="chooes()">2017160501</p>
                    </li>

                </ul>
            </div>
            <input id="classId"  readonly="readonly" style="width: 50%" type="text" class="form-control" name="classId"
                   placeholder="请输入班级号">
        </div>

        <button type="submit" class="btn btn-default">提交</button>
    </form>
</div>
</body>
</html>
