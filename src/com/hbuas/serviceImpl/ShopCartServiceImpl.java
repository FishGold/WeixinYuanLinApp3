package com.hbuas.serviceImpl;

import com.hbuas.dao.CartDao;
import com.hbuas.pojo.entity.shop.ShopUser;
import com.hbuas.pojo.entity.shop.Ware;
import com.hbuas.service.ShopCartService;
import com.hbuas.service.ShopCenterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * Created by zss on 2016/6/11.
 */
@Service
public class ShopCartServiceImpl implements ShopCartService{
    @Autowired
     private CartDao cartDao;
    @Override
    public List<Ware> getShopCartWares(int userId) {
        if (userId == -1){
            return null;
        }
        else
        return cartDao.getShopCartWares(userId);
    }
}
