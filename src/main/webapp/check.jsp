<%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 2020/3/20
  Time: 15:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>审核</title>
</head>
<body>
<div>
    <div>姓名：${UserName}</div>
    <div>所在班级所有证书：
        <c:forEach items="${zsDetails}" var="keyword" varStatus="id">
            ${id.index} ${keyword}
        </c:forEach>
    </div>
</div>
</body>
</html>
