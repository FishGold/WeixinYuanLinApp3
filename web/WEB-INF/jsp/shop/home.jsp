<%--
  Created by IntelliJ IDEA.
  User: zss
  Date: 2016/5/28
  Time: 8:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1,user-scalable=no">
  <title>趣商城</title>

  <link href="../css/bootstrap.min.css" rel="stylesheet"/>
  <link href="../css/shop/shopCss.css" rel="stylesheet">
  <script src="../js/jquery.min.js"></script>
  <script src="../js/bootstrap.min.js"></script>
  <script src="../js/shop/shop.js"></script>
  <%--<base href="/">--%>
</head>
<body>
<form class="top_box">
  <div class="input-group">
    <span class="input-group-addon"><span class="glyphicon glyphicon-search"></span></span>
    <input type="text" class="form-control" id="top_input" placeholder="请输入关键字" required="">
    <span class="input-group-addon" id="top_space_span"></span>
    <span class="input-group-addon" id="top_btn">搜索</span>
  </div>
</form>
<div id="myCarousel" class="carousel slide">
  <!-- 轮播（Carousel）指标 -->
  <ol class="carousel-indicators">
    <c:forEach items="${carousels}" varStatus="i">
        <li data-target="#myCarousel" data-slide-to="${i.index}" ></li>
    </c:forEach>
  </ol>
  <!-- 轮播（Carousel）项目 -->
  <div class="carousel-inner">
    <c:forEach items="${carousels}" var="one" varStatus="i">
      <div class="item <c:if test="${i.index==0}">active</c:if>">
        <img src="${one.imgUrl}" height="462px">
      </div>
    </c:forEach>
  </div>
  <!-- 轮播（Carousel）导航 -->
  <a class="carousel-control left" href="#myCarousel"
     data-slide="prev"> </a>
  <a class="carousel-control right" href="#myCarousel"
     data-slide="next"> </a>
</div>
<div class="function_list text-center">
  <ul>
    <li>
      <a href="sorts">
        <span class="glyphicon glyphicon-tasks bg_one"> </span>
        <p>商品分类</p>
      </a>
    </li>
    <li>
      <a href="recommend?page=0">
        <span class="glyphicon glyphicon-heart-empty bg_two"> </span>
        <p>推荐商品</p>
      </a>
    </li>
    <li>
      <a href="hot?page=0">
        <span class="glyphicon glyphicon-fire bg_three"> </span>
        <p>热卖商品</p>
      </a>
    </li>
    <li>
      <a href="/yuanlin/shopUserCenter/home">
        <span class="glyphicon glyphicon-user bg_four"> </span>
        <p>个人中心</p>
      </a>
    </li>
  </ul>
</div>
<div id="fix_menu" class="text-center">
  <div class="menu_first">
    <a href="/yuanlin/shopUserCenter/shopCart">
      <span class="glyphicon glyphicon-shopping-cart"> </span>
      <p>购物车</p>
    </a>

  </div>
</div>
<div>
  <c:forEach items="${wareMap}" var="wares">
    <c:forEach items="${wares}" var="waress">
      <div class="sort_item">
        <div class="sort_item_head">
          <span class="name"><span class="glyphicon glyphicon-tree-conifer"> </span>${waress.key.name}</span>
          <a class="pull-right more" href="categoryMore?categoryId=${waress.key.categoryId}&page=0" >更多<span class="glyphicon glyphicon-chevron-right"></span></a>
        </div>
        <div class="sort_item_body">
          <c:forEach items="${waress.value}" var="ware">
            <a class="one_img" href="classifyMore?classifyId=${ware.wareClassify.classifyId}&page=0">
              <img src="${ware["imgUrl"][0]["imgUrl"]}" >
              <p class="text-center">${ware["name"]}</p>
            </a>
          </c:forEach>
        </div>
      </div>

    </c:forEach>

  </c:forEach>
</div>

<div class="guss text-center">
  <p><span class="glyphicon glyphicon-heart"> </span>猜你喜欢</p>
</div>
<div id="content">
  <c:forEach items="${likes}" var="ware">
    <div class="main col-xs-6 col-sm-4 col-md-3 col-lg-2">
      <div class="main_item">
        <a href="wareDetail?wareId=${ware.wareId}">
          <img src="${ware["imgUrl"][0]["imgUrl"]}" class="tree">
          <div class="item_slide">
            <p class="text">${ware.shortDescription}</p>
          </div>
          <div class="money">
            <span class="price">&yen;${ware.oldPrice}</span>
            <s>&yen;${ware.price}</s><br>
            <span class="count">月销${ware.salesNum}棵</span>
          </div>
        </a>
      </div>
    </div>
  </c:forEach>

  </div>

</div>
</body>

</html>
