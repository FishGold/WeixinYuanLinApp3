package com.hbuas.service;

import com.hbuas.pojo.entity.shop.Ware;

import java.util.List;

/**
 * Created by zss on 2016/6/11.
 * 购物车操作接口类
 */
public interface ShopCartService {
    /*返回用户购物车中的所有商品*/
    public List<Ware> getShopCartWares(int userId);
}
