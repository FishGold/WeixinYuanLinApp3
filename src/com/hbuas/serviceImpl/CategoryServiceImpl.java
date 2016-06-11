package com.hbuas.serviceImpl;

import com.hbuas.dao.CategoryDao;
import com.hbuas.dao.WareDao;
import com.hbuas.pojo.entity.shop.PlantCategory;
import com.hbuas.pojo.entity.shop.Ware;
import com.hbuas.service.CategoryService;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by zss on 2016/6/4.
 *
 */
@Service
public class CategoryServiceImpl implements CategoryService
{
    @Autowired
    private WareDao wareDao;
    @Autowired
    private CategoryDao categoryDao;
    private Logger logger = LogManager.getLogger();
    public List<Ware> getWareByCategory(int categoryId,int page,int num){
        Map<PlantCategory,List<Ware>> map=wareDao.getWaresByCategoryId(categoryId, 999999999,false);//9999999表示无穷大 获取所有商品
        List<Ware> list1 = new ArrayList<Ware>();
        for(List<Ware> list:map.values()){//将map转换成list
            list1.addAll(list);
        }
        int assessNum;
        for(Ware ware:list1){//将评价数写入商品属性
            assessNum = ware.getAssess().size();
            ware.setAssessNum(assessNum);
        }
        System.out.println("categoryId="+categoryId+"的商品有"+list1.size());
        List<Ware> list2 = new ArrayList<Ware>();
        int min = page*num;
        int max = min+num;
        int size = list1.size();
        if(size>=max)
            list2 = list1.subList(min,max);
        else  if(size<min)
            list2 = null;
        else if(size>=min&&size<max)
            list2 = list1.subList(min,size);
        return list2;
    }
    @Override
    public String getCategoryName(int id) {

        return categoryDao.getCategoryNameById(id);
    }

    @Override
    public JSONArray wareList2Json(List<Ware> list) {
        JSONArray jsonArray = new JSONArray();
        for(Ware ware:list){
            int assNum = wareDao.getAssessNum(ware.getWareId());
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("wareId",ware.getWareId());
            jsonObject.put("shortDescription",ware.getShortDescription());
            jsonObject.put("price",ware.getPrice());
            jsonObject.put("area",ware.getArea());
            jsonObject.put("assessNum",assNum);
            jsonObject.put("saleNum",ware.getSalesNum());
            jsonObject.put("imgUrl",ware.getImgUrl().get(0).getImgUrl());
            jsonObject.put("areaId",ware.getAreaId());
            jsonObject.put("minGd",ware.getWareHeights().getMinGd());
            jsonObject.put("maxGd",ware.getWareHeights().getMaxGd());
            jsonObject.put("minXj",ware.getWareHeights().getMinXj());
            jsonObject.put("maxXj",ware.getWareHeights().getMaxXj());
            jsonObject.put("minGf",ware.getWareHeights().getMaxGf());
            jsonObject.put("minDj",ware.getWareHeights().getMaxDj());
            jsonObject.put("maxDj",ware.getWareHeights().getMaxDj());
            jsonObject.put("maxGf",ware.getWareHeights().getMaxGf());
            jsonObject.put("imgUrl",ware.getImgUrl().get(0).getImgUrl());
            jsonArray.add(jsonObject);
        }
//        logger.info(jsonArray.toString());
        return jsonArray;
    }

    @Override
    public PlantCategory getCategory(int id) {
        return categoryDao.getPlantCategoryById(id);
    }

    @Override
    public List<Ware> getHotWare(int page,int num) {
        return wareDao.getHotWares(page,num);
    }

    @Override
    public List<PlantCategory> getAllPlants() {
        return  categoryDao.getAllCategory();
    }

}
