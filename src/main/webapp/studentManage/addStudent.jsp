<%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2020/3/29
  Time: 20:22
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
    <title></title>
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
                   value="" onchange="getId($(this))">
        </div>
        <div class="form-group">
            <label>姓名</label>
            <input style="width: 50%" type="text" class="form-control" name="name">
        </div>
        <div class="form-group">
            <label>班级</label>
                    <input style="width: 50%"  class="form-control" id="subject" type="text" readOnly>
        </div>
        <input style="width: 50%"  class="form-control" id="classID" name="classID" type="hidden">
        <div class="form-group">
                <label>密码</label>
                <input style="width: 50%" type="password" id="psw" class="form-control" name="psw"
                       readOnly>
        </div>
        <button type="submit" class="btn btn-default">提交</button>
    </form>
</div>
<script type="text/javascript">
        function getId(obj) {
            var id=obj.val();
            $("#psw").attr("value",id.substring(6,12));
            $.ajax({
                url: 'doGetStudentClass?id='+id,
                type: 'POST',
                async: true,
                timeout: '3000',
                dataType: 'text',
                success: function (value) {
                    // 解析
                    var arr = JSON.parse(value);
                    $("#subject").attr("value",arr[0].subject);
                    $("#classID").attr("value",arr[0].id);

                }
            })
        }

    function choose() {
        var myDate = new Date();
        var tYear = myDate.getFullYear();
        var yy = tYear.toString().substr(0, 2);
        var options=$("#selectId option:selected");  //获取选中的项
        var num=options.val();   //拿到选中项的值
        var condition=yy+num;
        var ID=document.getElementById("b1");
        var req = new XMLHttpRequest();
        req.onreadystatechange = function() {
            if (req.readyState == 4) {
                var data = req.responseText;
                if (data==="none"){
                ID.value=condition+"01";
                }
                else {
                var end=Number(data)+1;
                if(end<10)
                ID.value=condition+"0"+end;
                else
                    ID.value=condition+end;
                }
            }
        }
        req.open("post", "<%=basePath%>doGetStudentID", true);
        req.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
        req.send("condition="+condition);
    }

</script>
</body>
</html>
