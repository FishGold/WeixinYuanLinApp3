package com.hbuas.service;

import com.hbuas.pojo.entity.shop.Ware;

import java.util.List;

/**
 * Created by zss on 2016/5/28.
 * 用户分析接口，根据用购买，搜索记录推荐商品
 */
public interface UserAnalyse {
    /*
      @param userId 用户Id
      @paran page 分页号
      @param num 选取商品数量
      @return 所选中商品列表
    * */
    public List<Ware> guessYouLike(int userId,int page,int num);
}
