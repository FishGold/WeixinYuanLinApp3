<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head lang="en">
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, user-scalable=no">
    <title>我捐赠的</title>
    <link href="../css/bootstrap.min.css" rel="stylesheet">
    <script src="../js/jquery.min.js"></script>
    <script src="../js/bootstrap.min.js"></script>
    <link rel="stylesheet" href="../css/myDonate.css">
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
                                                url: "http://localhost:8080/myDonate/get?currentPage="+currentPage,
                                                contentType: "application/json; charset=utf-8",
                                                dataType: "json",
                                                async: true,
                                                cache: false,
                                                success: function (msg) {
                                                    mother.removeChild(p);
                                                    //class='plants-pic' src='../images/userDonate/1/"+msg[i]['image_1']+"' style='display: inline;width: 20%'
                                                    for(var i=0;i<msg.length;i++){
                                                        var li = document.createElement("li");
                                                        li.setAttribute("class","list-group-item");
                                                        li.style.width = "100%";
                                                        var id = msg[i]['id'];
                                                        li.onclick = function(){
                                                            location.href = "http://localhost:8080/myDonate/query?id="+id;
                                                        }
                                                        li.innerHTML=
                                                        "<table><tr>"+
                                                        "<th class='img'><img class='plants-pic' src='../images/userDonate/1/"+msg[i].image_1+"'></th>"+
                                                        "<th><p>["+msg[i].plantName+"]"+msg[i].reason+"<br>"+msg[i].plantDesc+"</p></th>"+
                                                        "</tr></table>";
                                                        mother.appendChild(li);

                                                    }

                                                    currentPage++;
                                                    $contentLoadTriggered = false;
                                                },
                                                error: function (x, e){
                                                    alert("加载失败，请重试");
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
<header>
    <img id="header" src="../images/util/2.jpg">
    <p id="title">我的捐赠</p>
</header>
<ul class="list-group" id="mother"style=" overflow-x:hidden;overflow-y:auto">
    <c:forEach items="${donates}" var="donate">
        <li class="list-group-item" onclick="location.href='http://localhost:8080/myDonate/query?id=${donate.id}'">
            <table>
                <tr>
                    <th class="img"><img class="plants-pic" src="../images/userDonate/1/${donate.image_1}"></th>
                    <th><p>[${donate.plantName}]${donate.reason}<br>${donate.plantDesc}</p></th>
                </tr>
            </table>
        </li>
    </c:forEach>
</ul>

<script>
    $("#header").height(screen.height/4);
    $("#mother").height(screen.height*3/4);
</script>
</body>
</html>