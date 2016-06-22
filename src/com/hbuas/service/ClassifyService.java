package com.hbuas.service;

import com.hbuas.pojo.entity.shop.Ware;
import com.hbuas.pojo.entity.shop.WareClassify;

import java.util.List;

/**
 * Created by zss on 2016/6/5.
 */
public interface ClassifyService {
    /*
      根据商品分类Id获取商品list
    * */
    public List<Ware> getClassifyWareById(int id,int page,int num);
    public WareClassify getClassifyById(int id);
}
