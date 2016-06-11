/**
 * Created by zss on 2016/5/11.
 */
$(function(){
    $("#top_input").focus(function(){
        window.location.href="goToSearch";
    });
    //一些初始化的工作
    $("#sortMenu").hide();
    $("#area").hide();
    var height = $("#main_container").offset().top-4;
    var bodyWeight = document.body.clientWidth;
    $("#more_filter_container").css("right",-bodyWeight);
    $("#sortMenu").css("top",height);
    $("#area").css("top",height);

    //下拉按钮事件处理  排序 地区
    $(".radio_box").click(function(){
        var status = $(this).attr("data-toggle");
        var e = $(this).attr("data-target");
        if(status == "hide"){

            var id = $(this).attr("id");
            if(id =="one_sort")
                id = "two_area";
            else if( id =="two_area")
                id = "one_sort";
            $another = $("#"+id);
            if($another.attr("data-toggle") == "show")
                $another.click();


            $('body').css("overflow","hidden");
            $(e).show(200);
            $(this).attr("data-toggle","show");
            $("#cover").addClass("modal-backdrop fade in");
            $("#cover").css("top",height+5);
        }
        else if(status == "show"){
            $("#cover").removeClass("modal-backdrop fade in");

            $('body').css("overflow","auto");
            $(e).hide();
            $(this).attr("data-toggle","hide");

        }
    });
    //地区选择事件
    $("#area_btn_ok").click(function(){
        var list = new Array();
        $("#area input[name='areas']:checked").each(function(){
           list.push($(this).attr("value"));
       });
        $("#main_container li").each(function(){
            var id= $(this).find(".areaId").first().text();
           var i;

           for( i=0;i<list.length;i++){
                if(id == list[i]){

                    break;
                }

           }

           if(i == list.length)
               $(this).hide();
           else{

                $(this).show();
           }

        });
    });
    $(".drop_footer button").on("click",function(){
        var who = $(this).attr("data-target");
        $(who).click();
    });
    //
    $("#cover").click(function(){
        $(this).removeClass("modal-backdrop fade in");
        $("#sortMenu").hide();
        $("#one_sort").attr("data-toggle","hide");
        $("#area").hide();
        $("#two_area").attr("data-toggle","show");
    });
    //
    $("#more_filter").click(function(){
        $("#cover").click();
        var status = $(this).attr("data-status");
        if(status == "hide"){
            $("#more_filter_container").animate({"right":"0px"},500);
            $(this).attr("data-status","show");
            setTimeout(' $("#filter_cover").addClass("modal-backdrop fade in")',450);
           ;
        }
    });
    $("#filter_cover").click(function(){
        $("#more_filter_container").animate({"right":-bodyWeight},500);
        $("#more_filter").attr("data-status","hide");
        $(this).removeClass("modal-backdrop fade in");
    });

    //筛选按钮事件
    $("#filter_cancle").click(function(){
        $("#filter_cover").click();
    })
    $("#filter_ok").click(function(){
        $("#filter_cover").click();
        var heights = new Array();
        $(".attr_box").each(function(){
            var data = JSON.parse($(this).find(".value").first().attr("data"));
            heights.push(data);
        });
       // alert(heights[0]["max"]+" "+heights[1]["max"]+" "+heights[2]["max"]+" "+heights[3]["max"]);
        var minPrice1 = $(".minPrice").val();
        var maxPrice = $(".maxPrice").val();
        var price = $(".price").val();
        if(maxPrice<minPrice1){
            maxPrice =0;
            minPrice1=0;
        }
        $("#main_container li").each(function(){
            var data = $(this).attr("data");
            data = JSON.parse(data);
            var dataArray = data["height"];
           // alert(dataArray[0]+" "+dataArray[1]+" "+dataArray[2]+" "+dataArray[3]);
            var i;
            for(i=0;i<heights.length;i++){
                if(heights[i]["max"]<dataArray[2*i] || dataArray[2*i+1]<heights[i]["min"]){
                    break;
                }
            }
            if(i ==heights.length&& price>=minPrice1&& price<=maxPrice)
                $(this).show();
            else
                $(this).hide();

        });

    });

    //植株高度选择事件
    $("ul[aria-labelledby='dropdownMenu4'] li").click(function(){
        chooseHeightHanler($(this),4);
    });
    $("ul[aria-labelledby='dropdownMenu3'] li").click(function(){
        chooseHeightHanler($(this),3);
    });
    $("ul[aria-labelledby='dropdownMenu2'] li").click(function(){
        chooseHeightHanler($(this),2);
    });
    $("ul[aria-labelledby='dropdownMenu1'] li").click(function(){
        chooseHeightHanler($(this),1);
    });
   var areas=["襄城区","樊城区","襄州区"];
    var data={  "saleNum":12,
                "price":45,
                "areaId":2,
                "assessNum":45,
                "name":"粉黛乱籽草",
                 "address":"襄城区古隆中296号",
                 "areaId":2,
                 "height":[10,15,36,20]};
});

function chooseHeightHanler($this,code){
    var data  =  $this.attr("data");
    data=JSON.parse(data);
    if(data){
        var temp = data["min"];
        if(data["max"]== 10000){
            temp+="cm+"
        }
        else
            temp =temp+"--"+data["max"]+"cm";
        $("#dropdownMenu"+code+" .value").html(temp).attr("data",JSON.stringify(data));
    }
}
