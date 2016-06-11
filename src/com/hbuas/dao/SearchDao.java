package com.hbuas.dao;

import com.hbuas.pojo.entity.shop.WareClassify;


import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;


/**
 * Created by zss on 2016/6/6.
 * 全站搜索 Dao接口
 */
public interface  SearchDao {
   public LinkedHashSet<WareClassify> searchCategory(String key);
   public LinkedHashSet<WareClassify> searchClassify(String key);
   public HashSet<String> getUserRecentSearch(int userId);
   public HashSet<String> getHotSearch(int page,int num);
}
