<%--
  Created by IntelliJ IDEA.
  User: zss
  Date: 2016/6/10
  Time: 19:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1,user-scalable=no">
  <title>完善资料</title>
  <link href="../css/bootstrap.min.css" rel="stylesheet"/>
  <script src="../js/jquery.min.js"></script>
  <script src="../js/bootstrap.min.js"></script>
  <style>
    body{
      font-size: 12px;
      font-family: "Arial", "Microsoft YaHei", "黑体", "宋体", sans-serif;
    }
    form{
      margin-top: 20px;
    }
  </style>
</head>
<body>
<div class="container">
  <form  role="form" action="adviseAccount_form" method="post" enctype="application/x-www-form-urlencoded">
    <%--<div class="form-group">--%>
      <%--<label for="firstname" class="control-label">昵称</label>--%>
      <%--<input type="text" class="form-control" id="firstname"--%>
            <%--placeholder="${user.nickname}" disabled >--%>

    <%--</div>--%>
    <div class="form-group">
      <label class="control-label">真实姓名</label>
      <input type="text" class="form-control" name="realName" value="${user.realName}" required="true">
    </div>
    <%--<div class="form-group">--%>
      <%--<label for="lastname" class="control-label">籍贯</label>--%>

      <%--<input type="text" class="form-control" id="lastname"--%>
            <%--placeholder="${user.nation}"  required="true" disabled>--%>
    <%--</div>--%>
    <div class="form-group">
      <label class="control-label">详细地址</label>
      <input type="text" class="form-control" name="addressDetal" value="${user.address}" required="true" >
    </div>
    <%--<div class="form-group">--%>
      <%--<label class=" control-label">性别</label>--%>

      <%--<input type="text" class="form-control" id="sex"--%>
             <%--placeholder="${user.sex}" disabled >--%>
    <%--</div>--%>
    <div class="form-group">
      <label  class=" control-label">联系方式</label>
      <input type="text" class="form-control" name="phoneNum" pattern="[0-9]{6,18}"  oninvalid="setCustomValidity('6-18位数字');" oninput="setCustomValidity('');" value="${user.phoneNum}">
    </div>
    <div class="form-group">
      <label  class=" control-label">邮箱</label>
      <input type="email" class="form-control" name="email" required="" value="${user.email}">
    </div>
    <button type="submit" class="btn btn-danger btn-block" href="userCenter.html">提交</button>
  </form>

</div>
</body>
</html>
