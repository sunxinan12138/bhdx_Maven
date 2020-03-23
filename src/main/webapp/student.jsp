<%--
  Created by IntelliJ IDEA.
  User: 25778
  Date: 2020/2/16
  Time: 20:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@page isELIgnored="false" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Test</title>
</head>
<body>
<h2>显示学生</h2>
<c:forEach items="${student}" var="student">
    ${student.id}
    ${student.psw}
    ${student.name}<br>
</c:forEach>
test
<%=session.getAttribute("stuid")%>
</body>
</html>
