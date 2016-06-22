package com.hbuas.service;

import com.hbuas.pojo.entity.shop.Ware;

import java.util.HashSet;
import java.util.List;

/**
 * Created by zss on 2016/6/6.
 */
public interface SearchService {
    /*
    * 根据关键词 搜索商品
    * @param key 关键词 匹配商品分类或者植物分类
    * @param page 分页号
    * @num 每页选取的商品
    * @return 返回匹配的商品*/
    public List<Ware> searchWare(String key,int page,int num);
    /*返回用户所有搜索的关键词
    * @param userId 商品用户Id
    * @return 返回用户搜索过的关键词
    * */
    public HashSet<String> getUserRecentSearch(int userId);
    /*返回最近搜索量高的关键词*/
    public HashSet<String> getHotSearch(int page,int num);

    public boolean saveUserSearch(int id,String keyWord);
}
