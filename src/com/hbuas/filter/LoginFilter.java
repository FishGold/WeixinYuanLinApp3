package com.hbuas.filter;

import com.hbuas.pojo.entity.SNSUserInfo;
import com.hbuas.utils.OAuthUtil;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.net.URLEncoder;

/**
 * Created by ZSS on 2016/4/28.
 */
public class LoginFilter implements Filter {
    private Logger logger = LogManager.getLogger();
    public void destroy() {

    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest request = (HttpServletRequest)req;
        HttpServletResponse response = (HttpServletResponse)resp;
        HttpSession session = request.getSession();
        SNSUserInfo snsUserInfo = (SNSUserInfo)session.getAttribute("user");
        if (snsUserInfo == null){
            String appId = req.getServletContext().getInitParameter("appId");
            String redirect_uri = URLEncoder.encode("http://www.yunjoke.com/yuanlin/oauth", "utf-8");
            String state = request.getRequestURI();
            String scope = "snsapi_userinfo";
            String url = OAuthUtil.userOAthUrl.replaceFirst("APPID",appId)
                    .replaceFirst("REDIRECT_URI",redirect_uri)
                    .replaceFirst("SCOPE",scope)
                    .replaceFirst("STATE",state);
            logger.error(url);
            response.sendRedirect(url);
        } else
            chain.doFilter(request,response);


    }

    public void init(FilterConfig config) throws ServletException {


    }

}
