package com.hbuas.test;




import com.hbuas.dao.CartDao;
import com.hbuas.daoImpl.CartDaoImpl;
import com.hbuas.daoImpl.SearchDaoImpl;
import com.hbuas.pojo.entity.shop.PlantCategory;
import com.hbuas.pojo.entity.shop.Ware;
import com.hbuas.service.SearchService;
import com.hbuas.serviceImpl.CategoryServiceImpl;
import com.hbuas.serviceImpl.SearchServiceImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.mapping.Set;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.StandardSocketOptions;
import java.util.HashSet;
import java.util.List;


/**
 * Created by dell-pc on 2015/12/13.
 */
@WebServlet(name = "Servlet",urlPatterns = "/ajax")
public class Servlet extends HttpServlet {
    private Logger logger = LogManager.getLogger();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException,
            IOException {
        WebApplicationContext applicationContext = WebApplicationContextUtils.getWebApplicationContext(getServletContext());
        CartDao cartDao = applicationContext.getBean(CartDaoImpl.class);
        List<Ware> list = cartDao.getShopCartWares(1);
        for(Ware ware :list){
            logger.info(ware.getWareId()+ware.getStore().getName());
        }
    }

}
