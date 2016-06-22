package com.hbuas.controller;

import com.hbuas.dao.SNSUserDao;
import com.hbuas.pojo.entity.SNSUserInfo;
import com.hbuas.pojo.entity.shop.ShopUser;
import com.hbuas.pojo.entity.shop.Ware;
import com.hbuas.service.ShopCartService;
import com.hbuas.service.ShopCenterService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;

/**
 * Created by zss on 2016/6/10.
 */
@RequestMapping("/shopUserCenter")
@Controller
public class ShopCenterControl {
    @Resource
    private  HttpSession session;
    @Resource
    private SNSUserDao snsUserDao;
    @Autowired
    private ShopCenterService shopCenterService;
    @Autowired
    private ShopCartService shopCartService;
    private Logger logger = LogManager.getLogger();
    /*用户个人中心主页*/
    @RequestMapping("/home")
    public String home(ModelMap map){
        session.setAttribute("userId",new Integer(1));
        Integer integer = (Integer)session.getAttribute("userId");
        int userId = -1;
        if (integer != null)
            userId = integer.intValue();
        SNSUserInfo snsUserInfo = snsUserDao.getSNSUserInfoById(userId);
        map.addAttribute("user",snsUserInfo);
        return "shop/center.jsp";
    }
    /*查看账户资料*/
    @RequestMapping("/myAccount")
    public String myAccount(ModelMap map){
        Integer integer = (Integer)session.getAttribute("userId");
        int userId = -1;
        if (integer != null)
            userId = integer.intValue();
        Map<String,String>  user= shopCenterService.getUserInfo(userId);
        map.addAttribute("user",user);
        return "/shop/showAccount.jsp";
    }
    /*购物车*/
    @RequestMapping("shopCart")
    public String shopCart(ModelMap map){
        Integer integer = (Integer)session.getAttribute("userId");
        int userId = -1;
        if (integer != null)
            userId = integer.intValue();
        List<Ware> list = shopCartService.getShopCartWares(userId);
        map.addAttribute("list",list);
        return "shop/shopCart.jsp";
    }
   /*我的评价*/
    @RequestMapping("/myAssess")
    public String myAssess(){
        return "/shop/myAssess.jsp";
    }
    /*我的收藏*/
    @RequestMapping("/myCollect")
    public String myCollect(){
        return  "shop/myCollect.jsp";
    }
    /*全部订单*/
    @RequestMapping("/allOrder")
    public String allOrder(){
        return  "shop/allOrder.jsp";
    }
    @RequestMapping("/adviseAccount")
    public String adviseAccount(ModelMap map){
        Integer integer = (Integer)session.getAttribute("userId");
        int userId = -1;
        if (integer != null)
            userId = integer.intValue();
        Map<String,String>  user= shopCenterService.getUserInfo(userId);
        map.addAttribute("user",user);
        return "shop/adviseAccount.jsp";
    }
    @RequestMapping(value = "/adviseAccount_form",method = RequestMethod.POST)
    public String adviseAccount_form(@ModelAttribute("shopUser")ShopUser shopUser,ModelMap map){
        Integer integer = (Integer)session.getAttribute("userId");
        int userId = -1;
        if (integer != null)
            userId = integer.intValue();
        boolean re = shopCenterService.updateUserInfo(userId,shopUser);
        map.addAttribute("result",re);
        return "shop/adviseResult.jsp";
    }
}
