/**
 * Created by zss on 2016/6/9.
 */
$("#saleFirst").click(function(){
    sortDoc("text-success",true);
});
function sortDoc(seleceter,asc){
    var  array = new Array();
    $("#main_container li").each(function(){
        var obj = new Object();
        obj.which = $(this);
        obj.num = $(this).find("."+seleceter).first().html();
        array.push(obj);
    });
    if(asc ==true)
        array.sort(function(a,b){return a.num- b.num;});
    else if(asc ==false)
        array.sort(function(a,b){return b.num- a.num;});
    var str = "";
    for(var i=0;i<array.length;i++){
        $("#main_container ul").prepend(array[i].which);
    }
}
$("#sort_ok").on("click",function(){
    var which = $('input[name="sortWay"]:checked').first().val();
    /*价格最低*/
    if(which ==2)
        sortDoc("price_1",false);
    else if(which ==3)
        sortDoc("price_1",true);
    else if(which == 4)
        sortDoc("text-primary",true);
})