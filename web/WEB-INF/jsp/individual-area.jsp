<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head lang="en">
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, user-scalable=no">
    <title>用户中心</title>
    <link href="../css/bootstrap.min.css" rel="stylesheet">
    <script src="../js/jquery.min.js"></script>
    <script src="../js/bootstrap.min.js"></script>
    <link rel="stylesheet" href="../css/individual-area.css">
</head>
<body>
<header>
    <img id="header" src="${picUrl}">
    <label id="userinfo">
        <span id="name">张三</span><br>
        <span id="number">[活跃度：${liveNumber}]</span>
    </label>
</header>
<hr>
<footer>
    <div class="title">更多栏目</div>
    <ul class="list-group">
        <li class="list-group-item">我的商城<span class="glyphicon glyphicon-circle-arrow-right sign"></span></li>
        <li class="list-group-item">我的社区<span class="glyphicon glyphicon-circle-arrow-right sign"></span></li>
    </ul>
    <div class="title">我的贡献</div>
    <ul class="list-group">
        <li class="list-group-item" onclick="location.href='http://localhost:8080/myDonate/main'">我的捐赠<span class="glyphicon glyphicon-circle-arrow-right sign"></span></li>
        <li class="list-group-item" onclick="location.href='http://localhost:8080/myAdopt/main'">我认养的<span class="glyphicon glyphicon-circle-arrow-right sign"></span></li>
        <li class="list-group-item" onclick="location.href='http://localhost:8080/myReport/main'">我的发现<span class="glyphicon glyphicon-circle-arrow-right sign"></span></li>

    </ul>
</footer>
<button class="btn btn-primary btn-block">返  回</button>
</body>
</html>