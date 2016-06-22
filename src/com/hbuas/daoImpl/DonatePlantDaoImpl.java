package com.hbuas.daoImpl;
import com.hbuas.dao.DonatePlantDao;
import com.hbuas.pojo.entity.DonatePlantInfo;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.*;
import org.hibernate.criterion.Expression;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by dell on 2016/6/5.
 */
@Repository
public class DonatePlantDaoImpl implements DonatePlantDao{
    @Autowired
    private SessionFactory sessionFactory;
    private Logger logger = LogManager.getLogger();
    public boolean donatePlantInfoInsert(DonatePlantInfo dpi){
        boolean result = true;
        Transaction tx = null;
        Session session =null;
        try{
            session = sessionFactory.openSession();
            tx = session.beginTransaction();
            session.save(dpi);
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

    public List<DonatePlantInfo> queryTenRecords(int currentIndex){
        Session session =null;
        List<DonatePlantInfo> list = null;
        session = sessionFactory.openSession();

        Criteria crit = session.createCriteria(DonatePlantInfo.class);
        crit.add(Expression.eq("isAdopted",0));
        crit.setFirstResult(currentIndex);
        crit.setMaxResults(10);
        list = crit.list();

        return list;
    }

    public DonatePlantInfo queryPlant(int plantId){
        DonatePlantInfo donatePlantInfo = null;
        List<DonatePlantInfo> list = new ArrayList<DonatePlantInfo>();
        Session session = this.sessionFactory.openSession();
        Query query = session.createQuery("from DonatePlantInfo dpi where dpi.id = :plantId");
        query.setInteger("plantId",plantId);
        list = query.list();
        donatePlantInfo = list.get(0);
        list = null;
        return  donatePlantInfo;
    }
    public List<DonatePlantInfo> queryUsersDonates(int userId,int index){
        List<DonatePlantInfo>  list = null;
        Session session = this.sessionFactory.openSession();
        Criteria crit = session.createCriteria(DonatePlantInfo.class)
                .add(Expression.eq("userId",new Integer(userId)));
        crit.setFirstResult(index);
        crit.setMaxResults(10);
        list = crit.list();
        return list;
    }
}
