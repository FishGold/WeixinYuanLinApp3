<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head lang="en">
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, user-scalable=no">
    <title>认养市场</title>
    <link href="../css/bootstrap.min.css" rel="stylesheet">
    <script src="../js/jquery.min.js"></script>
    <script src="../js/bootstrap.min.js"></script>
    <link href="../css/myAdoptSingle.css" rel="stylesheet">
</head>
<body>
<header>
    <img id="header" src="../images/util/1.jpg">
    <p id="title">收养的植物的名字</p>
</header>
<table>
    <tr>
        <th class="sign col">植物名称</th>
        <td>${plant.plantName}</td>
    </tr>
    <tr>
        <th class="sign col">捐赠人</th>
        <td>${plant.userName}</td>
    </tr>
    <tr>
        <th class="sign col">联系方式</th>
        <td>${plant.phone}</td>
    </tr>
    <tr>
        <th class="sign col">捐赠原因</th>
        <td>${plant.reason}</td>
    </tr>
    <tr>
        <th class="sign col">捐赠时间</th>
        <td>${plant.donateDate}</td>
    </tr>
</table><hr>
<p>&nbsp;相关照片</p><hr>

<img class="pic" src="../images/userDonate/1/${plant.image_1}">
<img class="pic" src="../images/userDonate/2/${plant.image_2}">
<img class="pic" src="../images/userDonate/3/${plant.image_3}">
<hr>
<button class="btn btn-primary btn-block" onclick="location.href='http://localhost:8080/myAdopt/main'">返  回</button>
<script>
    $("#header").height(screen.height/4);
</script>
</body>
</html>