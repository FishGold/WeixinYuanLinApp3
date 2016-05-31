package com.hbuas.controller;

import com.hbuas.dao.SNSUserDao;
import com.hbuas.pojo.entity.SNSUserInfo;
import com.hbuas.serviceImpl.ShopHomeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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
    @Autowired
    ShopHomeService shopHomeService;
    @Resource
    private HttpSession session;
    /*用户中心*/
    @RequestMapping("/userCenter")
    public String show(ModelMap map){
        String openid = (String)session.getAttribute("openId");
        SNSUserInfo snsUserInfo = snsUserDao.getSNSUserInfo(openid);
        map.addAttribute("user",snsUserInfo);
        return "showInfo.jsp";
    }
    /*主页*/
    @RequestMapping("/home")
    public String home(ModelMap map){
        map.addAttribute("carousels",shopHomeService.getShopCarousel());
        map.addAttribute("wareMap",shopHomeService.getWaresByCategory(2));
        map.addAttribute("likes",shopHomeService.getUserLikeWares(-1));//进入用户并没有登陆，也不知道用户喜欢什么商品。
        return "shop/home.jsp";
    }
   /*商品分类*/
    @RequestMapping("/sorts")
    public String sorts(){
        return null;
    }
    /*推荐商品*/
    @RequestMapping("/recommend")
    public String recommend(){
        return null;
    }
    /*用于处理 猜你喜欢 和 推荐商品ajax请求*/
    @RequestMapping("/guessYouLike")
    @ResponseBody
    public String guessYouLike_json(){
        return null;
    }
    /*热卖商品*/
    public String hosts(){
        return null;
    }
    /*用于处理热卖商品的ajax*/
    public String hosts_json(){
        return null;
    }
}
