<%--
  Created by IntelliJ IDEA.
  User: zss
  Date: 2016/6/10
  Time: 16:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head lang="en">
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1,user-scalable=no">
  <title>购物车</title>
  <link href="../css/bootstrap.min.css" rel="stylesheet">
  <link href="../css/shop/shopCart.css" rel="stylesheet">
  <script src="../js/jquery.min.js"></script>
  <script src="../js/bootstrap.min.js"></script>
  <script src="../js/shop/shopCart.js"></script>
</head>
<body>
<header class="text-center">
  <h5>购物车(4)</h5>
</header>
<div>
  <div class="cart_item item1">
    <div class="cart_item_head">
      <b >万山苗圃场<span class="glyphicon glyphicon-tree-conifer"> </span></b>
            <span class="pull-right head_right">
                <span class="text-danger" data-toggle="modal" data-target=".bs-example-modal-sm">移除</span>
                   <span class="hidden">item1</span>
            </span>
    </div>
    <div class="cart_item_body">
      <table>
        <tr>
          <td class="cart_item_first">
            <input type="checkbox" value="item1">
          </td>
          <td class="cart_item_second">
            <img src="images/shop/flower1.jpg" width="100%" class="img-thumbnail">
            <p class="text-left">库存<span class="second_num">6</span>棵</p>
          </td>
          <td class="cart_item_third">
            <p class="text-primary">盆栽花卉植物 君子兰小苗 圆头和尚君子兰盆栽当年开花室内蝴蝶兰。0</p>
            <span class="third_money">&yen;<span class="price">5</span>.00</span>
                            <span class="third_num" >
                                <span class="glyphicon glyphicon-minus"> </span>
                                <span class="glyphicon glyphicon-plus"> </span>
                                 <span class="number">2</span>
                                 <span class="max_num hidden">6</span>
                            </span>
          </td>
        </tr>
      </table>
    </div>

  </div>
  <div class="cart_item item2">
    <div class="cart_item_head">
      <b>红星苗圃场<span class="glyphicon glyphicon-tree-conifer"> </span></b>
            <span class="pull-right head_right">
                <span class="text-danger"  data-toggle="modal" data-target=".bs-example-modal-sm">移除</span>
                  <span class="hidden">item2</span>
            </span>
    </div>
    <div class="cart_item_body">
      <table>
        <tr>
          <td class="cart_item_first">
            <input type="checkbox" value="item2">
          </td>
          <td class="cart_item_second">
            <img src="images/shop/show2.jpg" width="100%" class="img-thumbnail">
            <p class="text-left">库存<span class="second_num">3</span>棵</p>
          </td>
          <td class="cart_item_third">
            <p class="text-primary">盆栽花卉植物 君子兰小苗 圆头和尚君子兰盆栽当年开花室内蝴蝶兰。</p>
            <span class="third_money">&yen;<span class="price">5</span>.00</span>
                            <span class="third_num" >
                                <span class="glyphicon glyphicon-minus"> </span>
                                <span class="glyphicon glyphicon-plus"> </span>
                                 <span class="number">2</span>
                                   <span class="max_num hidden">3</span>
                            </span>
          </td>
        </tr>
      </table>
    </div>
  </div>
  <div class="cart_item item3">
    <div class="cart_item_head">
      <b>红星苗圃场<span class="glyphicon glyphicon-tree-conifer"> </span></b>
            <span class="pull-right head_right">
                <span class="text-danger"  data-toggle="modal" data-target=".bs-example-modal-sm">移除</span>
                <span class="hidden">item3</span>
            </span>
    </div>
    <div class="cart_item_body">
      <table>
        <tr>
          <td class="cart_item_first">
            <input type="checkbox" value="item3">
          </td>
          <td class="cart_item_second">
            <img src="images/shop/show2.jpg" width="100%" class="img-thumbnail">
            <p class="text-left">库存<span class="second_num">100</span>棵</p>
          </td>
          <td class="cart_item_third">
            <p class="text-primary">美国红叶黄栌为漆树科黄栌属的一个变种，春季其叶片大部分为红色或紫红色。</p>
            <span class="third_money">&yen;<span class="price">5</span>.00</span>
                            <span class="third_num" >
                                <span class="glyphicon glyphicon-minus"> </span>
                                <span class="glyphicon glyphicon-plus"> </span>
                                 <span class="number">2</span>
                                   <span class="max_num hidden">100</span>
                            </span>
          </td>
        </tr>
      </table>
    </div>
  </div>
  <div class="cart_item item4">
    <div class="cart_item_head">
      <b>红星苗圃场<span class="glyphicon glyphicon-tree-conifer"> </span></b>
            <span class="pull-right head_right">
                <span class="text-danger"  data-toggle="modal" data-target=".bs-example-modal-sm">移除</span>
                 <span class="hidden">item4</span>
            </span>
    </div>
    <div class="cart_item_body">
      <table>
        <tr>
          <td class="cart_item_first">
            <input type="checkbox" value="item4">
          </td>
          <td class="cart_item_second">
            <img src="images/shop/show2.jpg" width="100%" class="img-thumbnail">
            <p class="text-left">库存<span class="second_num">100</span>棵</p>
          </td>
          <td class="cart_item_third">
            <p class="text-primary">美国红叶黄栌为漆树科黄栌属的一个变种，春季其叶片大部分为红色或紫红色。</p>
            <span class="third_money">&yen;<span class="price">5</span>.00</span>
                            <span class="third_num" >
                                <span class="glyphicon glyphicon-minus"> </span>
                                <span class="glyphicon glyphicon-plus"> </span>
                                 <span class="number">2</span>
                                   <span class="max_num hidden">100</span>
                            </span>
          </td>
        </tr>
      </table>
    </div>
  </div>
</div>

</div>
<div style="width: 100%;height: 50px"> </div>
<div id="footer">

  <span id="footer_key" class="hidden">yes</span>
    <span class="footer_one">
        <input type="checkbox" id="all_select">
        <span>全选</span>
    </span>
  <button class="btn btn btn-danger pull-right ">去结算(<span  id="total_num">4</span>)</button>
    <span class="pull-right footer_three">
            <span>总计:</span>
            <span style="color: red" id="total_money" >&yen;<span>23</span></span>
            <span class="text-muted" style="font-size: 12px">(不含运费)</span>
    </span>
</div>

<!-- Small modal -->

<div class="modal fade bs-example-modal-sm" tabindex="-1" role="dialog" aria-labelledby="mySmallModalLabel" id="mymodal">
  <div class="modal-dialog modal-sm">
    <div class="modal-content text-center">
      <p>确定移除？</p>
      <hr/>
      <button class="btn btn-successbtn-sm" id="cancle">取消</button>
      <span class="delete_clazz" style="opacity: 0"></span>
      <button class="btn btn-primary btn-sm" id="confirm">确定</button>
    </div>
  </div>
</div>
</body></html>
