<%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 2020/3/24
  Time: 14:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Test</title>
</head>
<script type="text/javascript" src="js/jquery-3.3.1.min.js"></script>
<script type="text/javascript">
        function validateForm(){
            var hhh = $("#studentID").val();
        $.ajax({
            url:'doSelectStudentByID',
            type:'POST',
            async:true,
            timeout:'3000',
            dataType:'text',
            data:{'hhh':hhh},
            success:function(d){
                var studentArray = JSON.parse(d);
                for(var i = 0;i < studentArray.length;i++){
                    console.log(studentArray);
                    var $tr = $("<tr >"+
                        "<td>"+studentArray[i].id+"</td>"+
                        "<td>"+studentArray[i].name+"</td>"+
                        "<td>"+studentArray[i].classID+"</td>"+
                        "</tr>");
                    var $table = $("#tableclass");
                    $table.append($tr);
                }
            }
    })
    }
        function addNewclass () {
            var newClass = $("#addClass").val();
            $.ajax({
                url:'doAddNewClass',
                type:'POST',
                async:true,
                timeout:'3000',
                dataType:'text',
                data:{'newClass':newClass},
                success:function(d){
                    var result = JSON.parse(d);
                    if(result==true){
                        alert("添加成功");
                    }else{
                        alert("添加失败");
                    }
                }
            })
        }
        $(document).ready(function () {
            $.ajax({
                url:'doSelectAllClass',
                type:'POST',
                async:true,
                timeout:'3000',
                dataType:'text',
                success:function(d){
                    var SubjectClassArray = JSON.parse(d);
                    for(var i = 0;i < SubjectClassArray.length;i++){
                    var $tr = $("<tr>"+
                        "<td>"+SubjectClassArray[i].id+"</td>"+
                        "<td>"+SubjectClassArray[i].subject+"</td>"+
                        "<td>"+"<a href='#'>"+"查看"+"</a>"+"</td>"+
                        "</tr>");
                    var $table = $("#subject");
                    $table.append($tr);
                }
                    document.getElementById("cla").innerHTML="<div style='display: none'></div>"
                }
            })
        });
</script>
<body>
<div>
    <div>
            <input type="text" name="studentID" placeholder="请输入学号" id="studentID" />
            <input type="submit" value="查询" onclick="validateForm()"/>
    </div>
    <div>
        <input type="text" name="studentID" placeholder="请添加班级 例：17160501" id="addClass" />
        <input type="submit" value="添加" onclick="addNewclass()"/>
    </div>
    <div>
        <table class="table table-hover" >
            <thead align="center">
            <tr>
                <th width="10%">学号</th>
                <th width="20%">姓名</th>
                <th width="10%">班级编号</th>
            </tr>
            </thead>
            <tbody id="tableclass"  align="center">
            </tbody>
        </table>
    </div>
    <div>
        <table class="table table-hover" >
            <thead align="center">
            <tr>
                <th width="10%">班级编号</th>
                <th width="20%">班级</th>
                <th width="10%">查看班级</th>
            </tr>
            </thead>
            <tbody id="subject"  align="center">
            </tbody>
        </table>
    </div>
</div>
</body>
</html>
