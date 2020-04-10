<%--
  Created by IntelliJ IDEA.
  User: 25778
  Date: 2020/4/10
  Time: 12:22
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
    <title>添加分数</title>
    <link rel="stylesheet" href="../css/bootstrap.min.css">
    <link rel="stylesheet" href="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://cdn.staticfile.org/jquery/2.1.1/jquery.min.js"></script>
    <script src="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>
<div style="margin: 0 auto ;height: auto; width: 40%" class="panel-heading">
    <form action="javascript:btnmar()" role="form" method="post">
        <div class="form-group">
            <label>学号</label>
            <input id="stuId" style="width: 50%" type="text" class="form-control" name="stuid"
                   placeholder="请输入学号">
        </div>
        <div class="form-group">
            <label>姓名</label>
            <input id="stuName" style="width: 50%" type="text" disabled class="form-control" name="stuName">
        </div>
        <div>
            <label> 活动名称</label>
            <input id="hdName" style="width: 50%" type="text" class="form-control" name="hdName"
                   placeholder="请输入活动名称">
        </div>
        <div class="form-group">
            <label>分数</label>
            <input id="mark" style="width: 50%" type="text" class="form-control" name="mark"
                   placeholder="请输入分数">
        </div>
        <%--<div style="width: 50%">--%>
        <%--<div style=" width: 50%;">--%>
        <%--<li class="dropdown form-control">--%>
        <%--<a href="" class="dropdown-toggle " data-toggle="dropdown">--%>
        <%--分类--%>
        <%--</a>--%>
        <%--<ul class="dropdown-menu ">--%>
        <%--<li><a href="javascript:sortA()">*类</a></li>--%>
        <%--<li><a href="javascript:sortB()">#类</a></li>--%>
        <%--</ul>--%>
        <%--</li>--%>
        <%--</div>--%>
        <%--<div style="width: 50%; "><input id="sort" disabled style="float: right" type="text" class="form-control">--%>
        <%--</div>--%>
        <%--</div>--%>
        <button type="submit" class="btn btn-default">提交</button>
    </form>
</div>
<script type="text/javascript">
    $("#stuId").change(function () {
        var id = $("#stuId").val();
        $.ajax({
            url: 'doselectall',
            type: 'POST',
            async: true,
            timeout: '3000',
            dataType: 'text',
            data: {'id': id},
            success: function (e) {
                var arr = JSON.parse(e);
                $("#stuName").val(arr[0].name);
            }
        });
    })
</script>
<script type="text/javascript">
    var hdName = "";
    var mark = "";
    var name = "";
    var stuid = "";


    //活动名称
    $("#hdName").change(
        function () {
            hdName = $("#hdName").val();
        }
    )
    //分数
    $("#mark").change(
        function () {
            mark = $("#mark").val();
        }
    )

    //提交
    function btnmar() {
        name = $("#stuName").val();
        stuid = $("#stuId").val();
        // alert(mark);
        // alert(hdName);
        // alert(name);
        // alert(stuid)
        if (mark != "" && hdName != "" && name != "" && stuid != "") {
            //添加证书
            $.ajax({
                url: 'doAddMarkZC',
                type: 'POST',
                async: true,
                timeout: '3000',
                dataType: 'text',
                data: {'stuid': stuid, 'name': name, 'zsName': hdName, 'mark': mark},
                success: function (e) {
                    if (e) {
                        alert("添加成功");
                    } else {
                        alert("false")
                    }
                }
            });
            //数据覆盖
            $("#mark").val(mark);
            $("#hdName").val(hdName);
        } else {
            alert("有数据为空")
        }

    }
</script>
</body>
</html>
