package com.hbuas.controller;

import com.hbuas.dao.DonatePlantDao;
import com.hbuas.dao.SNSUserDao;
import com.hbuas.pojo.entity.DonatePlantInfo;
import com.hbuas.pojo.entity.DonatePlantInfoIncludeUserInfo;
import com.hbuas.pojo.entity.JsonDateValueProcessor;
import com.hbuas.pojo.entity.SNSUserInfo;
import net.sf.json.JSONArray;
import net.sf.json.JsonConfig;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by dell on 2016/6/6.
 */
@Controller
@RequestMapping(value = "/donate",method = RequestMethod.GET)
public class GetDonateInfoOneByTenControl {
    @Resource
    private DonatePlantDao donatePlantDao;
    @Resource
    private SNSUserDao snsUserDao;
    @RequestMapping(value = "/get" ,method = RequestMethod.GET)
    public String returnJsp(HttpServletRequest req,HttpServletResponse res,ModelMap mm) throws IOException{
        List<DonatePlantInfoIncludeUserInfo> infoList = new ArrayList<DonatePlantInfoIncludeUserInfo>();
        infoList = queryOneByTen(0);
        mm.addAttribute("plants",infoList);
        return "donate-market.jsp";
    }
    @RequestMapping(value = "/query" ,method = RequestMethod.POST)
    public void queryTenRecords(HttpServletRequest req,HttpServletResponse res) throws IOException{
        List<DonatePlantInfoIncludeUserInfo> infoList = new ArrayList<DonatePlantInfoIncludeUserInfo>();
        String currentIndex = req.getParameter("currentPage");
        int index = Integer.parseInt(currentIndex);

        infoList = queryOneByTen(index*10);
        JsonConfig jsonConfig = new JsonConfig();
        jsonConfig.setExcludes(new String[]{"handler", "hibernateLazyInitializer"});
        jsonConfig.registerJsonValueProcessor(Date.class,new JsonDateValueProcessor());
        JSONArray jsonArray = JSONArray.fromObject(infoList,jsonConfig);
        res.getWriter().write(jsonArray.toString());
    }

    public List<DonatePlantInfoIncludeUserInfo> queryOneByTen(int currentIndex){
        List<DonatePlantInfo> list = new ArrayList<DonatePlantInfo>();
        List<DonatePlantInfoIncludeUserInfo> infoList = new ArrayList<DonatePlantInfoIncludeUserInfo>();
        list = donatePlantDao.queryTenRecords(currentIndex);
        DonatePlantInfo donatePlantInfo;
        for(int i=0;i<list.size();i++){
            donatePlantInfo = list.get(i);
            int userId = donatePlantInfo.getUserId();
            SNSUserInfo suif = snsUserDao.getSNSUserInfoByUserId(userId);
            String imgUrl = suif.getHeadImgUrl();
            DonatePlantInfoIncludeUserInfo dpiiui = new DonatePlantInfoIncludeUserInfo();
            dpiiui.setId(donatePlantInfo.getId());
            dpiiui.setUserName(donatePlantInfo.getUserName());
            dpiiui.setPhone(donatePlantInfo.getPhone());
            dpiiui.setPlantDesc(donatePlantInfo.getPlantDesc());
            dpiiui.setReason(donatePlantInfo.getReason());
            dpiiui.setPlantName(donatePlantInfo.getPlantName());
            dpiiui.setUserId(donatePlantInfo.getUserId());
            dpiiui.setImgUrl(imgUrl);
            dpiiui.setImage_1(donatePlantInfo.getImage_1());
            dpiiui.setImage_2(donatePlantInfo.getImage_2());
            dpiiui.setImage_3(donatePlantInfo.getImage_3());
            dpiiui.setDonateDate(donatePlantInfo.getDonateDate());
            infoList.add(dpiiui);
        }
        return infoList;
    }


}
