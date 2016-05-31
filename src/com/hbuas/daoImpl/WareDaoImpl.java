package com.hbuas.daoImpl;

import com.hbuas.dao.WareDao;
import com.hbuas.pojo.entity.shop.PlantCategory;
import com.hbuas.pojo.entity.shop.Ware;
import com.hbuas.pojo.entity.shop.WareClassify;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.*;

/**
 * Created by zss on 2016/5/29.
 */
@Repository
public class WareDaoImpl implements WareDao {
    @Autowired
    private SessionFactory sessionFactory;
    private Logger logger = LogManager.getLogger();
    @Override
    public List<Ware> getWaresByClassifyId(int classifyId, int page, int num) {
        return null;
    }

    @Override
    public List<Ware> getUserLikeWares(int userId, int page, int num) {
        return null;
    }
    /*
     获取最新上架的商品类别号
     @param num 商品类别数量
     @return 商品类别id数组
   * */
    @Override
    public List getNewGround(int num) {
        List list1 = new ArrayList();
        Session session =sessionFactory.getCurrentSession();
        logger.info("sessionFactory依赖注入成功",sessionFactory);
        Query query = session.createQuery("SELECT distinct new Ware(w.categoryId) from Ware w order by wareId desc");
        query.setMaxResults(num);
        query.setFirstResult(0);
        List<Ware> list = query.list();
        logger.info("list是否为空"+list.isEmpty());
        logger.info("查询结果list大小",list.size());
        for (int i=0;i<list.size();i++){
            list1.add(list.get(i).getCategoryId());
            logger.info(list1.get(i).toString());
        }
        logger.info("当前session"+session.hashCode());
        return list1;
    }

    @Override
    public Map<String,List<Ware>> getWaresByCategoryId(int categoryId,  int num) {
        logger.info("sessionFactory依赖注入成功",sessionFactory);
        Session session = sessionFactory.getCurrentSession();
        Map<String,List<Ware>> wareMap = new HashMap<String, List<Ware>>();

        //查询这一类
        PlantCategory plantCategory= (PlantCategory)session.get(PlantCategory.class,categoryId);
        logger.info("查询到了植物分类",plantCategory);
        List<WareClassify> classifyList = plantCategory.getList();
        logger.info("这个分类有"+classifyList.size()+"种商品");
        List<Ware> list = new ArrayList<Ware>();
        for (int i=0;i<classifyList.size()&&i<num;i++){
            list.add(classifyList.get(i).getList().get(0));
        }
        wareMap.put(plantCategory.getName(), list);
        logger.info("当前session"+session.hashCode());
        return wareMap;
    }
}
