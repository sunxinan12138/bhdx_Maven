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
    List<CXDetail> list = (List)obj;
%>
<html>
<head>
    <title>修改创新证书详情</title>
</head>
<body>
<%
    if (list.size() != 0){
        CXDetail cxDetail = list.get(0);
%>
<form action="./doUpdateCXById" method="post">
    <input type="hidden" name="id" id="id" value="<%=cxDetail.getId()%>"><br>
    学生&nbsp&nbsp&nbsp&nbsp&nbspid&nbsp:<input type="text" name="stuid" id="stuid" value="<%=cxDetail.getStuid() %>"><br>
    姓&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp名：<input type="text" name="name" id="name" value="<%=cxDetail.getName() %>"><br>
    证书名称：<input type="text" name="zsname" id="zsname" value="<%=cxDetail.getZsname() %>"><br>
    创新分数：<input type="text" name="mark" id="mark" value="<%=cxDetail.getMark() %>"><br>
    日&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp期： <input type="text" name="time" id="time" value="<%=cxDetail.getTime() %>"><br>
    sort&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp:&nbsp&nbsp&nbsp&nbsp<input type="text" name="sort" id="sort" value="<%=cxDetail.getSort() %>"><br>
    证书说明：<input type="text" name="remark" id="remark" value="<%=cxDetail.getRemark() %>"><br>
    班级&nbsp&nbspid&nbsp：<input type="text" name="classId" id="classId" value="<%=cxDetail.getClassId() %>"><br>
    <input type="submit" id="bnt" value="确认修改">
</form>
<%
    }
%>
</body>
</html>