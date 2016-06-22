package com.hbuas.service;

import com.hbuas.dao.WareDao;
import com.hbuas.pojo.entity.shop.PlantCategory;
import com.hbuas.pojo.entity.shop.Ware;
import net.sf.json.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public interface CategoryService {
    public List<Ware> getWareByCategory(int categoryId,int page,int num);
    public String  getCategoryName(int id);
    public JSONArray wareList2Json(List<Ware> list);
    public PlantCategory getCategory(int id);
    public List<Ware> getHotWare(int page,int num);
    public List<PlantCategory> getAllPlants();
}
