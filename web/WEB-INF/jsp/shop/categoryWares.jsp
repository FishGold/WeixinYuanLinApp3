<%--
  Created by IntelliJ IDEA.
  User: zss
  Date: 2016/6/5
  Time: 0:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
  <meta name="viewport" content="width=device-width, initial-scale=1,user-scalable=no">
  <title>${category.name}</title>
  <link href="../css/bootstrap.min.css" rel="stylesheet"/>
  <link href="../css/shop/MutityFunction.css" rel="stylesheet">
  <script src="../js/jquery.min.js"></script>
  <script src="../js/bootstrap.min.js"></script>
  <script src="../js/shop/MutityFunction.js"></script>
  <style>
    #main_container a{
      color: #000000;
    }
  </style>
</head>
<body>
<div>
  <form class="top_box" action="">
    <div class="input-group">
      <span class="input-group-addon"><span class="glyphicon glyphicon-search"></span></span>
      <input type="text" class="form-control" id="top_input" placeholder="请输入关键字">
      <span class="input-group-addon" id="top_space_span"></span>
      <span class="input-group-addon" id="top_btn">搜索</span>
    </div>
  </form>
</div>
<div class="radio_container">
  <div class="radio_box text-center" data-toggle="hide"
       data-target="#sortMenu" id="one_sort">排序<span class="caret"> </span></div>
  <div class="radio_box text-center" id="saleFirst">销量优先</div>
  <div class="radio_box text-center" data-toggle="hide"
       data-target="#area" id="two_area" >地区<span class="caret"> </span></div>
  <div class="radio_box text-center" id="more_filter" data-status="hide">更多筛选</div>
</div>
<div id="cover"></div>
<div class="drop_down high_z_index" id="sortMenu">
  <ul>
    <li>
      <span>价格最低</span><input type="radio" name="sortWay" class="pull-right" value="2">
    </li>
    <li>
      <span>价格最高</span><input type="radio" name="sortWay" class="pull-right" value="3">
    </li>
    <li>
      <span>评价最多</span><input type="radio" name="sortWay" class="pull-right" value="4">
    </li>
  </ul>
  <div class="drop_footer text-center">
    <button class="btn btn-default" data-target="#one_sort">取消</button>
    <button class="btn btn-success" data-target="#one_sort" id="sort_ok">确定</button>
  </div>
</div>
<div class="drop_down high_z_index" id="area">
  <ul>
    <li>
      <span>襄州区</span><input type="checkbox" name="areas" class="pull-right" value="0" >
    </li>
    <li>
      <span>襄城区</span><input type="checkbox" name="areas" class="pull-right" value="1">
    </li>
    <li>
      <span>樊城区</span><input type="checkbox" name="areas" class="pull-right" value="2">
    </li>

  </ul>
  <div class="drop_footer text-center">
    <button class="btn btn-default" data-target="#two_area">取消</button>
    <button class="btn btn-success" data-target="#two_area" id="area_btn_ok">确定</button>
  </div>
</div>
<div id="main_container">
  <ul id="main_ul">
    <c:forEach items="${list}" var="ware">
      <a href="wareDetail?wareId=${ware.wareId}">
        <li data='{"height":[${ware.wareHeights.minGd},${ware.wareHeights.maxGd},${ware.wareHeights.minXj},${ware.wareHeights.maxXj},${ware.wareHeights.minDj},${ware.wareHeights.maxDj},${ware.wareHeights.minGf},${ware.wareHeights.maxGf}]}'>
          <img src='${ware["imgUrl"][0]["imgUrl"]}' class="img-rounded">
            <span class="description">
                <p class="title">${ware.shortDescription}</p>
                <p class="price">&yen;<span class="price_1">${ware.price}</span></p>
                <p >${ware.area}<span class="areaId hidden">${ware.areaId}</span></p>
                <p>
                  已售<span class="text-success">${ware.salesNum}</span>件
                  <span class="text-primary">${ware.assessNum}</span>人评价
                </p>
            </span>
        </li>
      </a>

    </c:forEach>
  </ul>
