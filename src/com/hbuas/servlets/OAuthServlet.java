package com.hbuas.servlets;

import com.hbuas.pojo.WebToken;
import com.hbuas.pojo.entity.SNSUserInfo;
import com.hbuas.utils.CommonUtil;
import com.hbuas.utils.OAuthUtil;
import net.sf.json.JSONObject;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.net.URLDecoder;
import java.net.URLEncoder;

/**
 * Created by ZSS on 2016/4/27.
 */
@WebServlet(name = "OAuthServlet",urlPatterns = "/oauth")
public class OAuthServlet extends HttpServlet {
    private Logger logger = LogManager.getLogger();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String code  = request.getParameter("code");
        String state = request.getParameter("state");
        logger.info("code:"+code);
        logger.info("state:"+state);
        if (code != null && !"".equals(code)){
            String appId = getServletContext().getInitParameter("appId");
            String appSecret = getServletContext().getInitParameter("appSecret");
            JSONObject webTokenJson = OAuthUtil.getWebToken(appId,appSecret,code);
            if (webTokenJson != null){
                String access_token = webTokenJson.getString("access_token");
                String openid = webTokenJson.getString("openid");
                logger.info(access_token);
                logger.info(openid);
                SNSUserInfo userInfo =OAuthUtil.getUserInfo(access_token,openid);
                HttpSession session = request.getSession();
                session.setAttribute("user",userInfo);
                response.sendRedirect("http://www.yunjoke.com"+state);
                return;
            }else {
                logger.error("webTokenJson=null"+"获取webToen失败,重定向error.jsp");
                request.getRequestDispatcher("/WEB-INF/jsp/oauthError.jsp").forward(request,response);
            }

        }
        logger.error("code=null,重定向error.jsp");
        request.getRequestDispatcher("/WEB-INF/jsp/oauthError.jsp").forward(request,response);
    }

}
