<%--
  Created by IntelliJ IDEA.
  User: 25778
  Date: 2020/3/26
  Time: 12:17
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
    <link rel="stylesheet" href="/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://cdn.staticfile.org/jquery/2.1.1/jquery.min.js"></script>
    <script src="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <script type="text/javascript" src="js/jquery-3.3.1.min.js"></script>
    <script type="text/javascript" src="js/bootstrap.js"></script>
    <title>按班级查找和导出</title>
</head>
<body>
<script type="text/javascript" src="js/jquery-3.3.1.min.js"></script>
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
                        var $tr = $("<tr >" +
                            "<td>" + arr[i].subject + "</td>" +
                            "<td>" + arr[i].id + "</td>" +
                            "<td>" + "<a target='_blank' href='managerCX/zsByclass.jsp?classId=" + arr[i].id + "'> 审核证书</a>" + "</td>" +
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
                <th style="text-align: center" width="10%">班级</th>
                <th style="text-align: center" width="10%">专业代号</th>
                <th style="text-align: center" width="10%">操作</th>
            </tr>
            </thead>
            <tbody class="panel-body" id="tableid" align="center">

            </tbody>
        </table>
    </div>
</div>
</div>

</body>
</html>
