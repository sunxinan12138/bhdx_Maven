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
    // 根据学号查询ID
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
                window.location.reload();
            }
    })
    }
    // 添加新班级
        function addNewclass () {
            if (confirm("确认添加?")){
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
                        window.location.reload();
                    }else{
                        alert("添加失败");
                    }
                }
            })
        }

        }
        //查询所有班级
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
                    var sid = SubjectClassArray[i].id;
                    var $tr = $("<tr>"+
                        "<td id=\""+sid+"\">"+SubjectClassArray[i].id+"</td>"+
                        "<td id=\""+sid+1+"\">"+SubjectClassArray[i].subject+"</td>"+
                        "<td>"+"<a href='javascript:selectallStudent(\""+sid+"\")'>"+"查看"+"</a>"+"    "+"<a href='javascript:deleteClass(\"" + sid+ "\")'>"+"删除"+"</a>"+"    "+"<a id=\""+sid+2+"\" href='javascript:updateClass(\"" + sid+ "\")'>"+"修改班级"+"</a>"+"</td>"+
                        "</tr>");
                    var $table = $("#subject");
                    $table.append($tr);
                }
                }
            })
        });
        //删除班级
        function deleteClass(sid) {
            if (confirm("确认删除"+document.getElementById(sid+1).innerText+"吗?")){
                $.ajax({
                    url:'doDeleteClass',
                    type:'POST',
                    async:true,
                    timeout:'3000',
                    dataType:'text',
                    data:{'sid':sid},
                    success:function(d){
                        var result = JSON.parse(d);
                        if(result==true){
                            alert("删除成功");
                            window.location.reload();
                        }else{
                            alert("删除失败");
                        }
                    }
                })
            }
        }
        //修改班级
        function updateClass(sid){
            document.getElementById(sid+1).innerHTML = "<input type='text'  name='newSub' id='\""+sid+5+"\"' placeholder="+document.getElementById(sid+1).innerText+" >";
            document.getElementById(sid+2).innerHTML = "<a href='javascript:commitUpdateClass(\""+sid+"\")' id='\""+sid+6+"\"'>提交修改</a>"
            /*function undo(){
                document.getElementById(sid+5).innerHTML = "<td id=\""+sid+1+"\">+document.getElementById(sid+1).innerText+</td>"
                document.getElementById(sid+6).innerHTML = "<a id=\""+sid+2+"\" href='javascript:updateClass(\""+sid+"\")>+'修改班级'+</a>"
            }*/
        }
        //提交修改班级
        function commitUpdateClass(oldsid) {
            if (confirm("修改【"+document.getElementById(sid+1).innerText+"】吗?")){
                var sAndsid = oldsid
                sAndsid = oldsid +"_"+$("input[id='\""+oldsid+5+"\"']").val();
                $.ajax({
                    url:'commitUpdateClass',
                    type:'POST',
                    async:true,
                    timeout:'3000',
                    dataType:'text',
                    data:{'sAndsid':sAndsid},
                    success:function(d){
                        var result = JSON.parse(d);
                        if(result==true){
                            alert("修改成功");
                            window.location.reload();
                        }else{
                            alert("修改失败");
                        }
                    }
                })
            }

        }
        //根据班级ID查询本班所有学生
    function selectallStudent(sid){
        if (confirm("查询编号是【"+document.getElementById(sid+1).innerText+"】吗?")){
            window.location.href="doselectAllStudentById?sid="+sid;
        }
    }
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
        <table class="table table-hover" border="">
            <thead align="center">
            <tr>
                <th width="10%">班级编号</th>
                <th width="20%">班级</th>
                <th width="10%">操作班级</th>
            </tr>
            </thead>
            <tbody id="subject"  align="center">
            </tbody>
        </table>
    </div>
</div>
</body>
</html>
