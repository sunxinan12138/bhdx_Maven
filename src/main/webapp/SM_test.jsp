<%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 2020/4/1
  Time: 20:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<html>
<head>
    <title>Title</title>
</head>
<body>

<c:forEach items="${studentList}" var="item" varStatus="status">
    <tr >
    <td class="center"><span class="center">${item.name}</span></td>
    <td>${item.classID}</td>
    <td>${item.psw}</td>
    </tr>
</c:forEach>
</body>
</html>
