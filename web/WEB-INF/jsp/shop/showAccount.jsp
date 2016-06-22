<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1,user-scalable=no">
    <title>趣商城</title>

    <link href="../css/bootstrap.min.css" rel="stylesheet"/>
    <script src="../js/jquery.min.js"></script>
    <script src="../js/bootstrap.min.js"></script>
    <%--<base href="/">--%>
    <style>
        body{
            font-size: 12px;
            font-family: "Arial", "Microsoft YaHei", "黑体", "宋体", sans-serif;
        }
        .panel{
            margin-top: 15px;
        }
    </style>
</head>
<body>
<div class="container">
    <div class="panel panel-default">
        <div class="panel-heading">
            <p class="panel-title">基本信息</p>
        </div>
        <table class="table table-bordered">
            <tr><td>昵称</td><td>${user.nickname}</td></tr>
            <tr><td>真实姓名</td><td>${user.realName}</td></tr>
            <tr><td>住址</td><td>${user.nation}  ${user.address}</td></tr>
            <tr><td>性别</td><td>${user.sex}</td></tr>
            <tr><td>联系方式</td><td>${user.phoneNum}</td></tr>
            <tr><td>邮箱</td><td>${user.email}</td></tr>
        </table>
    </div>
    <!--<a type="submit" class="btn btn-default btn-block" href="userCenter.html">返回上一页</a>-->
</div>
</body>