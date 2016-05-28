package com.hbuas.test;




import com.hbuas.dao.SNSUserDao;
import com.hbuas.dao.impl.SNSUserDaoImpl;
import com.hbuas.pojo.entity.SNSUserInfo;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.SessionFactory;

import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


/**
 * Created by dell-pc on 2015/12/13.
 */
@WebServlet(name = "Servlet",urlPatterns = "/dbtest")
public class Servlet extends HttpServlet {
    private Logger logger = LogManager.getLogger();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException,
            IOException {
        WebApplicationContext applicationContext = WebApplicationContextUtils.getWebApplicationContext(getServletContext());
        SNSUserDao snsUserDao = applicationContext.getBean(SNSUserDaoImpl.class);

        SNSUserInfo snsUserInfo = new SNSUserInfo();
        snsUserInfo.setCity("zuizhou");
        snsUserInfo.setCountry("zhongguo");
        snsUserInfo.setHeadImgUrl("http://www");
        snsUserInfo.setNickname("zss");
        snsUserInfo.setOpenId("JHFIOSJ3892fjio2");
        snsUserInfo.setProvince("中国湖北");
        snsUserInfo.setSex("男");
        snsUserDao.insertSNSUser(snsUserInfo);
        SNSUserInfo snsUserInfo1 = snsUserDao.getSNSUserInfo("JHFIOSJ3892fjio");
        logger.info(snsUserInfo1.toString());


    }
}
