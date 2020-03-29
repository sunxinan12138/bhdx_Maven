<%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 2020/3/29
  Time: 10:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<script type="text/javascript" src="js/jquery-3.3.1.min.js"></script>
<script type="text/javascript">
    function checkUnique() {
        var str = document.getElementById("password").value;
        var regUpper = /[A-Z]/;
        var regLower = /[a-z]/;
        var regStr = /[^A-Za-z0-9]/;
        var complex = 0;
        if (regLower.test(str)) {
            ++complex;
        }
        if (regUpper.test(str)) {
            ++complex;
        }
        if (regStr.test(str)) {
            ++complex;
        }
        if (complex < 3 || str.length < 8) {
            alert("包含大小写字母，数字,特殊字符,长度至少8位");
        } else {
            alert("成功");
        }
    }
    function changePassword(){
        var p1=document.getElementById("password").value;
        var p2=document.getElementById("password2").value;
        if(p2!==p1){
            document.getElementById("02").innerHTML="<span style='color:red'>两次密码输入不一致</span>";
        }
        if(p2==p1){
            document.getElementById("02").innerHTML="<span style='display: none'>输入一致</span>"
                var newPassword = $("#password").val();
                $.ajax({
                    url:'doChangePsw',
                    type:'POST',
                    async:true,
                    timeout:'3000',
                    dataType:'text',
                    data:{'newPassword':newPassword},
                    success:function(d){
                        var result = JSON.parse(d);
                        if(result==true){
                            alert("修改成功");
                        }else{
                            alert("修改失败");
                        }
                    }
                })
            }
    }
</script>
<body>
<div>
    <div>
        <div>修改密码：<input type="password" name="password" placeholder="请输入要修改的密码" id="password" onblur="checkUnique()"/></div>
        <div>确认密码：<input type="password" name="password2" placeholder="再输入一次密码" id="password2"/><span id="02"></span><br/></div>
        <input type="submit" value="查询" onclick="changePassword()"/>
    </div>
</div>
</body>
</html>
