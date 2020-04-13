<%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 2020/4/8
  Time: 1:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>班级审核</title>
    <link rel="stylesheet" href="../css/bootstrap.min.css">
    <link rel="stylesheet" href="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/css/bootstrap.min.css">
</head>
<script type="text/javascript" src="js/jquery-3.3.1.min.js"></script>
<script type="text/javascript">
    function arrayBufferToBase64( buffer ) {
        var binary = '';
        var bytes = new Uint8Array( buffer );
        var len = bytes.byteLength;
        for (var i = 0; i < len; i++) {
            binary += String.fromCharCode( bytes[ i ] );
        }
        return window.btoa( binary );
    }
    /*响应状态status为canceled的时候修改一下同步异步*/
    $(document).ready(function (){
        var ID = ${UserID};
        document.getElementById("stuZCdetail").style.display = 'none';
        document.getElementById("stuCXdetail").style.display = 'none';
        $.ajax({
            url:'doSelectZCByClassID', type:'POST', async:false, timeout:'3000', dataType:'text', data:{'ID':ID},
            success:function(d){
                var zclist = JSON.parse(d);
                for( var i = 0; i<zclist.length;i++){
                    var str12 = arrayBufferToBase64(zclist[i].img);
                    var $tr = $("<tr>"+
                        "<td >"+zclist[i].stuid+"</td>"+ "<td >"+zclist[i].name+"</td>"+ "<td >"+zclist[i].zsName+"</td>"+ "<td >"+zclist[i].mark+"</td>"+
                        "<td >"+zclist[i].time+"</td>"+ "<td >"+zclist[i].zk+"</td>"+ "<td >"+zclist[i].remark+"</td>"+ "<td >"+
                        "<img src=\'data:image/jpeg;base64,"+str12+"' width='10%' >"+"</td>"+
                        "<td >"+zclist[i].shCondition+"</td>"+
                        "</tr>");
                    var $table = $("#zcdetail");
                    $table.append($tr);
                }
            }
        })
        $.ajax({
            url:'doSelectCXByClassID', type:'POST', async:false, timeout:'3000', dataType:'text', data:{'ID':ID},
            success:function(d){
                var cxlist = JSON.parse(d);
                for( var i = 0; i<cxlist.length;i++){
                    var str12 = arrayBufferToBase64(cxlist[i].img);
                    var $tr = $("<tr>"+
                        "<td >"+cxlist[i].stuid+"</td>"+ "<td >"+cxlist[i].name+"</td>"+ "<td >"+cxlist[i].zsName+"</td>"+
                        "<td >"+cxlist[i].mark+"</td>"+ "<td >"+cxlist[i].time+"</td>"+ "<td >"+cxlist[i].sort+"</td>"+
                        "<td >"+cxlist[i].remark+"</td>"+ "<td >"+"<img src=\'data:image/jpeg;base64,"+str12+"' width='10%' >"+"</td>"+
                        "<td >"+cxlist[i].shCondition+"</td>"+
                        "</tr>");
                    var $table = $("#cxdetail");
                    $table.append($tr);
                }
            }
        })
    })
    function selectZCorCX() {
       var change =  $("#01").val();
       if(change == '综测'){
           document.getElementById("stuZCdetail").style.display = 'block';
           document.getElementById("stuCXdetail").style.display = 'none';
       }else if(change == '创新'){
           document.getElementById("stuZCdetail").style.display = 'none';
           document.getElementById("stuCXdetail").style.display = 'block';
       }
    }

</script>
<body>
<div width="300px">
    班级名：${UserName}<div style="width: 200px">
    <select id="01" name="classId" onchange="selectZCorCX()" class="form-control" >
    <option>请选择</option>
    <option id="01_1">综测</option>
    <option id="01_2">创新</option>
    </select></div>
</div>
<div id="first">
    <table id="stuCXdetail" class="table table-bordered" align="center" >
        <thead align="center">
        <tr>
            <th width="10%">学号</th>
            <th width="10%">姓名</th>
            <th width="10%">证书名</th>
            <th width="10%">分数</th>
            <th width="10%">学期</th>
            <th width="10%">类别</th>
            <th width="10%">备注</th>
            <th width="10%">证书图片</th>
            <th width="10%">审核状态</th>
        </tr>
        </thead>
        <tbody id="cxdetail"  align="center">
        </tbody>
    </table>
    <table id="stuZCdetail" class="table table-bordered" align="center">
        <thead align="center">
        <tr>
            <th width="10%">学号</th>
            <th width="10%">姓名</th>
            <th width="10%">证书名</th>
            <th width="10%">分数</th>
            <th width="10%">学期</th>
            <th width="10%">折扣</th>
            <th width="10%">备注</th>
            <th width="10%">证书图片</th>
            <th width="10%">审核状态</th>
        </tr>
        </thead>
        <tbody id="zcdetail"  align="center">
        </tbody>
    </table>
</div>
</body>
</html>
