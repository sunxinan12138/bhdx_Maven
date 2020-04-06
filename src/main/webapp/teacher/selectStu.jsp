<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<head>
    <base href="<%=basePath%>">
    <link rel="stylesheet" href="../css/bootstrap.min.css">
    <link rel="stylesheet" href="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://cdn.staticfile.org/jquery/2.1.1/jquery.min.js"></script>
    <script src="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <script type="text/javascript" src="../js/jquery-3.3.1.min.js"></script>
    <script type="text/javascript" src="../js/bootstrap.js"></script>
    <title>按班级查找学生</title>
</head>
<body>
<script type="text/javascript">
    $(document).ready(
        function () {
            $.ajax({
                type:'GET',
                url:'doSelectAllClass',
                data:'',
                async: true,
                dataType:'text',
                timeout:4000,
                success: function( json ){

                    var attr = JSON.parse(json);
                    for ( var i = 0 ; i < attr.length ; i ++ )
                    {
                        var $option = $("<option value="+attr[i].id+">"+attr[i].subject+"</option>")
                        $("#01").append($option);
                    }
                }
            });
        })
    function getStuById(obj)
    {
        var classId = obj.val();
        $("#02").html("");
        $.ajax({
            type:'POST',
            url:'doGetStuByCId?classId='+classId,
            data:'',
            async: true,
            dataType:'text',
            timeout:4000,
            success: function( json ){
                var attr = JSON.parse(json);
                for ( var i = 0 ; i < attr.length ; i ++ )
                {
                    var $tr = $("<tr>" +
                            "<td>"+attr[i].id+"</td>"+
                            "<td>"+attr[i].name+"</td>"+
                            "<td>"+attr[i].tel+"</td>"+
                            "<td>"+attr[i].address+"</td>"+
                            "<td>"+attr[i].dormitory+"</td>"+
                    "</tr>")
                    $("#02").append($tr);
                }
            }
        });
    }
</script>
<div>
    <div>
        <select id="01" name="classId" onchange="getStuById($(this))">
            <option>--请选择班级--</option>
        </select>
    </div>
    <div>
        <table class="table table-hover" >
         <thead align="center">
         <tr>
            <th width="10%">学号</th>
            <th width="10%">姓名</th>
            <th width="10%">联系电话</th>
             <th width=20%">地址</th>
             <th width="10%">寝室号</th>
        </tr>
        </thead>
        <tbody id="02"></tbody>
    </table>
</div>
</div>
</body>
</html>
