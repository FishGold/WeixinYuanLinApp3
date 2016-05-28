package com.hbuas.test;




import com.hbuas.dao.SNSUserDao;
import com.hbuas.daoImpl.SNSUserDaoImpl;
import com.hbuas.pojo.entity.SNSUserInfo;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

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
        snsUserInfo.setCity("zuizhou3123");
        snsUserInfo.setCountry("zhongguo421");
        snsUserInfo.setHeadImgUrl("http://www");
        snsUserInfo.setNickname("zss");
        snsUserInfo.setOpenId("JHFIOSJ3892fjio225725731231");
        snsUserInfo.setProvince("中国湖北");
        snsUserInfo.setSex("男");
        snsUserDao.insertSNSUser(snsUserInfo);
        SNSUserInfo snsUserInfo1 = snsUserDao.getSNSUserInfo("JHFIOSJ3892fjio225725731231");
        logger.info(snsUserInfo1.toString());


    }
}
