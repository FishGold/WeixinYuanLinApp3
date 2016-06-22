<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head lang="en">
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, user-scalable=no">
    <title>捐赠市场</title>
    <link href="../css/bootstrap.min.css" rel="stylesheet">
    <script src="../js/jquery.min.js"></script>
    <script src="../js/bootstrap.min.js"></script>
    <link href="../css/donate-market.css" rel="stylesheet">
    <script>
        var currentPage = 1;
        function init(){
            $("#mother").height(screen.height);
        }
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
                                                url: "http://localhost:8080/donate/query?currentPage="+currentPage,
                                                contentType: "application/json; charset=utf-8",
                                                dataType: "json",
                                                async: true,
                                                cache: false,
                                                success: function (msg) {
                                                    mother.removeChild(p);
                                                    var hr = document.createElement("hr");
                                                    for(var i=0;i<msg.length;i++){
                                                        var table = document.createElement("table");
                                                        table.innerHTML = "<tr> " +
                                                        "<th> " +
                                                        "<img src='"+msg[i]["imgUrl"]+"'+ class='user-head' ><label class='userinfo'>"+
                                                       "<span class='username'>"+msg[i]["userName"]+"</span><br>"+
                                                       "<span class='time'>"+msg[i]["donateDate"]+"</span>"+
                                                        "<span class='glyphicon glyphicon-phone phone'>"+msg[i]["phone"]+"</span>"+
                                                       "</label>"+
                                                        "</th>"+
                                                        "</tr>"+
                                                        "<tr>"+
                                                        "<th>"+
                                                        "<p>["+msg[i]["plantName"]+"]"+ msg[i]["plantDesc"]+"</p>"+
                                                        "</th>"+
                                                        "</tr>"+
                                                        "<tr>"+
                                                        "<th>"+
                                                        "<p class='reason'>&nbsp;&nbsp;"+msg[i]["reason"]+"</p>"+
                                                        "</th>"+
                                                        "</tr>"+
                                                        "<tr>"+

                                                        "<th>"+

                                                        "<img src='../images/userDonate/1/"+msg[i]['image_1']+"' class='pic-1'>"+
                                                        "<img src='../images/userDonate/2/"+msg[i]['image_2']+"' class='pic-1'>"+
                                                        "<img src='../images/userDonate/3/"+msg[i]['image_3']+"' class='pic-1'>"+"</th>"+
                                                        "</tr>"+
                                                        "<tr>"+
                                                        "<th><button class='glyphicon glyphicon-eye-open user-adopt'value='"+msg[i]['id']+"'  onclick='sendAdoptRequest(this)'>收养</button></th>"+
                                                        "</tr>";


                                                        mother.appendChild(table);
                                                        mother.appendChild(hr);
                                                    }







                                                    currentPage++;
                                                    $contentLoadTriggered = false;
                                                },
                                                error: function (x, e){
                                                    alert("失败. " +x.responseText);
                                                    $contentLoadTriggered = true;
                                                }
                                            }
                                    );
                                }
                            }
                    );
                }
        );


        function sendAdoptRequest(e){
            var self = e.parentNode.childNodes[0];
            var result = true;;
            var targetId = e.value;
            if(result){
                result = false;
                $.ajax(
                        {
                            type: "POST",
                            url: "http://localhost:8080/adopt/doAdopt?plantId="+targetId,
                            contentType: "application/json; charset=utf-8",
                            async: true,
                            dataType: "json",
                            cache: false,
                            success: function (msg) {

                                var mother = document.getElementById("mother");
                                var remo = e.parentNode.parentNode.parentNode;
                                if(msg=="true"){
                                    remo.style.display="none";
                                    alert("收养成功！");
                                }
                                else{
                                    alert("操作失败，请重试！");
                                }
                                result = true;
                            },
                            error: function (x, e){
                                alert("收养失败，请重试！");
                                result = true;
                            }
                        }
                );
            }
            else{
                alert("请稍等......");
            }
        }
    </script>
</head>
<body onload="init()">
<c:forEach items="${plants}" var="plant">
<div id="mother" style="overflow-y:auto; overflow-x:hidden;">
    <table>
        <tr>
            <th>
                <img src="${plant.imgUrl}" class="user-head" >
                <label class="userinfo">
                    <span class="username">${plant.userName}</span><br>
                    <span class="time">${plant.donateDate}</span>
                    <span class="glyphicon glyphicon-phone phone">${plant.phone}</span>
                </label>
            </th>
        </tr>
        <tr>
            <th>
                <p>[${plant.plantName}] ${plant.plantDesc}</p>
            </th>
        </tr>
        <tr>
            <th>
                <p class="reason">&nbsp;&nbsp;${plant.reason}</p>
            </th>
        </tr>
        <tr>
            <th>
                <img src="../images/userDonate/1/${plant.image_1}" class="pic-1">
                <img src="../images/userDonate/2/${plant.image_2}" class="pic-1">
                <img src="../images/userDonate/3/${plant.image_3}" class="pic-1"></th>
        </tr>
        <tr>
            <th><button class="glyphicon glyphicon-eye-open user-adopt" value="${plant.id}"onclick="sendAdoptRequest(this)">收养</button></th>
        </tr>

    </table>
    </c:forEach>
</div>

</body>
</html>