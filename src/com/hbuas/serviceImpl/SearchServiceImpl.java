package com.hbuas.serviceImpl;

import com.hbuas.dao.SearchDao;
import com.hbuas.dao.ShopUserDao;
import com.hbuas.pojo.entity.shop.Ware;
import com.hbuas.pojo.entity.shop.WareClassify;
import com.hbuas.service.SearchService;
import com.hbuas.utils.PageUtil;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;

/**
 * Created by zss on 2016/6/6.
 */
@Service
public class SearchServiceImpl implements SearchService {
    private Logger logger = LogManager.getLogger();
    @Autowired
    private SearchDao searchDao;
    @Autowired
    private ShopUserDao shopUserDao;
    @Override
    public List<Ware> searchWare(String key, int page, int num) {
        LinkedHashSet<WareClassify> set =new LinkedHashSet<WareClassify>();
        set.addAll(searchDao.searchCategory(key));
        set.addAll(searchDao.searchClassify(key));
        logger.info("合并后的大小"+set.size());
        List<Ware> listsum  = new ArrayList<Ware>();
        for(WareClassify wareClassify :set){
            logger.info("查询结果"+wareClassify.getName());
            listsum.addAll(wareClassify.getList());
        }
        return PageUtil.getPage(page,num,listsum);
    }

    @Override
    public HashSet<String> getUserRecentSearch(int userId) {
        return searchDao.getUserRecentSearch(userId);
    }

    @Override
    public HashSet<String> getHotSearch(int page, int num) {
        return searchDao.getHotSearch(page,num);
    }

    @Override
    public boolean saveUserSearch(int id, String keyWord) {
        boolean result = true;
        if (id == -1 || "".equals(keyWord))
            result = false;
        else
           result = shopUserDao.saveUserSearch(id,keyWord);
        return result;
    }
}
