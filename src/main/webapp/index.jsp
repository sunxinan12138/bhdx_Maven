<%--
  Created by IntelliJ IDEA.
  User: 25778
  Date: 2020/2/17
  Time: 14:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<script>
    $(document).ready(
        function check() {
        var reg = /^[\w]{6,12}$/
        if(document.getElementById("newPassword").innerText.match(reg)){
            alert("The password is valid!");
        }
    })
</script>
<a href="/student">hellow!</a>
<div>
    <form action="/doChangePsw" method="post">
        请输入要修改的新密码<input type="text" name="newPassword" id="newPassword" onblur="check()"/>
        <input type="submit" value="提交"/>
    </form>
</div>
</body>
</html>
