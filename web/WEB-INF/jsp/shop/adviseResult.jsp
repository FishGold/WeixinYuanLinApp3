<%--
  Created by IntelliJ IDEA.
  User: zss
  Date: 2016/6/10
  Time: 22:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
   <meta name="viewport" content="width=device-width, initial-scale=1,user-scalable=no">
   <link href="../css/bootstrap.min.css" rel="stylesheet"/>
    <title>修改资料</title>
  <style>
    body{
      background-color: lightgrey;
    }
    .text-center{
      margin-top: 10%;
    }
    #text,#bad{
      margin-left: 20px;
      font-family: "Microsoft YaHei", "黑体", "宋体", sans-serif;
      font-size: 14px;
      font-weight: bold;
      color: green;
    }
    #bad{
      color: #808080;
    }
  </style>
</head>
<body>
<div class="text-center">

  <c:choose>
    <c:when test="${result == true}">
      <img src="/images/shop/check_64px_1165460_easyicon.net.png">
      <span id="text">恭喜您，修改资料成功！</span>
    </c:when>
    <c:when test="${result == false}">
      <img src="/images/shop/Error_64px_1093666_easyicon.net.png">
      <span id="bad">对不起，修改失败！</span>
    </c:when>
  </c:choose>


</div>
</body>
</html>
