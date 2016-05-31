package com.hbuas.serviceImpl;

import com.hbuas.dao.ShopCarouselDao;
import com.hbuas.dao.WareDao;
import com.hbuas.pojo.entity.shop.ShopCarousel;
import com.hbuas.pojo.entity.shop.Ware;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

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
    //最新上架的num类植物，各取6种
    public List<Map<String,List<Ware>>> getWaresByCategory(int num){
//        List<Ware> list =  wareDao.getWaresByClassifyId(classifyId,0,num);
//        if (list != null && !list.isEmpty())
//            return list;
//        else return null;
        List<Integer> list1 = (List<Integer>)wareDao.getNewGround(num);
        List<Map<String,List<Ware>>> lists = new ArrayList<Map<String, List<Ware>>>();
        for(int i = 0;i<list1.size();i++){
           Map<String,List<Ware>> map =  wareDao.getWaresByCategoryId(list1.get(i).intValue(),6);
            if (map!=null)
                lists.add(map);
        }
        return lists;
    }
    public List<Ware> getUserLikeWares(int userId) {
        List<Ware> list = wareDao.getUserLikeWares(userId,0,6);
        if (list != null && !list.isEmpty())
            return list;
        else return null;
    }
    public List<ShopCarousel> getShopCarousel() {
        List<ShopCarousel> list = carouselDao.getShopCarousel();
        if (list != null && !list.isEmpty())
            return list;
        else return null;
    }
}
