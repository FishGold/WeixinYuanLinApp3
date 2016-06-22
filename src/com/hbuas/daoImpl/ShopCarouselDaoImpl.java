package com.hbuas.daoImpl;

import com.hbuas.dao.ShopCarouselDao;
import com.hbuas.pojo.entity.shop.ShopCarousel;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by zss on 2016/5/29.
 */
@Repository
public class ShopCarouselDaoImpl implements ShopCarouselDao {
    private Logger logger = LogManager.getLogger();
    @Autowired
    private SessionFactory sessionFactory;
    @Override
    public List<ShopCarousel> getShopCarousel() {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("from ShopCarousel");
        List<ShopCarousel> list= query.list();
         logger.info("当前session"+session.hashCode());
        return list;
    }
}
