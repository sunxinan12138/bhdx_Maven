<%--
  Created by IntelliJ IDEA.
  User: 25778
  Date: 2020/4/4
  Time: 20:38
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
    <title>删除学生</title>
    <link rel="stylesheet" href="../css/bootstrap.min.css">
    <link rel="stylesheet" href="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://cdn.staticfile.org/jquery/2.1.1/jquery.min.js"></script>
    <script src="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>

<div style="margin: 0 auto ;height: auto; width: 40%" class="panel-heading">
    <form action="doAddStudent" role="form">
        <div class="form-group">
            <label>学号</label>
            <input id="changeName" style="width: 50%" type="text" class="form-control" name="ID"
                   placeholder="请输入学号">
        </div>
        <div class="form-group">
            <label>姓名</label>
            <input id="name" style="width: 50%" disabled type="text" class="form-control" name="name"
                   placeholder="姓名">
        </div>
        <button type="submit" class="btn btn-default">删除</button>
    </form>
</div>
<script type="text/javascript">
    $("#changeName").change(function () {
        var id = $("#changeName").val();
        $.ajax({
            url: 'doselectall',
            type: 'POST',
            async: true,
            timeout: '3000',
            dataType: 'text',
            data: {'id': id},
            success: function (e) {
                var arr = JSON.parse(e);
                $("#name").val(arr[0].name);
            }
        });
    })
</script>
</body>
</html>
