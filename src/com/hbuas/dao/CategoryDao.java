package com.hbuas.dao;

import com.hbuas.pojo.entity.shop.PlantCategory;

import java.util.List;

/**
 * Created by zss on 2016/6/4.
 * 植物分类 dao接口
 */
public interface CategoryDao {
    public String getCategoryNameById(int id);
    public PlantCategory getPlantCategoryById(int id);
    public List<PlantCategory> getAllCategory();
}
