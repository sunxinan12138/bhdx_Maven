<%@ page import="java.util.List" %>
<%@ page import="com.bhdx.models.CXDetail" %><%--
  Created by IntelliJ IDEA.
  User: luckystar
  Date: 2020/4/4
  Time: 12:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    Object obj = request.getAttribute("myList");
    List<CXDetail> list = (List) obj;
%>
<html>
<head>
    <script src="https://cdn.staticfile.org/jquery/2.1.1/jquery.min.js"></script>
    <script type="text/javascript" src="js/jquery-3.3.1.min.js"></script>
    <title>修改创新证书详情</title>
</head>
<body>
<%
    if (list.size() != 0) {
        CXDetail cxDetail = list.get(0);
%>
<div style="width:264px;height:360px; float:left;margin-left:50px;">
    <br/><img id="img" style="width:100%;height:100%;" src="">
</div>
<div style="float:left;margin-left:50px;">
    <form action="./doUpdateCXById" method="post">
        <input type="hidden" name="id" id="id" value="<%=cxDetail.getId()%>"><br>
        学生&nbsp&nbsp&nbsp&nbsp&nbspid&nbsp:<input type="text" name="stuid" id="stuid" value="<%=cxDetail.getStuid() %>"
                                                  style="border: 0px;" readonly="true"><br>
        姓&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp名：<input type="text" name="name" id="name" value="<%=cxDetail.getName() %>"
                                                     style="border: 0px;" readonly="true"><br>
        证书名称：<input type="text" name="zsname" id="zsname" value="<%=cxDetail.getZsName() %>" style="border: 0px;"
                    readonly="true"><br>
        创新分数：<input type="text" name="mark" id="mark" value="<%=cxDetail.getMark() %>"><br>
        日&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp期： <input type="text" name="time" id="time" value="<%=cxDetail.getTime() %>"><br>
        类型&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp:&nbsp&nbsp&nbsp&nbsp<input type="text" name="sort" id="sort"
                                                                    value="<%=cxDetail.getSort() %>"><br>
        证书说明：<input type="text" name="remark" id="remark" value="<%=cxDetail.getRemark() %>"><br>
        班级&nbsp&nbspid&nbsp：<input type="text" name="classID" id="classId" value="<%=cxDetail.getClassID() %>"
                                   style="border: 0px;" readonly="true"><br>
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
                    url: 'doshowImg',
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