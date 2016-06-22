package com.hbuas.serviceImpl;

import com.hbuas.dao.ShopCarouselDao;
import com.hbuas.dao.ShopUserDao;
import com.hbuas.dao.WareDao;
import com.hbuas.pojo.entity.shop.PlantCategory;
import com.hbuas.pojo.entity.shop.ShopCarousel;
import com.hbuas.pojo.entity.shop.Ware;
import com.hbuas.pojo.entity.shop.WareClassify;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.*;

/**
 * Created by zss on 2016/5/29.
 * 趣商城 主页服务组件
 */
@Service
public class ShopHomeService {
    @Autowired
    private WareDao wareDao;
    @Autowired
    private ShopCarouselDao carouselDao;
    @Autowired
    private ShopUserDao shopUserDao;
    private Logger logger = LogManager.getLogger();
    //最新上架的num类植物，各取6种
    public List<Map<PlantCategory,List<Ware>>> getWaresByCategory(int num){
        List<Integer> list1 = (List<Integer>)wareDao.getNewGround(num);
        List<Map<PlantCategory,List<Ware>>> lists = new ArrayList<Map<PlantCategory, List<Ware>>>();
        for(int i = 0;i<list1.size();i++){
           Map<PlantCategory,List<Ware>> map =  wareDao.getWaresByCategoryId(list1.get(i).intValue(),6,true);
            if (map!=null)
                lists.add(map);
        }
        return lists;
    }
    public List<Ware> getUserLikeWares(int userId,int page,int num) {

        List<Ware> list = null;
        if (userId == -1){
            list = wareDao.getWares(page,num);
        }
        else {
           List<WareClassify> list1 = shopUserDao.getUserCollectionClassify(userId);
            List<WareClassify> list2 = shopUserDao.getUserRecoderWareClassify(userId);
            Set set = new HashSet();//利用set排除相同的分类
            for(int i =0;i<list1.size();i++){
                set.add(list1.get(i).getClassifyId());
            }
            for(int j = 0;j<list2.size();j++){
                if (set.add(list2.get(j).getClassifyId()))
                  list1.add(list2.get(j));
            }
            List<Ware> list3 = new ArrayList<Ware>();
            for(int i=0;i<list1.size();i++){
                System.out.println(list1.get(i).getName());
            }
            for (int i =0 ;i<list1.size();i++){
                list3.addAll(list1.get(i).getList());
            }
            if(list3.isEmpty()){
                list = wareDao.getWares(page,num);
            }
            else {
                int min = page*num;
                int max = min+num;
                int size = list3.size();
                if(size>=max)
                    list = list3.subList(min,max);
                else  if(size<min)
                    list = null;
                else if(size>=min&&size<max)
                    list = list3.subList(min,size);
            }
        }
        logger.info("list分页"+list.size());
       return list;
    }
    public List<ShopCarousel> getShopCarousel() {
        List<ShopCarousel> list = carouselDao.getShopCarousel();
        if (list != null && !list.isEmpty())
            return list;
        else return null;
    }
    public Ware getWare(int wareId){
        return wareDao.getWareById(wareId);
    }
    /*将商品list转换成json 为主页从猜你喜欢ajax调用服务
    * @param list 商品list
    * @return 返回部分商品信息的json字符串*/
    public JSONArray PartWareList2Json1(List<Ware> list){
         JSONArray jsonArray = new JSONArray();
     for(Ware ware:list){
         JSONObject jsonObject = new JSONObject();
         jsonObject.put("wareId",ware.getWareId());
         jsonObject.put("imgUrl",ware.getImgUrl().get(0).getImgUrl());
         jsonObject.put("shortDescription",ware.getShortDescription());
         jsonObject.put("oldPrice",ware.getOldPrice());
         jsonObject.put("price",ware.getPrice());
         jsonObject.put("saleNum",ware.getSalesNum());
         jsonArray.add(jsonObject);
     }
         return jsonArray;
    }

}
