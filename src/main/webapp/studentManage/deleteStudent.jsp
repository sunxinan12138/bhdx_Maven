<%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2020/4/3
  Time: 10:38
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
    <title>学生删除</title>
    <link rel="stylesheet" href="../css/bootstrap.min.css">
    <link rel="stylesheet" href="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://cdn.staticfile.org/jquery/2.1.1/jquery.min.js"></script>
    <script src="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>
<div style="margin: 0 auto ;height: auto; width: 40%" class="panel-heading">
<form action="doDeleteStudent" role="form" method="post">
    <div class="form-group">
        <label>学号</label>
        <input style="width: 50%" type="text" class="form-control" name="hhh" oninput="getName($(this))" >
    </div>
    <div class="form-group">
        <label>姓名</label>
        <input style="width: 50%" type="text" class="form-control" name="name"  id="b1" readonly>
    </div>
    <button type="submit" class="btn btn-default">提交</button>
</form>
</div>
<script type="text/javascript">
    function getName(obj)
    {
        var id = obj.val();
        $.ajax({
            type:'POST',
            url:'doSelectStudentByID?hhh='+id,
            data:'',
            async: true,
            dataType:'text',
            timeout:4000,
            success: function( json ){
                var arr = JSON.parse(json);
                if($.isEmptyObject(arr)){
                    $("#b1").attr("value",'');
                }
                else
                $("#b1").attr("value",arr[0].name);
            }
        });
    }
</script>
</body>
</html>
