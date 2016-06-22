package com.hbuas.dao;

import com.hbuas.pojo.entity.shop.ShopCarousel;

import java.util.List;

/**
 * Created by zss on 2016/5/29.
 * 趣商城主页轮播
 */
public interface ShopCarouselDao {
    /*
      获取商城主页轮播 数据
    * */
    public List<ShopCarousel> getShopCarousel();
}
