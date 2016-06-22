<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head lang="en">
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, user-scalable=no">
    <title>认养市场</title>
    <link href="../css/bootstrap.min.css" rel="stylesheet">
    <script src="../js/jquery.min.js"></script>
    <script src="../js/bootstrap.min.js"></script>
    <link href="../css/adopt-market.css" rel="stylesheet">
</head>
<body>
<header>
    <div id="carousel" class="carousel slide">
        <ol class="carousel-indicators">
            <li data-target="#carousel" data-slide-to="0" class="active"></li>
            <li data-target="#carousel" data-slide-to="1"></li>
            <li data-target="#carousel" data-slide-to="2"></li>
            <li data-target="#carousel" data-slide-to="3"></li>
        </ol>

        <div class="carousel-inner">
            <div class="item active">
                <img src="../images/plants/6.jpg" alt="First slide">
            </div>
            <div class="item">
                <img src="../images/plants/7.jpg" alt="Second slide">
            </div>
            <div class="item">
                <img src="../images/plants/8.jpg" alt="Third slide">
            </div>
            <div class="item">
                <img src="../images/plants/9.jpg" alt="Third slide">
            </div>
        </div>

        <a class="carousel-control left" href="#carousel"
           data-slide="prev">&lsaquo;</a>
        <a class="carousel-control right" href="#carousel"
           data-slide="next">&rsaquo;</a>
    </div>
</header>

<table id="mother" style="overflow-y:auto; overflow-x:hidden;">

    <c:forEach items="${adopts}" var="adopt" varStatus="status" >
        ${adopt.date}
   <%-- <tr>
        <th>
            <img class="plant" src="../images/plants/1.jpg">
            <img class="user-head" src="../images/util/1.jpg">
            <p class="user-info">
                <label>王五</label><br>
                <span class="glyphicon glyphicon-time time">2016-05-27 15:37</span>
            </p>
        </th>
        <th>
            <img class="plant" src="../images/plants/2.jpg">
            <img class="user-head" src="../images/util/2.jpg">
            <p class="user-info">
                <label>王五</label><br>
                <span class="glyphicon glyphicon-time time">2016-05-27 15:37</span>
            </p>
        </th>
    </tr>--%>
    </c:forEach>
</table>

<script type="text/javascript">
    $('.carousel').carousel();
    $(".plant").width(screen.width*0.98/2-8);
    $(".plant").height(screen.width*0.98/2-8);
    $(".item").height(screen.width*0.98/2-10);

</script>
</body>
</html>