package com.hbuas.controller;

import com.hbuas.dao.AdoptPlantDao;
import com.hbuas.dao.DonatePlantDao;
import com.hbuas.pojo.entity.AdoptPlantInfo;
import com.hbuas.pojo.entity.DonatePlantInfo;
import com.hbuas.pojo.entity.JsonDateValueProcessor;
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
 * Created by dell on 2016/6/10.
 */
@Controller
@RequestMapping(value = "/myAdopt",method = RequestMethod.GET)
public class MyAdoptControl {
    @Resource
    private AdoptPlantDao adoptPlantDao;
    @Resource
    private DonatePlantDao donatePlantDao;
    @RequestMapping(value = "/main",method = RequestMethod.GET)
    public String returnJsp(ModelMap mm){
        List<DonatePlantInfo> list = null;
        //int userId = ((Integer)request.getSession().getAttribute("userId")).intValue();
        //list = adoptPlantDao.queryAdoptedPlantInfoByUserId(userId,0);
        list = getInfoByAdopted(3, 0);
        mm.addAttribute("adopts",list);
        return "myAdopt.jsp";
    }
    @RequestMapping(value = "/get",method = RequestMethod.POST)
    public void returnTenRecords(HttpServletRequest request,HttpServletResponse response) throws IOException{
        List<DonatePlantInfo> list = null;
        String currentPage = request.getParameter("currentPage");
        int index = Integer.parseInt(currentPage);
        //int userId = ((Integer)request.getSession().getAttribute("userId")).intValue();
        //list = adoptPlantDao.queryAdoptedPlantInfoByUserId(userId,0);
        list = getInfoByAdopted(3, index * 10);
        JsonConfig jsonConfig = new JsonConfig();
        jsonConfig.setExcludes(new String[]{"handler", "hibernateLazyInitializer"});
        jsonConfig.registerJsonValueProcessor(Date.class,new JsonDateValueProcessor());
        JSONArray jsonArray = JSONArray.fromObject(list,jsonConfig);
        response.getWriter().write(jsonArray.toString());
    }
    @RequestMapping(value = "/query")
    public String getOne(HttpServletRequest request,ModelMap mm){
        String plantId = request.getParameter("id");
        int id = Integer.parseInt(plantId);
        DonatePlantInfo donatePlantInfo = null;
        donatePlantInfo = donatePlantDao.queryPlant(id);
        mm.addAttribute("plant",donatePlantInfo);
        return "myAdoptSingle.jsp";
    }


    public List<DonatePlantInfo> getInfoByAdopted(int userId,int index){
        List<DonatePlantInfo> list = new ArrayList<DonatePlantInfo>();
        List<AdoptPlantInfo> adoptPlantInfos = null;
        DonatePlantInfo donatePlantInfo = null;
        adoptPlantInfos = adoptPlantDao.queryAdoptedPlantInfoByUserId(3,index);
        for(int i=0;i<adoptPlantInfos.size();i++){
            //int userId = ((Integer)request.getSession().getAttribute("userId")).intValue();
            int plantId = adoptPlantInfos.get(i).getPlantId();
            donatePlantInfo = donatePlantDao.queryPlant(plantId);
            list.add(donatePlantInfo);
        }
        return list;
    }
}
