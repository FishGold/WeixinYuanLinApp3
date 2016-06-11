<%--
  Created by IntelliJ IDEA.
  User: zss
  Date: 2016/6/5
  Time: 19:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1,user-scalable=no">
  <title>花木分类</title>
  <link href="../css/bootstrap.min.css" rel="stylesheet"/>
  <link href="../css/shop/shopAdvice.css" rel="stylesheet">
  <script src="../js/jquery.min.js"></script>
  <script src="../js/bootstrap.min.js"></script>
  <style>
    a:visited{
      text-decoration: none;
    }
    a:hover{
      text-decoration: none;
    }
    a{
      color: #666666;
    }
  </style>
</head>
<body>
<div>
  <form class="top_box">
    <div class="input-group">
      <span class="input-group-addon"><span class="glyphicon glyphicon-search"></span></span>
      <input type="text" class="form-control" id="top_input" placeholder="红叶黄垆">
      <span class="input-group-addon" id="top_space_span"></span>
      <span class="input-group-addon" id="top_btn">搜索</span>
    </div>
  </form>
</div>
<c:forEach items="${list}" var="category" varStatus="i" >
  <div class="advice_box">
    <p>
      <span>${category.name}</span>
      <a class="pull-right open_on" data-target="item0" <c:if test="${i.index==0}">id="first_item"</c:if> >展开<span class="glyphicon glyphicon-chevron-down"></span></a>
    </p>
    <ul id="item<c:if test="${i.index==0}">${i.index}</c:if>" data-status="show">
      <c:forEach items="${category.list}" var="classify">
        <a href="classifyMore?classifyId=${classify.classifyId}&page=0">
          <li>${classify.name}</li>
        </a>

      </c:forEach>
    </ul>
  </div>
</c:forEach>
<a id="home"  onclick="history.back()">
  <span class="glyphicon glyphicon-share-alt"> </span>
</a>
</body>
<script>
  $("#top_input").focus(function(){
    window.location.href="goToSearch";
  });
  /*一行容纳的项目个数*/
  var number =  (document.body.clientWidth -30)/47;
  $(".advice_box ul").each(function(){
    $(this).children("li").each(function(i){
      if(i>number-1)
        $(this).hide();
    });

  });
  $(".open_on").click(function(){
    var ul =$(this).attr("data-target");
    $UL = $("#"+ul);
    var status = $UL.attr("data-status");
    if(status =="show"){
      $UL.children("li").each(function(i){
        if(i>number-1){
          $(this).show();
        }

      });
      $UL.attr("data-status","hide");
      $(this).html('收起<span class="glyphicon glyphicon-chevron-up"> </span>');
    }else if(status =="hide"){
      $UL.children("li").each(function(i){
        if(i>number-1)
          $(this).hide();
      });
      $UL.attr("data-status","show");
      $(this).html('展开<span class="glyphicon glyphicon-chevron-down"> </span>');
    }
  });
  $("#first_item").click();
</script>
</html>
