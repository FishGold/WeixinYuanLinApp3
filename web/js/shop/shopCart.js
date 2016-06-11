/**
 * Created by ZSS on 2016/3/15.
 */
$(function(){
    $("#footer").hide()
    $(".glyphicon-minus").on('click',function(){
        $(this).addClass("temp");
        var num = parseInt($(".temp ~ .number").html())-1;
        if(num>0){
            $(".temp ~ .number").html(num);
        }
        $(this).removeClass("temp");
        caculate();
    });
    $(".glyphicon-plus").on('click',function(){
        $(this).addClass("temp");
        var maxNum =parseInt($(".temp ~ .max_num").html());
        var num = parseInt($(".temp ~ .number").html())+1;
        if(num<=maxNum){
            $(".temp ~ .number").html(num);
        }
        $(this).removeClass("temp");
        caculate();
    });
   $("#all_select").click(function(){
       if($(this).attr("checked")){
           $(".cart_item input").each(function(){
               $(this).removeAttr("checked");
           })
           $(this).removeAttr("checked");

       }else{

           $(".cart_item input").each(function(){
               if($(this).attr("checked")){
               }else{
                   $(this)[0].checked=true;
               }
           });
           $(this).attr("checked","true");
       }
       caculate();

   });
    $(".cart_item input").on("click",function(){
        if($("#footer_key").html() === "yes"){
            if($(this)[0].checked ==true){
                $("#footer").show();
                $("#footer_key").html("no");
            }
        }
        else{
            var key = false;
            $(".cart_item input").each(function(){
                if($(this)[0].checked == true){
                    key=true;
                }
            });
            if(key==false){
                $("#footer").hide();
                $("#footer_key").html("yes");
            }

        }
        caculate();
    });
    $("span[data-toggle='modal']").click(function(){
        $(this).addClass("using");
        var item=$(".using ~ span").html();
        $(".delete_clazz").html(item);
    });
    $("#cancle").click(function(){
        $("#mymodal").modal('hide');
    });
    $("#confirm").click(function(){
        var item =  $(".delete_clazz").html();
        $("#mymodal").modal('hide');
        $("."+item).empty();

    });
    $("#mymodal").on("hide.bs.modal",function(){
        $(".delete_clazz").html("");
    })
});
function caculate(){
    var money=0;
    var num=0;
    var clazz;
    var tempnum;
    $(".cart_item input").each(function(){
        if($(this)[0].checked == true){
            clazz=$(this).attr("value");
            tempnum=parseInt($("."+clazz+" .number").html());
            money = money + tempnum * parseInt($("."+clazz+" .price").html());
            num= num+tempnum;

        }
    });
    $("#total_money").html("&yen;"+money);
    $("#total_num").html(num);
}
