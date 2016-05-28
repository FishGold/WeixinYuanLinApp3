package com.hbuas.pojo.entity;

/**
 * Created by zss on 2016/5/27.
 * 商品信息实体类
 */
public class Ware {
    private int wareId;
    private int classifyId;//商品分类id
    private int storeId;//店铺或者苗圃场id
    private String name;//商品名称
    private float oldPrice;//商品原价
    private float price;//商品现价
    private String shortDescription;
    private String description;//商品描述
    private String imgUrl[];//商品图片地址数组
    private String area;//商品地区
    private String areaDetail;//商品详细地址
    private int [] heights;//h[0]高度，h[1]胸径，h[2]地径，h[3]冠幅
    private int remainNum;//库存

}
