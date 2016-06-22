/**
 * Created by ZSS on 2016/3/9.
 */
var onePageNum =2;//定义一页商品的数量
function resizeTree(clazz){
    $v=$("."+clazz);
    var width=$v.width();
    $v.height(width);
}
$(function(){
    resizeTree("tree");
    $('#myCarousel').carousel({
        interval: 2000
    })
    $("#top_input").focus(function(){
        window.location.href="goToSearch";
    });
    $(window).on("scroll",scrollDown);
});

function scrollDown(){
    var scrollTop = $(this).scrollTop();
    var scrollHeight = $(document).height();
    var windowHeight = $(this).height();

    if (scrollTop + windowHeight == scrollHeight) {
       var page = $(".main").length/onePageNum;
        $.ajax({
            url:"guessYouLike?page="+page,
            beforeSend:function(){

                $(window).off("scroll");
            },
            success:function(jsonWare){
                var ware= $.parseJSON(jsonWare);
                for(var i =0;i<ware.length;i++){
                    var str = '<div class="main col-xs-6 col-sm-4 col-md-3 col-lg-2">' +
                        '<div class="main_item">' +
                        '<a href="wareDetail?wareId='+ware[i]["wareId"]+'">' +
                        '<img src='+ware[i]["imgUrl"]+'  class="tree"> ' +
                        '<div class="item_slide"> ' +
                        '<p class="text">'+ware[i]["shortDescription"]+'</p> ' +
                        '</div> <div class="money"> ' +
                        '<span class="price">&yen;'+ware[i]["oldPrice"]+'</span> ' +
                        '<s>&yen;'+ware[i]["price"]+'</s>' +
                        '<br> <span class="count">月销'+ware[i]["saleNum"]+'棵</span> ' +
                        '</div> ' +
                        '</a> ' +
                        '</div> ' +
                        '</div>';
                    $("#content").append(str);
                }
                resizeTree("tree");
            },

            error:function(data){

            },
            complete:function(data){
                $(window).on("scroll",scrollDown);
            }
        });


    }
}

