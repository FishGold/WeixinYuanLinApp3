package com.hbuas.dao;

import com.hbuas.pojo.entity.shop.Ware;

import java.util.List;

/**
 * Created by zss on 2016/6/11.
 * 购物车操作实体类
 */
public interface CartDao {
    public List<Ware> getShopCartWares(int userId);
}
