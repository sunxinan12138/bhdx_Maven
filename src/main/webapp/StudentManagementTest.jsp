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
<script>
    $(document).ready(
        function validateForm(){
        alert("shayebushi");
        $.ajax({
            //属性名:属性值
            //请求的路径
            url:'doSelectStudentByID',
            //请求的方式
            type:'POST',
            //是否异步
            async:true,
            //请求超时时间
            timeout:'3000',
            //传递数据的类型
            dataType:'text',
            //传递的数据
            // date:$("#studentID").innerText,
            success:function(d){
                //解析
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
    })
</script>
<body>
<div>
    <div>
        <form action="/doSelectStudentByID" method="post" name="myForm" enctype="application/x-www-form-urlencoded">
            <input type="text" name="studentID" placeholder="请输入学号" id="studentID" />
            <input type="submit" value="查询" onclick="validateForm()"/>
        </form>
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
</div>
<script type="text/javascript">

</script>
</body>
</html>
