<%@ page import="java.io.File" %>
<%@ page import="java.io.FileWriter" %><%--
  Created by IntelliJ IDEA.
  User: luckystar
  Date: 2020/4/1
  Time: 13:54
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
    <link rel="stylesheet" href="css/bootstrap.min.css">
    <link rel="stylesheet" href="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/css/bootstrap.min.css">
    <link rel="stylesheet" href="layer/theme/default/layer.css">
    <script src="https://cdn.staticfile.org/jquery/2.1.1/jquery.min.js"></script>
    <script src="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <script type="text/javascript" src="js/jquery-3.3.1.min.js"></script>
    <script type="text/javascript" src="js/bootstrap.js"></script>
    <script src="layer/layer.js"></script>
    <title>按班级查找创新</title>
    <%--<meta http-equiv="pragma" content="no-cache">--%>
    <%--<meta http-equiv="cache-control" content="no-cache">--%>
    <%--<meta http-equiv="expires" content="0">--%>
    <%--<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">--%>
    <%--<meta http-equiv="description" content="This is my page">--%>
</head>
<body>
<script type="text/javascript" src="js/jquery-3.3.1.min.js"></script>
<script type="text/javascript">
    $(document).ready(
        function () {
            var classId = $("#01").val();//应该获取下拉框选中的值
            //console.log(classId);
            $("#01").change(function () {
                $("#CX-table tbody").html("");
            });
            $.ajax({
                type: 'POST',
                url: 'doSelectCXByClass',
                data: {'classId': classId},
                async: true,
                dataType: 'text',
                timeout: 4000,
                success: function (json) {
                    var attr = JSON.parse(json);
                    for (var i = 0; i < attr.length; i++) {
                        var CXid = attr[i].id;
                        var $tr = $("<tr>" +
                            "<td>" + attr[i].id + "</td>" +
                            "<td>" + attr[i].stuid + "</td>" +
                            "<td>" + attr[i].name + "</td>" +
                            "<td>" + attr[i].zsName + "</td>" +
                            "<td>" + attr[i].mark + "</td>" +
                            "<td>" + attr[i].remark + "</td>" +
                            "<td>" + attr[i].time + "</td>" +
                            "<td>" + attr[i].sort + "</td>" +
                            "<td>" + attr[i].classID + "</td>" +
                            "<td><a href='javascript:examImg(" + attr[i].id + ")'>查看</a></td>" +
                            "<td><a href='javascript:' onclick='matterAccess(" + CXid + ")'>通过</a>|&nbsp<a href='javascript:' onclick='matterNoAccess(" + CXid + ")'>不通过</a></td>" +
                            "<td><a href='doSelectCXById?CXid=" + CXid + "'>修改</a></td></tr>")
                        $("#02").append($tr);//页面显示数据
                    }
                }
            });
        })

    // //审核通过，弹出框
    // function matterAccess(CXid) {
    //     //设置弹出框样式
    //     var html = '<textarea onkeyup="word_limit(this,400);" style="width:90%;height:90%;display:block;margin:0 auto;" placeholder="最多输入400个字" id="content_text"></textarea>';
    //     var status = '0';//标记审核通过
    //     layer.open({
    //         title: "审核通过的消息",
    //         type: 1,
    //         area: ['500px', '400px'],
    //         closeBtn: 1,
    //         anim: 2,
    //         shadeClose: true, //开启遮罩关闭
    //         content: html
    //         , btn: ['确定', '取消']
    //         , yes: function (index, layero) {
    //             var remark = $("#content_text").val();
    //             if (remark == null || remark == "") {
    //                 remark = "审核通过";
    //             }
    //             var passStr = $('#pass input[name="sendMsg"]:checked').val();
    //             $('.wait_pop').show();
    //             $.post(
    //                 "./doAccessCX",
    //                 {"CXid": CXid, "remark": remark, "status": status},
    //                 function (data) {
    //                     var result = JSON.parse(data);
    //                     if (result == true) {
    //                         alert("审核成功");
    //                         window.location.reload();
    //                     } else {
    //                         alert("审核失败");
    //                         window.location.reload();
    //                     }
    //                 }, 'json')
    //         }
    //         , btn2: function (index, layero) {
    //             var closeType = $('#closeType').val();
    //             if (closeType == '1') {
    //                 // history.go(-1);
    //                 top.location.reload();
    //             } else {
    //                 layer.close(index);
    //             }
    //         }
    //     });
    // }
    // 审核通过
    function matterAccess(CXid) {
        $.ajax({
            url: 'doAccessCX',
            type: 'POST',
            async: true,
            timeout: '3000',
            dataType: 'text',
            data: {"CXid": CXid, "remark": "审核通过", "status": 0},
            success: function (data) {
                var result = JSON.parse(data);
                if (result == true) {
                    alert("审核成功");
                    window.location.reload();
                } else {
                    alert("审核失败");
                    window.location.reload();
                }
            }
        })
    }


    //审核不通过，弹出框
    function matterNoAccess(CXid) {
        //设置弹出框样式
        var html = '<textarea onkeyup="word_limit(this,400);" style="width:90%;height:90%;display:block;margin:0 auto;" placeholder="最多输入400个字" id="content_text"></textarea>';
        var status = '1';//标记审核不通过
        layer.open({
            title: "审核不通过的消息",
            type: 1,
            area: ['500px', '400px'],
            closeBtn: 1,
            anim: 2,
            shadeClose: true, //开启遮罩关闭
            content: html
            , btn: ['确定', '取消']
            , yes: function (index, layero) {
                var remark = $("#content_text").val();
                if (remark == null || remark == "") {
                    remark = "审核不通过";
                }
                var passStr = $('#pass input[name="sendMsg"]:checked').val();
                $('.wait_pop').show();
                $.post(
                    "./doAccessCX",
                    {"CXid": CXid, "remark": remark, "status": status},
                    function (data) {
                        var result = JSON.parse(data);
                        alert(result);
                        if (result == true) {
                            alert("审核成功");
                            window.location.reload();
                        } else {
                            alert("审核失败");
                            window.location.reload();
                        }
                    }, 'json')
            }
            , btn2: function (index, layero) {
                var closeType = $('#closeType').val();
                if (closeType == '1') {
                    // history.go(-1);
                    top.location.reload();
                } else {
                    layer.close(index);
                }
            }

        });
    }

    //删除方法
    function deleteCXById(CXid) {
        //alert(CXid);
        $.ajax({
            url: 'doDeleteCXById',
            type: 'POST',
            async: true,
            timeout: '3000',
            dataType: 'text',
            data: {'CXid': CXid},
            success: function (d) {
                var result = JSON.parse(d);
                if (result == true) {
                    alert("删除成功");
                    window.location.reload();
                } else {
                    alert("删除失败");
                }
            }
        })
    }

    //弹出图片
    function examImg(e) {
        //设置弹出框样式
        var html = '<img onkeyup="word_limit(this,400);" src="images/imgCX15.jpg" style="width:90%;height:90%;display:block;margin:0 auto;"  id="content_text"></textarea>';
        var status = '0';//标记审核通过
        $.ajax({
            url: 'doshowImg',
            type: 'POST',
            async: true,
            timeout: '3000',
            dataType: 'text',
            data: {'id': e},
            success: function (d) {
                var a = JSON.parse(d);
                $("#content_text").attr("src", a);
            }
        })
        layer.open({
            title: "查看图片",
            type: 1,
            area: ['600px', '500px'],
            closeBtn: 1,
            anim: 2,
            shadeClose: true, //开启遮罩关闭
            content: html
        });
    }

</script>
<div>
    <%--<div>--%>
    <%--<select id="01" name="classId" onchange="getCXByClass()">--%>
    <%--<option>--请选择班级--</option>--%>
    <%--</select>--%>
    <%--</div>--%>

    <div>
        <input type="text" id="01" disabled value=<%=classid%>>
    </div>
    <div>
        <table class="table table-hover" id="CX-table">
            <thead align="center">
            <tr>
                <th width="5%">编号</th>
                <th width="10%">学生id</th>
                <th width="5%">姓名</th>
                <th width="10%">证书名称</th>
                <th width="5%">mark</th>
                <th width="10%">remark</th>
                <th width="10%">日期</th>
                <th width="5%">sort</th>
                <th width="10%">班级id</th>
                <th width="10%">图片</th>
                <th width="15%">审核状态</th>
                <th width="20%">操作</th>
            </tr>
            </thead>
            <tbody id="02" align="center"></tbody>
        </table>
    </div>
</div>
</div>
</body>
</html>