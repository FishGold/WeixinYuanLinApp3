<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head lang="en">
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, user-scalable=no">
    <title>我的发现</title>
    <link href="../css/bootstrap.min.css" rel="stylesheet">
    <script src="../js/jquery.min.js"></script>
    <script src="../js/bootstrap.min.js"></script>
    <link rel="stylesheet" href="../css/myReport.css">
    <script>

        var currentPage = 1;
        $(document).ready(
                function(){
                    $contentLoadTriggered = false;
                    $("#mother").scroll(function(){
                                if($("#mother")[0].scrollTop >= ($("#mother")[0].scrollHeight -$("#mother").height()) &&$contentLoadTriggered == false){
                                    $contentLoadTriggered = true;
                                    var p = document.createElement("p");
                                    p.style.width = "100%";
                                    p.style.textAlign = "center";
                                    var mother = document.getElementById("mother");
                                    p.innerHTML = "正在加载......";
                                    mother.appendChild(p);
                                    $.ajax(
                                            {
                                                type: "POST",
                                                url: "http://localhost:8080/myReport/get?currentPage="+currentPage,
                                                contentType: "application/json; charset=utf-8",
                                                dataType: "json",
                                                async: true,
                                                cache: false,
                                                success: function (msg) {
                                                    mother.removeChild(p);
                                                    for(var i=0;i<msg.length;i++){
                                                        var table = document.createElement("table");
                                                        var hr = document.createElement("hr");
                                                        table.innerHTML="<caption>日期:msg[i]['reportDate']</caption>" +
                                                        "<tr>" +
                                                        "<th>状态描述</th>" +
                                                        "<td>msg[i]['describeAboutPlant']</td>" +
                                                        "</tr>" +
                                                        "<tr>" +
                                                        "<th>大致位置</th>" +
                                                        "<td>msg[i]['addressAboutReport']</td>" +
                                                        "</tr>" +
                                                        "<tr>" +
                                                        "<th>详细地址</th>" +
                                                        "<td>msg[i]['detailAddressAboutPlant']</td>" +
                                                        "</tr>" +
                                                        "<tr>" +
                                                        "<th>附图</th>" +
                                                        "<td><img src='../images/illPlantPic/"+msg[i]['illPlantImagesAddress']+"' class='addPic'></td>" +
                                                        "</tr>";
                                                        mother.appendChild(table);
                                                        mother.appendChild(hr);
                                                    }

                                                    currentPage++;
                                                    $contentLoadTriggered = false;
                                                },
                                                error: function (x, e){
                                                    alert("加载失败，请重试" );
                                                    $contentLoadTriggered = true;
                                                }
                                            }
                                    );
                                }
                            }
                    );
                }
        );
    </script>
</head>
<body>
<header id="header">
    <img src="../images/plants/searchandfind.jpg" id="head">
</header>
<div id="mother" style="overflow-y: auto;overflow-x: hidden">
    <c:forEach items="${plants}" var="plant">
        <table>
            <caption>日期:${plant.reportDate}</caption>
            <tr>
                <th>状态描述</th>
                <td>${plant.describeAboutPlant}</td>
            </tr>
            <tr>
                <th>大致位置</th>
                <td>${plant.addressAboutReport}</td>
            </tr>
            <tr>
                <th>详细地址</th>
                <td>${plant.detailAddressAboutPlant}</td>
            </tr>
            <tr>
                <th>附图</th>
                <td><img src="../images/illPlantPic/${plant.illPlantImagesAddress}" class="addPic"></td>
            </tr>
        </table>
        <hr>
    </c:forEach>
</div>
<script>
    $("#header").height(screen.height/4);
    $("#mother").height(screen.height*3/4);
</script>
</body>
</html>