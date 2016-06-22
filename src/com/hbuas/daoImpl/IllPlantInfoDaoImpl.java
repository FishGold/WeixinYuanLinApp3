package com.hbuas.daoImpl;
import com.hbuas.dao.PlantReportDao;
import com.hbuas.pojo.entity.PlantReportInfo;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.*;
import org.hibernate.criterion.Expression;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
/**
 * Created by dell on 2016/5/29.
 */
@Repository
public class IllPlantInfoDaoImpl implements PlantReportDao {
    @Autowired
    private SessionFactory sessionFactory;
    private Logger logger = LogManager.getLogger();
    public boolean insertReportPlantInfo(PlantReportInfo plantReportInfo) {
        boolean result = true;
        Transaction tx = null;
        Session session =null;
        try{
            session = sessionFactory.openSession();
            tx = session.beginTransaction();
            session.save(plantReportInfo);
            tx.commit();
        }catch (HibernateException e){
            if(tx!=null) tx.rollback();
            logger.error("这里"+e.getMessage());
            result = false;
            logger.error("用户插入数据库异常"+result);
        }finally {
            session.close();
        }
        return result;
    }
    @Override
    public PlantReportInfo getPlantInfoReport(String userId) {
       PlantReportInfo plantReportInfo = null;
        Session session = this.sessionFactory.openSession();
        Query query = session.createQuery("from PlantReportInfo pr where pr.userId=:userId");
        query.setString("userId",userId);
        List<PlantReportInfo>  list= query.list();

        if (list!= null &&list.size()>=1)
            plantReportInfo = list.get(0);
        return plantReportInfo;
    }

    public List<PlantReportInfo> queryTenRecords(int userId,int index){
        List<PlantReportInfo> list = null;
        Session session = this.sessionFactory.openSession();
        Criteria criteria = session.createCriteria(PlantReportInfo.class)
                .add(Expression.eq("userId",userId));
        criteria.setFirstResult(index);
        criteria.setMaxResults(10);
        list = criteria.list();
        return  list;
    }
}
