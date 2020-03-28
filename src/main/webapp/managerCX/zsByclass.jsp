<%--
  Created by IntelliJ IDEA.
  User: 25778
  Date: 2020/3/27
  Time: 12:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<%
    String classid = request.getParameter("classId");
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<head>
    <base href="<%=basePath%>">
    <link rel="stylesheet" href="/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://cdn.staticfile.org/jquery/2.1.1/jquery.min.js"></script>
    <script src="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <script type="text/javascript" src="js/jquery-3.3.1.min.js"></script>
    <script type="text/javascript" src="js/bootstrap.js"></script>
    <base href="<%=basePath%>"/>
    <title><%=classid%>证书审核</title>
</head>
<body>
<script type="text/javascript">

    $(document).ready(
        function () {
            $.ajax({
                url: '',
                type: 'POST',
                async: true,
                timeout: '3000',
                dataType: 'text',
                success: function (e) {
                    // 解析
                    var arr = JSON.parse(e);
                    for (var i = 0; i < arr.length; i++) {
                        var $tr = $("<tr >" +
                            "<td>" + arr[i].id + "</td>" +
                            "<td>" + arr[i].name + "</td>" +
                            "<td>" + arr[i].classID + "</td>" +
                            "</tr>")
                        var $table = $("#tableid");
                        $table.append($tr);
                    }
                }
            })
        }
    )
</script>


<div class="panel panel-default">
    <div>
        <table class="table table-hover">
            <thead align="center">
            <tr>
                <th width="20%">学号</th>
                <th width="20%">证书</th>
                <th width="20%">等</th>
                <th width="10%">操作</th>
            </tr>
            </thead>
            <tbody class="panel-body" id="tableid" align="center">
            <tr>
                <th >201711111111</th>
                <th >四级</th>
                <th ><a target="_blank" href="managerZC/zsByclass.jsp?classId=20171111"> 审核证书</a></th>
                <th >操作</th>
            </tr>
            </tbody>
        </table>
    </div>
</div>
</div>
<div>
    <button type="button" class="btn btn-info">导出表格</button>
</div>
</body>
</html>
