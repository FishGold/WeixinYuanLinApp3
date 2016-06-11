<%--
  Created by IntelliJ IDEA.
  User: zss
  Date: 2016/6/2
  Time: 16:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
  <meta name="viewport" content="width=device-width, initial-scale=1,user-scalable=no">
  <title>${ware.name}</title>
  <link href="../css/bootstrap.min.css" rel="stylesheet"/>
  <link href="../css/shop/showWare.css" rel="stylesheet">
  <script src="../js/jquery.min.js"></script>
  <script src="../js/bootstrap.min.js"></script>
  <style>

  </style>
</head>
<body class="body">
  <div id="myCarousel" class="carousel slide">
    <!-- 轮播（Carousel）指标 -->
    <ol class="carousel-indicators">
      <c:forEach items="${ware.imgUrl}" varStatus="i">
        <li data-target="#myCarousel" data-slide-to="${i.index}" ></li>
      </c:forEach>
    </ol>
    <!-- 轮播（Carousel）项目 -->
    <div class="carousel-inner">
      <c:forEach items="${ware.imgUrl}" var="one" varStatus="i">
        <div class="item <c:if test="${i.index==0}">active</c:if>">
        <img src="${one.imgUrl}" height="462px" class="img">
    </div>
    </c:forEach>
  </div>
  <!-- 轮播（Carousel）导航 -->
  <a class="carousel-control left" href="#myCarousel"
     data-slide="prev"> </a>
  <a class="carousel-control right" href="#myCarousel"
     data-slide="next"> </a>
  </div>
  <div class="bgStyle">
    <div class="detail comm">
        <span>${ware.description}</span>
    </div>
    <div class="price comm">
      <p class="price_1">￥
        <span style="font-size: 15px">${ware.price}</span>
        <span class="summary">${ware.shortDescription}</span>
      </p>
      <p class="font">价格<span style="text-decoration: line-through;">￥${ware.oldPrice}</span></p>
    </div>
    <div class="font comm">
      <ol>
        <li class="pull-left">快递: 免运费</li>
        <li class="li1">销售${ware.salesNum}棵</li>
        <li class="pull-right">${ware.area}</li>
      </ol>
    </div>
  </div>
  <div class="type">
    <div class="comm">
      <p data-toggle="modal" data-target="#myModal" data-backdrop="true">请选择植株高度<span class="glyphicon glyphicon-chevron-right pull-right"></span></p>
    </div>
  </div>

  <div class="modal fade" id="myModal">
    <div class="modal-dialog">
      <div class="modal-content">
        <div class="modal-body">
          <div style="width: 100%">
            <div style="padding: 0px 10px">
              <div class="media">
                <div class="media-left">
                  <img src=${ware["imgUrl"][0]["imgUrl"]} class="img-rounded" width="100px" height="100px">
                </div>
                <div class="media-body">
                  <div class="price comm">
                    <p class="price_1">￥<span style="font-size: 15px">${ware.price}</span></p>
                    <p><span>请确定 植株高度</span></p>
                  </div>
                </div>
                <form role="form" style="margin-left: 10px">
                  <div class="form-group grups">
                    <label>高度</label>
                    <label class="height_value">${ware.wareHeights.minGd} - - ${ware.wareHeights.maxGd}cm</label>
                    <span class="pull-right"> <input type="text" size="1" placeholder="低">--<input type="text" size="1" placeholder="高"></span>
                  </div>
                  <div class="form-group">
                    <label>胸径</label>
                    <label class="height_value">${ware.wareHeights.minXj} - - ${ware.wareHeights.maxXj}cm</label>
                    <span class="pull-right"> <input type="text" size="1" placeholder="低">--<input type="text" size="1" placeholder="高"></span>
                  </div>
                  <div class="form-group">
                    <label>地径</label>
                    <label class="height_value">${ware.wareHeights.minDj} - - ${ware.wareHeights.maxDj}cm</label>
                    <span class="pull-right"> <input type="text" size="1" placeholder="低">--<input type="text" size="1" placeholder="高"></span>
                  </div>
                  <div class="form-group">
                    <label>冠幅</label>
                    <label class="height_value">${ware.wareHeights.minGf} - - ${ware.wareHeights.maxGf}cm</label>
                    <span class="pull-right"> <input type="text" size="1" placeholder="低">--<input type="text" size="1" placeholder="高"></span>
                  </div>
                </form>
              </div>
            </div>
          </div>
        </div>
        <div class="modal-footer">
          <button class="btn btn-success" style="width: 100%" data-dismiss="modal">确认</button>
        </div>
      </div>
    </div>
  </div>
</body>
</html>
