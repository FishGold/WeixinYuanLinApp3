package com.hbuas.serviceImpl;

import com.hbuas.dao.ShopUserDao;
import com.hbuas.pojo.entity.shop.ShopUser;
import com.hbuas.service.ShopCenterService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * Created by zss on 2016/6/10.
 */
@Service
public class ShopCenterServiceImpl implements ShopCenterService {
    @Autowired
    private ShopUserDao shopUserDao;
    private Logger logger = LogManager.getLogger();
    @Override
    public Map<String, String> getUserInfo(int id) {
        Map<String,String> map = null;
        if (id >=0){
            map = shopUserDao.getUserInfo(id);
        }

        return map;
    }

    @Override
    public boolean updateUserInfo(int userId, ShopUser shopUser) {
        boolean re= true;
        if (userId == -1)
            re= false;
        else
            re =shopUserDao.updateUserinfo(userId,shopUser);
        return  re;
    }
}
