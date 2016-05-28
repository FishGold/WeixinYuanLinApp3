package com.hbuas.service;

import com.hbuas.pojo.entity.shop.Ware;

import java.util.List;

/**
 * Created by zss on 2016/5/28.
 */
public interface ShopWareService {
    /*
      @param classifyId 分类商品id
      @param num 选取商品的数量
      @return 所选取的商品
    * */
    public List<Ware> getClassifyId(int classifyId,int num);

    /*
        @param  page 选取商品的分页号
        @param num 选取商品数量
        @return 所选取的商品
    * */
    public List<Ware> getHotWares(int page ,int num);

}
