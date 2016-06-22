package com.hbuas.controller;

import com.hbuas.dao.PlantReportDao;
import com.hbuas.pojo.entity.JsonDateValueProcessor;
import com.hbuas.pojo.entity.PlantReportInfo;
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
@RequestMapping(value = "/myReport",method = RequestMethod.GET)
public class MyReportControl {
@Resource
private PlantReportDao plantReportDao;
    @RequestMapping(value = "/main")
    public String returnJsp(ModelMap mm){
        List<PlantReportInfo> list = new ArrayList<PlantReportInfo>();
        //int userId = ((Integer)request.getSession().getAttribute("userId")).intValue();
        list = plantReportDao.queryTenRecords(3,0);
        mm.addAttribute("plants",list);
        return "myReport.jsp";
    }
    @RequestMapping(value = "/get",method = RequestMethod.POST)
    public void returnTenRecords(HttpServletRequest request,HttpServletResponse response)throws IOException{
        String currentPage = request.getParameter("currentPage");
        int index = Integer.parseInt(currentPage);
        //int userId = ((Integer)request.getSession().getAttribute("userId")).intValue();
        List<PlantReportInfo> list = new ArrayList<PlantReportInfo>();
        list = plantReportDao.queryTenRecords(3,index*10);

        JsonConfig jsonConfig = new JsonConfig();
        jsonConfig.setExcludes(new String[]{"handler", "hibernateLazyInitializer"});
        jsonConfig.registerJsonValueProcessor(Date.class,new JsonDateValueProcessor());
        JSONArray jsonArray = JSONArray.fromObject(list,jsonConfig);
        response.getWriter().write(jsonArray.toString());
    }


}
