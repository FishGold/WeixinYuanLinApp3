package com.hbuas.daoImpl;

import com.hbuas.dao.ShopUserDao;
import com.hbuas.pojo.entity.SNSUserInfo;
import com.hbuas.pojo.entity.shop.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


import java.util.*;

/**
 * Created by zss on 2016/6/1.
 */
@Repository
public class ShopUserDaoImpl implements ShopUserDao {
    private Logger logger = LogManager.getLogger();
    @Autowired
    private SessionFactory sessionFactory;
    @Override
    public List<WareClassify> getUserRecoderWareClassify(int userId) {
        Session session = sessionFactory.getCurrentSession();
        SNSUserInfo snsUserInfo = (SNSUserInfo)session.get(SNSUserInfo.class,userId);
        //Query query = session.createQuery("select  distinct  new BuyRecord (w.classifyId) from BuyRecord w where w.userId=:temp");
      //  query.setInteger("temp",userId);
        List<WareClassify> list = new ArrayList<WareClassify>();
        List<BuyRecord> list1 = snsUserInfo.getBuyRecordList();
        HashSet set = new HashSet();
        for(int i=0;i<list1.size();i++){
            WareClassify wareClassify = (WareClassify)session.get(WareClassify.class,list1.get(i).getClassifyId());
            if (set.add(wareClassify.getClassifyId()))
                 list.add(wareClassify);
        }
        logger.info("session"+session.hashCode());
        return list;
    }


    @Override
    public List<WareClassify> getUserCollectionClassify(int userId) {
        Session session = sessionFactory.getCurrentSession();
        //select distinct a.name ,a.age from Student a
        SNSUserInfo snsUserInfo = (SNSUserInfo)session.get(SNSUserInfo.class,userId);
        //Query query1 = session.createQuery("select distinct  new ShopUserCollection(s.wareId) from ShopUserCollection s where s.userId=:temp");
        //logger.info("session"+session.hashCode());
        //query1.setInteger("temp",userId);

        List<ShopUserCollection> list = snsUserInfo.getCollectionslist();

        List<WareClassify> list1 = new ArrayList<WareClassify>();
        HashSet set = new HashSet();
        for(int i=0;i<list.size();i++){
          // WareClassify wareClassify = (WareClassify)session.get(WareClassify.class,list.get(i).getClassifyId());
            Ware ware = (Ware)session.get(Ware.class, list.get(i).getWareId());
            logger.info("session"+session.hashCode());
            WareClassify wareClassify = ware.getWareClassify();
            if (set.add(wareClassify.getClassifyId())){
                list1.add(wareClassify);
            }
        }
        return list1;
    }

    @Override
    public boolean saveUserSearch(int id, String keyWord) {
        Session session  = sessionFactory.getCurrentSession();
        Transaction transaction = session.beginTransaction();
        boolean result = true;
        try {
            SNSUserInfo snsUserInfo =(SNSUserInfo) session.get(SNSUserInfo.class,id);
            SearchRecord searchRecord = new SearchRecord();
            searchRecord.setKeyWord(keyWord);
            searchRecord.setSnsUserInfo(snsUserInfo);
            session.save(searchRecord);
        }catch (Exception e){
            logger.info(e.getMessage());
            result = false;
        }
        transaction.commit();
        return result;
    }

//    @Override
//    public Map<String, String> getUserInfo(int id) {
//
//        Session session = sessionFactory.getCurrentSession();
//        SNSUserInfo snsUserInfo = (SNSUserInfo)session.get(SNSUserInfo.class,id);
//        Map<String,String> map = new HashMap<String, String>();
//        map.put("nickname",snsUserInfo.getNickname());
//        map.put("sex",snsUserInfo.getSex());
//        String nation = snsUserInfo.getCountry()+ " "+snsUserInfo.getProvince()+ " "+snsUserInfo.getCity();
//        map.put("nation",nation);
//        Query query = session.createQuery("from ShopUser  where userId=:id");
//        query.setInteger("id",id);
//        List<ShopUser> list =query .list();
//        if (list.isEmpty()==false){
//            ShopUser shopUser1 = list.get(0);
//            map.put("realName", shopUser1.getRealName());
//            map.put("address",shopUser1.getAddressDetal());
//            map.put("phoneNum",shopUser1.getPhoneNum());
//            map.put("email",shopUser1.getEmail());
//        }
//
//        return map;
//    }


    public Map<String, String> getUserInfo(int id) {
        Session session = sessionFactory.getCurrentSession();
        SNSUserInfo snsUserInfo = (SNSUserInfo)session.get(SNSUserInfo.class,id);
        Map<String,String> map = new HashMap<String, String>();
        map.put("nickname",snsUserInfo.getNickname());
        map.put("sex",snsUserInfo.getSex());
        String nation = snsUserInfo.getCountry()+ " "+snsUserInfo.getProvince()+ " "+snsUserInfo.getCity();
        map.put("nation",nation);
        map.put("realName", snsUserInfo.getRealName());
        map.put("address",snsUserInfo.getAddressDetal());
        map.put("phoneNum",snsUserInfo.getPhoneNum());
        map.put("email",snsUserInfo.getEmail());
        return map;
    }

    @Override
    public boolean updateUserinfo(int userId, ShopUser shopUser) {
        boolean result = true;
        Session session = sessionFactory.getCurrentSession();
        try{
            Query query1 = session.createQuery("update SNSUserInfo set realName=:real, phoneNum=:phone,addressDetal=:address,email=:email where id=:id");
            query1.setString("real",shopUser.getRealName());
            query1.setString("phone",shopUser.getPhoneNum());
            query1.setString("address",shopUser.getAddressDetal());
            query1.setString("email",shopUser.getEmail());
            query1.setInteger("id",userId);query1.executeUpdate();
            query1.executeUpdate();

        }catch (HibernateException e){
            logger.info(e.getMessage());
            result = false;
        }
        return result;
    }


//    public boolean updateUserinfo(int userId, ShopUser shopUser) {
//        boolean result = true;
//        Session session = sessionFactory.getCurrentSession();
//
//        try{
//            Query query = session.createQuery("from ShopUser where userId=:temp");
//            query.setInteger("temp",userId);
//            List<ShopUser> list = query.list();
//            if (list.isEmpty()){
//                shopUser.setUserId(userId);
//                session.save(shopUser);
//                logger.info("userId=" + userId + "保存");
//            }
//            else {
//                Query query1 = session.createQuery("update ShopUser set realName=:real, phoneNum=:phone,addressDetal=:address,email=:email where userId=:id");
//                query1.setString("real",shopUser.getRealName());
//                query1.setString("phone",shopUser.getPhoneNum());
//                query1.setString("address",shopUser.getAddressDetal());
//                query1.setString("email",shopUser.getEmail());
//                query1.setInteger("id",userId);
//                query.executeUpdate();
//                logger.info("userId="+userId+"更新");
//            }
//
//            logger.info("执行完commit了！");
//        }catch (HibernateException e){
//            e.printStackTrace();
//            logger.info(e.getMessage());
//            result =false;
//
//
//        }
//        return result;
//    }

}
