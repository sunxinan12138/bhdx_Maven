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
    List<ZCDetail> list = (List)obj;
%>
<html>
<head>
    <title>修改综测证书详情</title>
</head>
<body>
<%
    if (list.size() != 0){
        ZCDetail zcDetail = list.get(0);
%>
<form action="./doUpdateZCById" method="post">
    <input type="hidden" name="id" id="id" value="<%=zcDetail.getId()%>"><br>
    学生&nbsp&nbsp&nbsp&nbsp&nbspid&nbsp:<input type="text" name="stuid" id="stuid" value="<%=zcDetail.getStuid() %>"><br>
    姓&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp名：<input type="text" name="name" id="name" value="<%=zcDetail.getName() %>"><br>
    证书名称：<input type="text" name="zsname" id="zsname" value="<%=zcDetail.getZsName() %>"><br>
    zk&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp:&nbsp&nbsp&nbsp&nbsp:<input type="text" name="zk" id="zk" value="<%=zcDetail.getZk() %>"><br>
    创新分数：<input type="text" name="mark" id="mark" value="<%=zcDetail.getMark() %>"><br>
    日&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp期 :<input type="text" name="time" id="time" value="<%=zcDetail.getTime() %>"><br>
    证书说明：<input type="text" name="remark" id="remark" value="<%=zcDetail.getRemark() %>"><br>
    班级&nbsp&nbspid&nbsp：<input type="text" name="classId" id="classId" value="<%=zcDetail.getClassID() %>"><br>
    <input type="submit" id="bnt" value="确认修改">
</form>
<%
    }
%>
</body>
</html>
