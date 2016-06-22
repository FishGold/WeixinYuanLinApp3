<%--
  Created by IntelliJ IDEA.
  User: zss
  Date: 2016/6/10
  Time: 15:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1,user-scalable=no">
  <title>个人中心</title>
  <link href="../css/bootstrap.min.css" rel="stylesheet"/>
  <link href="../css/font-awesome.min.css" rel="stylesheet">
  <link href="../css/shop/userCenter.css" rel="stylesheet">
  <script src="../js/jquery.min.js"></script>
  <script src="../js/bootstrap.min.js"></script>
</head>
<body>
<div id="head">
  <a href="myAccount"><img src="${user.headImgUrl}"></a>
  <span id="nickname">${user.nickname}</span>
  <!--<span class="pull-right" id="talk"><i class="icon  icon-group"></i></span>-->
  <a class="pull-right btn btn-success btn-sm" id="plus" href="adviseAccount">修改</a>
</div>

<ul class="list-group">
  <li class="list-group-item">
    <a href="myAccount">我的资料<span class="pull-right glyphicon glyphicon-chevron-right"> </span></a>
  </li>
  <li class="list-group-item"><a href="shopCart">购物车<span class="pull-right glyphicon glyphicon-chevron-right"> </span> </a></li>
  <li class="list-group-item"><a href="receiveAddress">收货地址<span class="pull-right glyphicon glyphicon-chevron-right"> </span></a></li>
  <li class="list-group-item"><a href="myAssess">我的评价<span class="pull-right glyphicon glyphicon-chevron-right"> </span></a></li>
  <li class="list-group-item"><a href="myCollect">我的收藏<span class="pull-right glyphicon glyphicon-chevron-right"> </span></a></li>
</ul>

<ul class="list-group">
  <li class="list-group-item">
    <span class="badge">1</span><a href="orderMutity.html">待发货</a>
  </li>
  <li class="list-group-item">
    <span class="badge">1</span><a href="orderMutity.html">待收货</a>
  </li>
  <li class="list-group-item">
    <span class="badge">2</span><a href="orderMutity.html">待付款</a>
  </li>
  <li class="list-group-item">
    <span class="badge">5</span><a href="orderMutity.html">待评价</a>
  </li>
  <li class="list-group-item">
    <span class="badge">20</span><a href="allOrder">全部订单</a>
  </li>
</ul>
</body>

<div id="footer">
  <a class="btn btn-danger btn-block" id="plusBtn" href="adviseAccount">完善资料</a>
</div>
</html>
