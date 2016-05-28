package com.hbuas.controller;

import com.hbuas.dao.SNSUserDao;
import com.hbuas.pojo.entity.SNSUserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

/**
 * Created by zss on 2016/5/2.
 */
@Controller
@RequestMapping("/shop")
public class ShopControl {
    @Autowired
    private SNSUserDao snsUserDao;
    @Resource
    private HttpSession session;
    @RequestMapping("/userCenter")
    public String show(ModelMap map){
        String openid = (String)session.getAttribute("openId");
        SNSUserInfo snsUserInfo = snsUserDao.getSNSUserInfo(openid);
        map.addAttribute("user",snsUserInfo);
        return "showInfo.jsp";
    }
    @RequestMapping("/home")
    public String home(ModelMap map){

        return "shop/home.jsp";
    }

}
