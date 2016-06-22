package com.hbuas.daoImpl;

import com.hbuas.dao.SNSUserDao;
import com.hbuas.pojo.entity.SNSUserInfo;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;


/**
 * Created by zss on 2016/5/26.
 */
@Repository
public class SNSUserDaoImpl implements SNSUserDao {
    @Autowired
    private SessionFactory sessionFactory;
    private Logger logger = LogManager.getLogger();
    public boolean insertSNSUser(SNSUserInfo snsUserInfo) {
        boolean result = true;
        Transaction tx = null;
        Session session =null;
        try{
            session = sessionFactory.getCurrentSession();
            tx = session.beginTransaction();
            /*查询数据库中是否曾在该用户，依据openId*/
            Query query = session.createQuery("from SNSUserInfo s where s.openId=:openid");
            query.setString("openid", snsUserInfo.getOpenId());
            List<SNSUserInfo> list = query.list();
            System.out.println(list.isEmpty());
            logger.error(list.size());
            if (list.isEmpty())
                session.save(snsUserInfo);
            else{
                SNSUserInfo sns= list.get(0);
                /*更新这个用户实体*/
                sns.setProvince(snsUserInfo.getProvince());
                sns.setSex(snsUserInfo.getSex());
                sns.setCity(snsUserInfo.getCity());
                sns.setHeadImgUrl(snsUserInfo.getHeadImgUrl());
                sns.setNickname(snsUserInfo.getNickname());
                session.update(sns);
            }
            tx.commit();
        }catch (HibernateException e){
            if(tx!=null)
                tx.rollback();
            logger.error("here"+e.getMessage());
            result = false;
            logger.error("用户插入数据库异常"+result);
        }
        return result;
    }

    @Override
    public SNSUserInfo getSNSUserInfo(String  openid) {
        SNSUserInfo snsUserInfo = null;
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("from SNSUserInfo a where a.id=:id");
        query.setString("id", openid);
        List<SNSUserInfo>  list= query.list();
        if (list!= null &&list.size()>=1)
            snsUserInfo = list.get(0);
        return snsUserInfo;
    }

    @Override
    public SNSUserInfo getSNSUserInfoById(int id) {
        Session session = sessionFactory.getCurrentSession();
        SNSUserInfo s = (SNSUserInfo)session.get(SNSUserInfo.class,id);
        return s;
    }

}
