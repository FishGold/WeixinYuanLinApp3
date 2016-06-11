package com.hbuas.daoImpl;

import com.hbuas.dao.CartDao;
import com.hbuas.pojo.entity.SNSUserInfo;
import com.hbuas.pojo.entity.shop.Cart;
import com.hbuas.pojo.entity.shop.Ware;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


import java.util.List;

/**
 * Created by zss on 2016/6/11.
 */
@Repository
public class CartDaoImpl implements CartDao {
    @Autowired
    private SessionFactory sessionFactory;
    private Logger logger = LogManager.getLogger();
    @Override
    public List<Ware> getShopCartWares(int userId) {
        Session session = sessionFactory.getCurrentSession();
       //Query query  = session.createQuery("select new SNSUserInfo (id) from SNSUserInfo  s where s.id=:id");
       Query query = session.createQuery("from SNSUserInfo  where id=:id");
       // Query query = session.createQuery("select id from SNSUserInfo where id=:id");
        query.setInteger("id",userId);
        List<SNSUserInfo> list  = query.list();
        if (list.isEmpty())
            return null;
        SNSUserInfo snsUserInfo =list.get(0);
        logger.info(snsUserInfo+" ** "+snsUserInfo.getId());
       Cart cart = snsUserInfo.getCart();
        logger.info("购物车id="+cart.getId());
        logger.info("购车大小"+cart+"**"+cart.getList().size());
        return cart.getList();
    }
}
