package com.hbuas.daoImpl;

import com.hbuas.dao.SearchDao;
import com.hbuas.pojo.entity.SNSUserInfo;
import com.hbuas.pojo.entity.shop.PlantCategory;
import com.hbuas.pojo.entity.shop.SearchRecord;

import com.hbuas.pojo.entity.shop.WareClassify;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;

/**
 * Created by zss on 2016/6/6.
 */
@Repository
public class SearchDaoImpl implements SearchDao{
    private Logger logger = LogManager.getLogger();
    @Autowired
    private SessionFactory sessionFactory;
    @Override
    public LinkedHashSet<WareClassify> searchCategory(String key) {
        LinkedHashSet<WareClassify> set = new LinkedHashSet<WareClassify>();
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("from PlantCategory as p where p.name like:keyword");
        query.setString("keyword","%"+key+"%");
        List<PlantCategory> lists = query.list();
        List<WareClassify> list;
        for(PlantCategory plantCategory:lists){
            list = plantCategory.getList();
            for(WareClassify classify :list){
                set.add(classify);
            }
        }
        logger.info("category匹配结果"+set.size());
        return set;
    }

    @Override
    public LinkedHashSet<WareClassify> searchClassify(String key) {
        LinkedHashSet<WareClassify> hashSet = new LinkedHashSet();
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("from WareClassify as w where w.name like:keyword");
        query.setString("keyword","%"+key+"%");
        List<WareClassify> list = query.list();
        for(WareClassify classify :list){
            hashSet.add(classify);
        }
        logger.info("classify匹配结果"+hashSet.size());
        return hashSet;
    }

    @Override
    public HashSet<String> getUserRecentSearch(int userId) {
        if(userId == -1)
            return null;
        Session session = sessionFactory.getCurrentSession();
        SNSUserInfo snsUserInfo  = (SNSUserInfo)session.get(SNSUserInfo.class,userId);
        List<SearchRecord> list = snsUserInfo.getList();
        HashSet<String> set = new HashSet<String>();
        for(SearchRecord searchRecord :list){
            set.add(searchRecord.getKeyWord());
        }
        return set;
    }

    @Override
    public HashSet<String> getHotSearch(int page, int num) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("from SearchRecord");
        int first = page*num;
        if (first<0)
            first = 0;
        query.setFirstResult(first);
        int end = first+num;
        logger.info("起始"+first+"---"+end);
        query.setMaxResults(num);
        HashSet<String> set = new HashSet<String>();
        List<SearchRecord> list = query.list();
        for(SearchRecord searchRecord :list){
            set.add(searchRecord.getKeyWord());
        }
        return set;
    }
}