</div>
<div id="more_filter_container">
  <div class="filter_header text-center">
    <button class="btn btn-sm pull-left" id="filter_cancle">取消</button>
    <span class="text-center">筛选</span>
    <button class="btn btn-sm btn-success pull-right" id="filter_ok">确定</button>
  </div>
  <div class="price_box">
    <span class="item_header">价格区间（元）</span>
        <span class="pull-right">
            <input type="text"  class="minPrice"
                   placeholder="最低价" size="8">
            <span>-</span>
            <input type="text"  class="maxPrice"
                   placeholder="最高价" size="8">
        </span>
  </div>

  <div class="attr_box">
    <div class="dropdown" >
            <span type="button" class="dropdown-toggle .item_header" id="dropdownMenu1"
                  data-toggle="dropdown">
                高度 <span class="value text-center text-primary" data='{"min":1,"max":50}'>1--50cm</span>
                <!--<span class="caret"></span>-->

                  <span class="caret pull-right"> </span>
            </span>
      <ul class="dropdown-menu" role="menu" aria-labelledby="dropdownMenu1">
        <li role="presentation"data='{"min":1,"max":50}'>
          <a role="menuitem" tabindex="-1" href="#">50厘米以下</a>
        </li>
        <li role="presentation" class="divider"></li>
        <li role="presentation" data='{"min":50,"max":100}'>
          <a role="menuitem" tabindex="-1" href="#">50厘米至1米</a>
        </li>
        <li role="presentation" class="divider"></li>
        <li role="presentation" data='{"min":100,"max":200}'>
          <a role="menuitem" tabindex="-1" href="#">
            1米至2米
          </a>
        </li>

        <li role="presentation" class="divider"></li>
        <li role="presentation"data='{"min":200,"max":300}'>
          <a role="menuitem" tabindex="-1" href="#">2米至3米</a>
        </li>
        <li role="presentation" class="divider"></li>
        <li role="presentation" data='{"min":300,"max":400}'>
          <a role="menuitem" tabindex="-1" href="#">3米至4米</a>
        </li>
        <li role="presentation" class="divider"></li>
        <li role="presentation"data='{"min":400,"max":10000}'>
          <a role="menuitem" tabindex="-1" href="#">4米以上</a>
        </li>
      </ul>

    </div>
  </div>
  <div class="attr_box">
    <div class="dropdown" >
            <span type="button" class="dropdown-toggle item_header" id="dropdownMenu2"
                  data-toggle="dropdown">
                胸径 <span class="value text-center text-primary" data='{"min":1,"max":5}'>1--5cm</span>
                <!--<span class="caret"></span>-->

                  <span class="caret pull-right"> </span>
            </span>
      <ul class="dropdown-menu" role="menu" aria-labelledby="dropdownMenu2">
        <li role="presentation" data='{"min":1,"max":5}'>
          <a role="menuitem" tabindex="-1" href="#">5厘米以下</a>
        </li>
        <li role="presentation" class="divider"></li>
        <li role="presentation"data='{"min":5,"max":10}'>
          <a role="menuitem" tabindex="-1" href="#">5-10厘米</a>
        </li>
        <li role="presentation" class="divider"></li>
        <li role="presentation" data='{"min":10,"max":15}'>
          <a role="menuitem" tabindex="-1" href="#">
            10至15厘米
          </a>
        </li>

        <li role="presentation" class="divider"></li>
        <li role="presentation" data='{"min":15,"max":20}'>
          <a role="menuitem" tabindex="-1" href="#">15至20厘米</a>
        </li>
        <li role="presentation" class="divider"></li>
        <li role="presentation"  data='{"min":20,"max":30}'>
          <a role="menuitem" tabindex="-1" href="#">20至30厘米</a>
        </li>
        <li role="presentation" class="divider"></li>
        <li role="presentation"  data='{"min":30,"max":50}'>
          <a role="menuitem" tabindex="-1" href="#">30至50厘米</a>
        </li>
        <li role="presentation" class="divider"></li>
        <li role="presentation" data='{"min":50,"max":10000}'>
          <a role="menuitem" tabindex="-1" href="#">50厘米以上</a>
        </li>
      </ul>

    </div>
  </div>
  <div class="attr_box">
    <div class="dropdown" >
            <span type="button" class="dropdown-toggle item_header" id="dropdownMenu3"
                  data-toggle="dropdown">
                地径 <span class="value text-center text-primary" data='{"min":1,"max":5}'>1--5cm</span>
                <!--<span class="caret"></span>-->

                  <span class="caret pull-right"> </span>
            </span>
      <ul class="dropdown-menu" role="menu" aria-labelledby="dropdownMenu3">
        <li role="presentation"  data='{"min":1,"max":5}'>
          <a role="menuitem" tabindex="-1" href="#">5厘米以下</a>
        </li>
        <li role="presentation" class="divider"></li>
        <li role="presentation" data='{"min":5,"max":10}'>
          <a role="menuitem" tabindex="-1" href="#">5-10厘米</a>
        </li>
        <li role="presentation" class="divider"></li>
        <li role="presentation" data='{"min":10,"max":15}'>
          <a role="menuitem" tabindex="-1" href="#">
            10至15厘米
          </a>
        </li>

        <li role="presentation" class="divider"></li>
        <li role="presentation" data='{"min":15,"max":20}'>
          <a role="menuitem" tabindex="-1" href="#">15至20厘米</a>
        </li>
        <li role="presentation" class="divider"></li>
        <li role="presentation"data='{"min":20,"max":30}'>
          <a role="menuitem" tabindex="-1" href="#">20至30厘米</a>
        </li>
        <li role="presentation" class="divider"></li>
        <li role="presentation" data='{"min":30,"max":50}'>
          <a role="menuitem" tabindex="-1" href="#">30至50厘米</a>
        </li>
        <li role="presentation" class="divider"></li>
        <li role="presentation" data='{"min":50,"max":10000}'>
          <a role="menuitem" tabindex="-1" href="#">50厘米以上</a>
        </li>
      </ul>

    </div>
  </div>
  <div class="attr_box">
    <div class="dropdown" >
            <span type="button" class="dropdown-toggle item_header" id="dropdownMenu4"
                  data-toggle="dropdown">
                冠幅 <span class="value text-center text-primary" data='{"min":1,"max":50}'>1--50cm</span>
                <!--<span class="caret"></span>-->

                  <span class="caret pull-right"> </span>
            </span>
      <ul class="dropdown-menu" role="menu" aria-labelledby="dropdownMenu4">
        <li role="presentation" id="test" data='{"min":1,"max":50}'>
          <a role="menuitem" tabindex="-1" href="#" >50厘米以下</a>
        </li>
        <li role="presentation" class="divider"></li>
        <li role="presentation" data='{"min":50,"max":100}'>
          <a role="menuitem" tabindex="-1" href="#" >50厘米至1米</a>
        </li>
        <li role="presentation" class="divider"></li>
        <li role="presentation" data='{"min":100,"max":200}'>
          <a role="menuitem" tabindex="-1" href="#" >1米至2米</a>
        </li>
        <li role="presentation" class="divider"></li>
        <li role="presentation"data='{"min":200,"max":10000}'>
          <a role="menuitem" tabindex="-1" href="#" >2米以上</a>
        </li>
      </ul>

    </div>
  </div>
