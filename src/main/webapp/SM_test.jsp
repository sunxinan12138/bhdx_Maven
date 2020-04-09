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
    <link rel="stylesheet" href="../css/bootstrap.min.css">
    <link rel="stylesheet" href="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/css/bootstrap.min.css">
</head>
<script type="text/javascript" src="js/jquery-3.3.1.min.js"></script>
<script type="text/javascript">
    $(document).ready(function(){
        var slist =JSON.parse(JSON.stringify( ${studentList}));
        for( var i = 0; i<slist.length;i++){
            var $tr = $("<tr>"+
                "<td >"+slist[i].id+"</td>"+
                "<td >"+slist[i].name+"</td>"+
                "<td >"+slist[i].tel+"</td>"+
                "<td >"+slist[i].address+"</td>"+
                "<td >"+slist[i].dormitory+"</td>"+
                "</tr>");
            var $table = $("#slist");
            $table.append($tr);
        }
    })
</script>
<body>
<table class="table table-bordered" >
    <thead align="center">
    <tr>
        <th width="5%">学号</th>
        <th width="5%">姓名</th>
        <th width="5%">电话号</th>
        <th width="5%">家庭住址</th>
        <th width="5%">寝室号</th>
    </tr>
    </thead>
    <tbody id="slist"  align="center">
    </tbody>
</table>
</body>
</html>