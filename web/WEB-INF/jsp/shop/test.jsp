<%--
  Created by IntelliJ IDEA.
  User: zss
  Date: 2016/6/3
  Time: 21:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
  <script src="js/jquery.min.js"></script>
</head>
<body>
<h2 style="margin-top: 500px">这里</h2>
<p id="before"></p>
<p id="sending"></p>
<p id="success"></p>
<p id="error"></p>
<p id="complete"></p>
<script>
  $(window).on("scroll",scrollDown);
  function scrollDown(){
    var scrollTop = $(this).scrollTop();
    var scrollHeight = $(document).height();
    var windowHeight = $(this).height();
    if (scrollTop + windowHeight == scrollHeight) {
      $.ajax({
          url:"http://localhost:8080/yuanlin/shop/guessYouLike?page=0",
          beforeSend:function(){
              var str =   $("#before").html();
              $("#before").html(str+"开始发送前！");
              $(window).off("scroll");
          },
          success:function(data){
              var str =  $("#sending").html();
              $("#sending").html(str+"成功"+data);

          },
          error:function(data){
             var str =  $("#error").html();
             $("#error").html(str+"出错了"+data);
         },
         complete:function(data){
            var str =  $("#complete").html();
            $("#complete").html(str+"无论对与错，这个都要执行"+data);
             $(window).on("scroll",scrollDown);
         }
      });


    }
  }
</script>
</body>
</html>
