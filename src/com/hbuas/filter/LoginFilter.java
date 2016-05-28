package com.hbuas.filter;


import com.hbuas.utils.OAuthUtil;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.*;

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
        String openId = (String)session.getAttribute("openId");
        logger.info("用户经过loginFilter"+openId);
        if (openId== null){
            String appId = req.getServletContext().getInitParameter("appId");
            String redirect_uri = URLEncoder.encode("http://www.yunjoke.com/yuanlin/oauth", "utf-8");
            String state = request.getRequestURI();
            String scope = "snsapi_userinfo";
            String url = OAuthUtil.userOAthUrl.replaceFirst("APPID",appId)
                    .replaceFirst("REDIRECT_URI",redirect_uri)
                    .replaceFirst("SCOPE",scope)
                    .replaceFirst("STATE",state);
            logger.info("用户网页授权");
            response.sendRedirect(url);
        } else
            chain.doFilter(request,response);


    }

    public void init(FilterConfig config) throws ServletException {


    }

}
