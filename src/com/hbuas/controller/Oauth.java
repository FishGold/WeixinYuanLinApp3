package com.hbuas.controller;

import com.hbuas.dao.SNSUserDao;
import com.hbuas.pojo.entity.SNSUserInfo;
import com.hbuas.utils.OAuthUtil;
import com.sun.xml.internal.ws.api.policy.PolicyResolver;
import net.sf.json.JSONObject;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * Created by zss on 2016/5/2.
 */
@Controller
public class Oauth {
    private Logger logger = LogManager.getLogger();
    @Resource
    private ServletContext servletContext;
    @Resource
    private HttpSession session;
    @Resource
    private SNSUserDao snsUserDao;
    @RequestMapping(value = "/oauth",method = RequestMethod.GET)
    public String oauth(@RequestParam String code,@RequestParam String state){
        logger.info("code:"+code);
        logger.info("state:"+state);
        if (code != null && !"".equals(code)){
            String appId = servletContext.getInitParameter("appId");
            String appSecret = servletContext.getInitParameter("appSecret");
            JSONObject webTokenJson = OAuthUtil.getWebToken(appId, appSecret, code);
            if (webTokenJson != null){
                String access_token = webTokenJson.getString("access_token");
                String openid = webTokenJson.getString("openid");
                logger.info(access_token);
                logger.info(openid);
                SNSUserInfo userInfo =OAuthUtil.getUserInfo(access_token,openid);
               boolean result =  snsUserDao.insertSNSUser(userInfo);
                if (result == true){
                    session.setAttribute("openid",openid);
                    return  "redirect:http://www.yunjoke.com"+state;
                }else {
                    logger.error("用户插入数据库时错误！");
                    return  "oauthError.jsp";
                }


            }else {
                logger.error("webTokenJson=null"+"获取webToen失败,重定向error.jsp");
                return  "oauthError.jsp";
            }

        }
        logger.error("code=null,重定向error.jsp");

        return  "oauthError.jsp";

    }
}
