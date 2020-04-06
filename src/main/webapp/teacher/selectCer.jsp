<%--
  Created by IntelliJ IDEA.
  User: 张大屌
  Date: 2020/3/31
  Time: 18:03
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
    <link rel="stylesheet" href="../css/bootstrap.min.css">
    <link rel="stylesheet" href="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://cdn.staticfile.org/jquery/2.1.1/jquery.min.js"></script>
    <script src="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <script type="text/javascript" src="../js/jquery-3.3.1.min.js"></script>
    <script type="text/javascript" src="../js/bootstrap.js"></script>
    <title>按学号查询证书</title>
</head>
<script type="text/javascript">
    function check()
    {
        $("#02").html('');
        $("#divAp").html('');
        var rd = $('input:radio[name="rd"]:checked').val();
        var stuId = $("#01").val();
        var flag = false;
        if( rd == "zc" ) {
            flag = true;
        }
        else {
            flag = false;
        }

        if( rd == null ){
            $("#02").html('*请选择综测或创新！');
        }
        else if( stuId.length <= 0 ||  !/[1-9]\d*/.test( stuId ) || stuId.length != 12){
            $("#02").html('*学生学号为空或格式不正确！');
        }
        else{
            var c = '';
            c += '<table class="table table-hover">' +
                '<thead align="center">'+
                '<tr>' +
                '<th width="10%">学号</th>' +
                '<th width="10%">姓名</th>' +
                '<th width="10%">证书</th>' +
                '<th width=10%">分值</th>';
            if( flag ){
                c += '<th width="10%">折扣</th>';
            }
            else{
                c += '<th width="10%">种类</th>';
            }

            c += '<th width="50%">原因</th>' +
                '</tr> ' +
                '</thead>' +
                '<tbody>';
            $.ajax({
                type:'POST',
                url:'doGetCerByStuId',
                data:{'rd': rd , 'stuId': stuId },
                async: true,
                dataType:'text',
                timeout:4000,
                success: function( json ){
                    var attr = JSON.parse(json);
                    for ( var i = 0 ; i < attr.length ; i ++ ){

                        c += '<tr>' +
                            '<td>'+attr[i].stuid+'</td>' +
                            '<td>'+attr[i].name+'</td>' +
                            '<td>'+attr[i].zsname+'</td>' +
                            '<td>'+attr[i].mark+'</td>';
                        if( flag ){
                            c += '<td>'+attr[i].zk+'</td>';
                        }
                        else{
                            c += '<td>'+attr[i].sort+'</td>';
                        }
                        c += '<td>'+attr[i].cause+'</td></tr>'
                    }
                    c += '</tbody></table>';
                    if( attr.length == 0 ) {
                        c = '暂无数据';
                        $("#01").val("");
                    }
                    $("#divAp").html(c);
                }
            });
        }
    }
</script>
<body>
<div>
    <div>
        <input type="radio" name="rd" value="zc" checked="checked">综测
        <input type="radio" name="rd" value="cx">创新
    </div>
    <div>
        <input type="text" id="01" placeholder="请输入学生学号">
        <span style="color:red;font-size: 12px;" id="02"></span>
    </div>
    <input type="button" value="查询" onclick="check()">
    <div id="divAp"></div>
</div>
</body>
</html>
