package com.hbuas.dao;

import com.hbuas.pojo.entity.SNSUserInfo;

/**
 * Created by zss on 2016/5/26.
 */
public interface SNSUserDao {
    public boolean insertSNSUser(SNSUserInfo snsUserInfo);
    public SNSUserInfo getSNSUserInfo(String openid);
}
