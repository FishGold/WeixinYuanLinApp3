<%--
  Created by IntelliJ IDEA.
  User: ZSS
  Date: 2016/4/27
  Time: 14:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1,user-scalable=no">
    <title>趣商城</title>
</head>
<body>
<h2>获取用户信息</h2>
<img src="${user.headImgUrl}" style="width: 150px;height: 150px"/>
  <h3>openid:${user.openId}</h3>
  <h3>nickname:${user.nickname}</h3>
  <h3>sex:${user.sex}</h3>
  <h3>country:${user.country}</h3>
  <h3>province:${user.province}</h3>
</body>
</html>
