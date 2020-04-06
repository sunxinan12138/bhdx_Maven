<%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 2020/4/6
  Time: 10:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>classManaggement</title>
</head>

<script type="text/javascript" src="js/jquery-3.3.1.min.js"></script>
<script type="text/javascript">
    function selectClassByID() {
        var stuAdmin = document.getElementById("addClassAdmin").value;
        $.ajax({
            url: 'selectClassByID', type: 'POST', async: true, timeout: '3000', dataType: 'text', data: {'stuAdmin': stuAdmin},
            success: function (d) {
            var newClassAdmin = JSON.parse(d);
            if(!newClassAdmin.startsWith("e")){
                if(confirm("确认添加\""+newClassAdmin+"\"管理员吗？")){
                       $.ajax({
                           url: 'doAddStuAdmin', type: 'POST', async: true, timeout: '3000', dataType: 'text', data: {'classID': stuAdmin},
                           success: function (d) {
                               var result = JSON.parse(d);
                               if(result==true){
                                   alert("添加成功");
                                   window.location.reload();
                               }else{
                                   alert("添加失败");
                               }
                           }
                       })
                }
                }else { alert("输入的班级不存在，请添加或输入有效的班级")}
            }
        })
    }

</script>

<body>
<div>
    <input id="addClassAdmin" type="text"  /> <input type="button" onclick="selectClassByID()" value="添加班级管理员">
</div>
</body>
</html>
