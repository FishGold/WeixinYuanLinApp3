<%--
  Created by IntelliJ IDEA.
  User: zss
  Date: 2016/6/7
  Time: 20:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
  <meta name="viewport" content="width=device-width, initial-scale=1,user-scalable=no">
  <title>商品搜索</title>
  <link href="../css/bootstrap.min.css" rel="stylesheet"/>
  <link href="../css/shop/shopAdvice.css" rel="stylesheet">
  <script src="../js/jquery.min.js"></script>
  <script src="../js/bootstrap.min.js"></script>
  <style>
    a:hover{
      color: #666666;
      text-decoration: none;
    }
    a:visited{
      color: #666666;
    }
    a{
      color: #666666;
    }
  </style>

</head>
<body>
<div>
  <form class="top_box" action="search">
    <div class="input-group">
      <span class="input-group-addon"><span class="glyphicon glyphicon-search"></span></span>
      <input type="text" class="form-control" id="top_input" placeholder="乔木" name="keyWord" required="true">
      <span class="input-group-addon" id="top_space_span"></span>
      <span class="input-group-addon" id="top_btn">搜索</span>
    </div>
  </form>
  <script>
    $("#top_btn").click(function() {
      var key = $("#top_input").val();
      if(key){
        $(".top_box").first().submit();
      }
    });
  </script>
  <c:if test="${!empty set1}">
    <div class="advice_box">
      <p>
        <span>最近搜索</span>
        <span class="pull-right" id="clear_btn">清除</span>
      </p>
      <ul id="recent_box">
        <c:forEach items="${set1}" var="one">
          <a href="search?keyWord=${one}">
            <li>${one}</li>
          </a>

        </c:forEach>
      </ul>
    </div>
    </c:if>

  <div class="advice_box" id="hot_search_container">
    <p>
      <span>热门搜索</span>
      <span class="pull-right" id="another_btn">换一批</span>
    </p>
    <ul>
        <c:forEach items="${set2}" var="one">
          <a href="search?keyWord=${one}">
            <li>${one}</li>
          </a>
        </c:forEach>
    </ul>
  </div>
</div>
</body>
<script>
  $("#another_btn").on("click",getChange);
  var onePageNum = 6;//一页商品的数量
  function getChange(){
    $.ajax({
      url:"hot_change_ano_json?page=2",
      beforeSend:function(){
        //alert("页数"+page);
        $("#another_btn").off("click",getChange);
      },
      success:function(data){
        var dataJson = $.parseJSON(data);
        $("#hot_search_container ul").empty();
        for(var i=0;i<dataJson.length;i++){
          $("#hot_search_container ul").append("<li>"+dataJson[i]+"</li>");
        }
      },
      error:function(data){

      },
      complete:function(data){
        $("#another_btn").on("click",getChange);
      }
    });
  }
  $("#clear_btn").on("click",function(){
    $("#recent_box").empty();
  });
</script>
</html>
