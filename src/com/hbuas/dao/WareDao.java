package com.hbuas.dao;

import com.hbuas.pojo.entity.shop.Ware;

import java.util.List;
import java.util.Map;

/**
 * Created by zss on 2016/5/29.
 * 商品数据访问组件
 */
public interface WareDao {
    /*
   @param classifyId 分类商品id
   @param num 选取商品的数量
   @parm page 分页号
   @return 所选取的商品
 * */
    public List<Ware> getWaresByClassifyId(int classifyId,int page,int num);
    /*
      根据用户操作记录 返回返回商品
      @param userId 用户Id
      @param page 分页号
      @param 选取商品数量
      @return
    * */
    public List<Ware> getUserLikeWares(int userId,int page,int num);

    /*
      获取最新上架的商品类别号
      @param num 商品类别数量
      @return 商品类别id数组
    * */
    public List getNewGround(int num);
    /*
        根据植物分类选取商品，每一种商品各取一个
        @param categoryId 植物分类Id
        @num 选取的商品类别数 num=-1表示全部加载
        @return 返回该植物类，num种商品，每一种商品各取一件
    * */
    public Map<String,List<Ware>> getWaresByCategoryId(int categoryId,int num);
}
