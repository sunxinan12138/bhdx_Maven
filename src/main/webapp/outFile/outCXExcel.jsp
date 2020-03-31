<%--
  Created by IntelliJ IDEA.
  User: 25778
  Date: 2020/3/30
  Time: 20:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%
        String classid = request.getParameter("classId");
        String path = request.getContextPath();
        String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
    %>
    <base href="<%=basePath%>">
    <title>导出创新表格</title>
    <link rel="stylesheet" href="../css/bootstrap.min.css">
    <link rel="stylesheet" href="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://cdn.staticfile.org/jquery/2.1.1/jquery.min.js"></script>
    <script src="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>
<p id="classId"><%=classid%>
</p>
<div style="margin: 0 auto ;height: auto; width: 40%" class="panel-heading">
    <form action="doOutExcel" method="post">
        <div class="form-group">
            <input style="width: 50%" name="path" type="text" name="path" value="E:\Business业务\电气学院综测系统\excel">

        </div>
        <div class="form-group">
            <label>新的班级</label>
            <div style="padding-bottom: 10px" class="dropdown">
                <select style="width: 50%" onchange="choose()" class="form-control" id="selectId">
                </select>
            </div>
        </div>
        <input id="clsId" readonly="readonly" style="width: 50%" type="text" class="form-control" name="classId"
               placeholder="班级号">
        <input id="clsName" readonly="readonly" style="width: 50%" type="text" class="form-control" name="className"
        >
        <button type="submit" class="btn btn-default">提交</button>

        <a target="_blank" href="?classId=17160501"></a>
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
        $("#clsName").val(options.text());
    }
</script>
</body>
</html>
