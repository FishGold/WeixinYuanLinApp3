package com.hbuas.controller;
import com.hbuas.dao.DoSumDao;
import com.hbuas.dao.SNSUserDao;
import com.hbuas.pojo.entity.SNSUserInfo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 * Created by dell on 2016/6/6.
 */
/*
* 个人面板，此处只是查询用户的头像和活跃度的三个参数
*
*
*
* */
@Controller
@RequestMapping(value = "/person" , method = RequestMethod.GET)
public class PersonMainControl {

    @Resource
    private SNSUserDao snsUserDao;
    @Resource
    private DoSumDao dsd;

    @RequestMapping(value = "/panel" ,method = RequestMethod.GET)
    public String returnPersonPanel(HttpServletResponse response,HttpServletRequest request,ModelMap mm){
        //int userId = ((Integer)request.getSession().getAttribute("userId")).intValue();
        SNSUserInfo suif = snsUserDao.getSNSUserInfoByUserId(3);//注意修改为userId

        mm.addAttribute("picUrl",suif.getHeadImgUrl());

        int count_1= dsd.returnCount(3,"PlantReportInfo");
        int count_2= dsd.returnCount(3,"DonatePlantInfo");
        int count_3 = dsd.returnCount(3,"AdoptPlantInfo");
        mm.addAttribute("liveNumber",""+(count_1+count_2+count_3));
        return "individual-area.jsp";
    }
}
