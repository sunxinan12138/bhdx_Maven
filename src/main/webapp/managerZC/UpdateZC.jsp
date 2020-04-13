<%@ page import="com.bhdx.models.ZCDetail" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: luckystar
  Date: 2020/4/5
  Time: 18:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    Object obj = request.getAttribute("myList");
    List<ZCDetail> list = (List) obj;
%>
<html>
<head>
    <link rel="stylesheet" href="/css/bootstrap.min.css">
    <link rel="stylesheet" href="layer/theme/default/layer.css">
    <link rel="stylesheet" href="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://cdn.staticfile.org/jquery/2.1.1/jquery.min.js"></script>
    <script src="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <script type="text/javascript" src="js/jquery-3.3.1.min.js"></script>
    <script type="text/javascript" src="js/bootstrap.js"></script>
    <script src="layer/layer.js"></script>
    <title>修改综测证书详情</title>
</head>
<body>
<script type="text/javascript" src="js/jquery-3.3.1.min.js"></script>
<script type="text/javascript">
    $(document).ready(
        function () {
            $.ajax({
                type: 'GET',
                url: 'doSelectZK',
                data: '',
                async: true,
                dataType: 'text',
                timeout: 4000,
                success: function (json) {
                    console.log(json);
                    var attr = JSON.parse(json);
                    for (var i = 0; i < attr.length; i++) {
                        var $option = $("<option value=" + attr[i].type + ">" + attr[i].type + "</option>")
                        $("#zk").append($option);
                    }
                }
            });
        })
</script>
<%
    if (list.size() != 0) {
        ZCDetail zcDetail = list.get(0);
%>
<div style="width:264px;height:360px; float:left;margin-left:50px;">
    <br/><img id="img" style="width:100%;height:100%;" src="">
</div>
<div style="float:left;margin-left:50px;">
    <form action="./doUpdateZCById" method="post">
        <input  type="hidden" name="id" id="id" value="<%=zcDetail.getId()%>"><br>
        学生&nbsp&nbsp&nbsp&nbsp&nbspid&nbsp:<input type="text" name="stuid" id="stuid" value="<%=zcDetail.getStuid() %>"
                                                  style="border: 0px;" readonly="true"><br>
        姓&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp名：<input type="text" name="name" id="name" value="<%=zcDetail.getName() %>"
                                                     style="border: 0px;" readonly="true"><br>
        证书名称：<input type="text" name="zsname" id="zsname" value="<%=zcDetail.getZsName() %>" style="border: 0px;"
                    readonly="true"><br>
        折扣&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp:<select name="zk"
                                                                     id="zk" <%--value="<%=zcDetail.getZk() %>"--%>
                                                                     style="width: 200px;"></select>
        <%--<input type="text" name="zk" id="zk" value="<%=zcDetail.getZk() %>">--%><br>
        创新分数：<input type="text" name="mark" id="mark" value="<%=zcDetail.getMark() %>"><br>
        日&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp期 :<input type="text" name="time" id="time"
                                                                value="<%=zcDetail.getTime() %>"><br>
        证书说明：<input type="text" name="remark" id="remark" value="<%=zcDetail.getRemark() %>"><br>
        班级&nbsp&nbsp&nbspid&nbsp：<input style="border: 0px;" type="text" name="classId" id="classId" readonly="readonly"
                                        value="<%=zcDetail.getClassID() %>"><br>
        <%--证书图片：<input type="file" src="images/<%=zcDetail.getImgName()%>" style="width: 30%;height: 30%;"><br>--%>
        <input type="submit" id="bnt" value="确认修改">
    </form>
</div>
<%
    }
%>

<script type="text/javascript">
    $(document).ready(
        function () {
            var e = <%=list.get(0).getId()%>;
            $.ajax({
                url: 'doshowImgZC',
                type: 'POST',
                async: true,
                timeout: '5000',
                dataType: 'text',
                data: {'id': e},
                success: function (d) {
                    var a = JSON.parse(d);
                    $("#img").attr("src", a);
                }
            })
        })
</script>
</body>
</html>
