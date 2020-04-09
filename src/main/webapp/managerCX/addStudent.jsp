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
    <form action="doAddStudent" role="form" method="post">
        <div class="form-group">
            <label>学号</label>
            <input style="width: 50%" type="text" class="form-control" name="id"
                   placeholder="请输入学号">
        </div>
        <div class="form-group">
            <label>姓名</label>
            <input style="width: 50%" type="text" class="form-control" name="name"
                   placeholder="请输入姓名">
        </div>
        <button type="submit" class="btn btn-default">提交</button>
    </form>
</div>

<script type="text/javascript">

    $(document).ready(
        function () {

            $.ajax({
                url: 'doSelectAllClass',
                type: 'POST',
                async: true,
                timeout: '3000',
                dataType: 'text',
                success: function (e) {
                    // 解析
                    var arr = JSON.parse(e);
                    for (var i = 0; i < arr.length; i++) {
                        var $tr = $("<option value ='" + arr[i].id + "'>" + arr[i].subject + "</option>")
                        var $table = $("#selectId");
                        $table.append($tr);
                    }
                }
            })
        }
    )

    function choose() {
        var options = $("#selectId option:selected");
        options.val();          //拿到选中项的值
        options.text();
        $("#clsId").val(options.val());
    }

</script>
</body>
</html>
