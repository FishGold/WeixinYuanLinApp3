package com.hbuas.daoImpl;

import com.hbuas.dao.DoSumDao;
import com.hbuas.pojo.entity.PlantReportInfo;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by dell on 2016/6/6.
 */
@Repository
public class DoSumDaoImpl implements DoSumDao {
    @Autowired
    private SessionFactory sessionFactory;
    private Logger logger = LogManager.getLogger();
    @Override
    public int returnCount(int userId,String tableName){
        PlantReportInfo plantReportInfo = null;
        Session session = this.sessionFactory.openSession();
        Query query;
        if(tableName.equals("PlantReportInfo")){
            query = session.createQuery("from PlantReportInfo pr where pr.userId=:userId");
            query.setInteger("userId",userId);
            return query.list().size();
        }
        else if(tableName.equals("DonatePlantInfo")){
            query = session.createQuery("from DonatePlantInfo dpi where dpi.userId=:userId");
            query.setInteger("userId",userId);
            return query.list().size();
        }
        else if(tableName.equals("AdoptPlantInfo")){
            query = session.createQuery("from AdoptPlantInfo api where api.adoptedUserId=:userId");
            query.setInteger("userId",userId);
            return query.list().size();
        }
       return 0;
    }
}
