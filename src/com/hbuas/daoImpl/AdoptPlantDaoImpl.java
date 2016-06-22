package com.hbuas.daoImpl;

import com.hbuas.dao.AdoptPlantDao;
import com.hbuas.dao.DonatePlantDao;
import com.hbuas.pojo.entity.AdoptPlantInfo;
import com.hbuas.pojo.entity.DonatePlantInfo;
import org.hibernate.*;
import org.hibernate.criterion.Expression;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by dell on 2016/6/9.
 */
@Repository
public class AdoptPlantDaoImpl implements AdoptPlantDao {
    @Autowired
    private SessionFactory sessionFactory;
    @Resource
    private DonatePlantDao donatePlantDao;
    public boolean adoptPlantInfoInsert(AdoptPlantInfo adoptPlantInfo){
        boolean result = true;
        Transaction tx = null;
        Session session =null;
        int plantId = adoptPlantInfo.getPlantId();
        try{
            session = sessionFactory.openSession();
            tx = session.beginTransaction();
            session.save(adoptPlantInfo);
            Query query = session.createQuery("update DonatePlantInfo dpi set dpi.isAdopted=1 where dpi.id=:pid");
            query.setInteger("pid",plantId);
            query.executeUpdate();
            tx.commit();
        }catch (HibernateException e){
            if(tx!=null) tx.rollback();
            System.out.println("这里" + e.getMessage());
            result = false;
            System.out.println("用户插入数据库异常" + result);
        }finally {
            session.close();
        }
        System.out.println("out");
        return result;
    }

    public void updateIsAdopted(){}


    public List<AdoptPlantInfo> queryAdoptedPlantInfo(int index){

        Session  session = null;
        List<AdoptPlantInfo> list = null;
        session = sessionFactory.openSession();
        Criteria criteria = session.createCriteria(AdoptPlantInfo.class);
        criteria.setFirstResult(index);
        criteria.setMaxResults(10);
        list = criteria.list();
        return list;
    }
    public List<AdoptPlantInfo> queryAdoptedPlantInfoByUserId(int userId,int index){


        List<AdoptPlantInfo> list = null;
        Session session = this.sessionFactory.openSession();
        Criteria criteria = session.createCriteria(AdoptPlantInfo.class)
                .add(Expression.eq("adoptedUserId",new Integer(userId)));
        criteria.setMaxResults(10);
        criteria.setFirstResult(index);
        list = criteria.list();

        return list;
    }
}
