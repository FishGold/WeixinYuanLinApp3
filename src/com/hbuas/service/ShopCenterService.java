package com.hbuas.service;

import com.hbuas.pojo.entity.shop.ShopUser;

import java.util.Map;

/**
 * Created by zss on 2016/6/10.
 * 商城用户中心 操作接口
 */
public interface ShopCenterService {
    /*将snsUserInfo 和shopUser 信息合并
    * @param id snsuserinfo 表的主键Id
    * @return 用户属性键值对*/
    public Map<String,String> getUserInfo(int id);
    public boolean updateUserInfo(int userId,ShopUser shopUser);
}
