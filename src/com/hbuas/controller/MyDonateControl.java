package com.hbuas.controller;
import com.hbuas.dao.DonatePlantDao;
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
import java.util.List;
/**
 * Created by dell on 2016/6/10.
 */
@Controller
@RequestMapping(value = "/myDonate",method = RequestMethod.GET)
public class MyDonateControl {
    @Resource
    private DonatePlantDao donatePlantDao;
    @RequestMapping(value = "/main",method = RequestMethod.GET)
    public String returnJsp(ModelMap mm){
        List<DonatePlantInfo> list = null;
        //int userId = ((Integer)request.getSession().getAttribute("userId")).intValue();
        //donatePlantDao.queryUsersDonates(userId,0);
        list = donatePlantDao.queryUsersDonates(3,0);
        mm.addAttribute("donates",list);
        return "myDonate.jsp";
    }
    @RequestMapping(value = "/get",method = RequestMethod.POST)
    public void returnTenRecords(HttpServletRequest request,HttpServletResponse response)throws IOException{
        String currentPage = request.getParameter("currentPage");
        int index = Integer.parseInt(currentPage);
        List<DonatePlantInfo> list = null;
        //int userId = ((Integer)request.getSession().getAttribute("userId")).intValue();
        //donatePlantDao.queryUsersDonates(userId,0);
        list = donatePlantDao.queryUsersDonates(3,index*10);
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
        return "myDonateSingle.jsp";
    }
}
