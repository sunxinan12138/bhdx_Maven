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
    <title>我的毕业设计</title>
</head>
<body>
<script>
    $(document).ready(
        function check() {
            var reg = /^[\w]{6,12}$/
            if (document.getElementById("newPassword").innerText.match(reg)) {
                alert("The password is valid!");

            }
        })
</script>
<a href="/student">hellow!</a>
<div style="height: 1000px">
    <form action="/doChangePsw" method="post">
        请输入要修改的新密码<input type="text" name="newPassword" id="newPassword" onblur="check()"/>
        <input type="submit" value="提交"/>
    </form>
</div>
<div><a href="http://beian.miit.gov.cn">吉ICP备19007083号-1</a></div>
</body>
</html>