</div>

<div id="filter_cover"></div>
<a id="home"  onclick="history.back()">
  <span class="glyphicon glyphicon-share-alt"> </span>
</a>
</body>
<script src="../js/shop/shopSort.js"></script>
<script>
  var onePageNum=2;
  $(window).on("scroll",scrollDown);
  function scrollDown(){
    var scrollTop = $(this).scrollTop();
    var scrollHeight = $(document).height();
    var windowHeight = $(this).height();
    var page = $("#main_ul li").length/onePageNum;
    page = Math.round(page);
    if (scrollTop + windowHeight == scrollHeight) {
      $.ajax({
        url:"categoryMore_json?categoryId=${category.categoryId}&page="+page,
        beforeSend:function(){
          //alert("页数"+page);
          $(window).off("scroll");
        },
        success:function(jsonWare){
          var wares= $.parseJSON(jsonWare);
         // alert("返回数据长度",jsonWare.length);
          for(var i =0;i<wares.length;i++){
            var str = '<a href="wareDetail?wareId='+wares[i].wareId+'"><li data='+'{"height":['+wares[i].minGd+','+wares[i].maxGd+','+wares[i].minXj+','+wares[i].maxXj+','+wares[i].minDj+','+wares[i].maxDj+','+wares[i].minGf+','+wares[i].maxGf+']}'
                    +'><img src='+wares[i]["imgUrl"]+'  class="img-rounded">'+'<span class="description">'+
            '<p class="title">'+wares[i]["shortDescription"]+'</p>'+
            '<p class="price">&yen;<span class="price_1">'+wares[i]["price"]+'</span></p>'+
            '<p >'+wares[i]["area"]+'<span class="areaId hidden">'+wares[i]["areaId"]+'</span></p>'+
            '已售<span class="text-success">'+wares[i]["saleNum"]+'</span>件'+
           '<span class="text-primary">'+wares[i]["assessNum"]+'</span>人评价</p> </span> </li><a>';
            $("#main_ul").append(str);
          }
        },
        error:function(data){

        },
        complete:function(data){
          $(window).on("scroll",scrollDown);
        }
      });
    }
  }
</script>
</html>

