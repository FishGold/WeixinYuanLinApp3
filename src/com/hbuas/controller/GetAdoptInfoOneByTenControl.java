package com.hbuas.controller;
import com.hbuas.dao.AdoptPlantDao;
import com.hbuas.dao.DonatePlantDao;
import com.hbuas.dao.SNSUserDao;
import com.hbuas.daoImpl.AdoptPlantDaoImpl;
import com.hbuas.daoImpl.DonatePlantDaoImpl;
import com.hbuas.daoImpl.SNSUserDaoImpl;
import com.hbuas.pojo.entity.*;
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
 * Created by dell on 2016/6/9.
 */
@Controller
@RequestMapping(value = "/adopt",method = RequestMethod.GET)
public class GetAdoptInfoOneByTenControl {
    @Resource
    private AdoptPlantDao adoptPlantDao;
    @Resource
    private DonatePlantDao donatePlantDao;
    @Resource
    private SNSUserDao snsUserDao;
    @RequestMapping(value = "/get",method = RequestMethod.GET)
    public String returnJsp(ModelMap mm){
        List<UserPlantDateInfo> list = new ArrayList<UserPlantDateInfo>();
        List<UserPlantDateInfo> list_1 = new ArrayList<UserPlantDateInfo>();
        List<UserPlantDateInfo> list_2 = new ArrayList<UserPlantDateInfo>();
        UserPlantDateInfo userPlantDateInfo = null;
        list = queryOneByTen(0);
        for(int i=0;i<list.size();i++){
            userPlantDateInfo = list.get(i);
            if(i%2==0){
                list_1.add(userPlantDateInfo);
            }
            else{
                list_2.add(userPlantDateInfo);
            }
        }
        mm.addAttribute("adopts_part1",list_1);
        mm.addAttribute("adopts_part2",list_2);
        return "adopt-market.jsp";
    }
    @RequestMapping(value = "/query",method = RequestMethod.POST)
    public void returnTenRecords(HttpServletRequest req,HttpServletResponse res)throws IOException {
        List<UserPlantDateInfo> list = new ArrayList<UserPlantDateInfo>();
        String current = req.getParameter("currentPage");
        int index = Integer.parseInt(current);
        list = queryOneByTen(index*10);
        JsonConfig jsonConfig = new JsonConfig();
        jsonConfig.setExcludes(new String[]{"handler", "hibernateLazyInitializer"});
        jsonConfig.registerJsonValueProcessor(Date.class,new JsonDateValueProcessor());
        JSONArray jsonArray = JSONArray.fromObject(list,jsonConfig);
        res.getWriter().write(jsonArray.toString());
    }
    public List<AdoptPlantInfo> queryAdoptedPlants(int index){
        List<AdoptPlantInfo> list = new ArrayList<AdoptPlantInfo>();
        list = adoptPlantDao.queryAdoptedPlantInfo(index);
        return  list;
    }
    public DonatePlantInfo queryOnePlant(int plantId){
        DonatePlantInfo donatePlantInfo = null;
        donatePlantInfo = donatePlantDao.queryPlant(plantId);
        return donatePlantInfo;
    }
    public SNSUserInfo queryOneUser(int userId){
        SNSUserInfo snsUserInfo = null;

        snsUserInfo = snsUserDao.getSNSUserInfoByUserId(userId);
        return  snsUserInfo;
    }

    public List<UserPlantDateInfo> queryOneByTen(int index){
        List<UserPlantDateInfo> list = new ArrayList<UserPlantDateInfo>();
        List<AdoptPlantInfo> adoptPlantInfos = null;
        adoptPlantInfos = queryAdoptedPlants(0);
        AdoptPlantInfo adoptPlantInfo;
        DonatePlantInfo donatePlantInfo;
        UserPlantDateInfo userPlantDateInfo;
        SNSUserInfo snsUserInfo;
        System.out.println("大小:"+adoptPlantInfos.size());
        for(int i=0;i<adoptPlantInfos.size();i++){
            adoptPlantInfo = adoptPlantInfos.get(i);
            userPlantDateInfo = new UserPlantDateInfo();

            int plantId = adoptPlantInfo.getPlantId();
            int adoptedUserId = adoptPlantInfo.getAdoptedUserId();
            donatePlantInfo = queryOnePlant(plantId);
            snsUserInfo = queryOneUser(adoptedUserId);

            userPlantDateInfo.setHeadImgUrl(snsUserInfo.getHeadImgUrl());
            userPlantDateInfo.setNickname(snsUserInfo.getNickname());
            userPlantDateInfo.setImage_1(donatePlantInfo.getImage_1());
            userPlantDateInfo.setDate(adoptPlantInfo.getAdoptDate());
            list.add(userPlantDateInfo);
        }
        return list;
    }
}
