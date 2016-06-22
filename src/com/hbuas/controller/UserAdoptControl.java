package com.hbuas.controller;
import com.hbuas.dao.AdoptPlantDao;
import com.hbuas.daoImpl.AdoptPlantDaoImpl;
import com.hbuas.pojo.entity.AdoptPlantInfo;
import net.sf.json.JSONArray;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Date;


/**
 * Created by dell on 2016/6/7.
 */
@Controller
@RequestMapping(value = "/adopt",method = RequestMethod.GET)
public class UserAdoptControl {
    @RequestMapping(value = "/doAdopt",method = RequestMethod.POST)
    public void getRequestAboutAdopt(HttpServletRequest req,HttpServletResponse res) throws IOException{
        WebApplicationContext applicationContext = WebApplicationContextUtils.getWebApplicationContext(req.getSession().getServletContext());


        AdoptPlantInfo adoptPlantInfo = new AdoptPlantInfo();
        AdoptPlantDao adoptPlantDao = applicationContext.getBean(AdoptPlantDaoImpl.class);

        String adoptTarget = req.getParameter("plantId");
        java.util.Date date = new java.util.Date();
        adoptPlantInfo.setAdoptDate(new Date(date.getTime()));
        //int userId = ((Integer)request.getSession().getAttribute("userId")).intValue();
        adoptPlantInfo.setAdoptedUserId(3);//记得换成userId
        adoptPlantInfo.setPlantId(Integer.parseInt(adoptTarget));

        boolean result = adoptPlantDao.adoptPlantInfoInsert(adoptPlantInfo);

        adoptPlantInfo = null;
        if(result){
            String[] arr = {"true"};
            JSONArray jsonarray = JSONArray.fromObject(arr);
            res.getWriter().write(jsonarray.toString());
        }
        else{

            String[] arr = {"false"};
            JSONArray jsonarray = JSONArray.fromObject(arr);
            res.getWriter().write(jsonarray.toString());
        }
    }
}
