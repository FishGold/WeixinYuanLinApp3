package com.hbuas.servlets;

import com.hbuas.pojo.entity.SNSUserInfo;
import com.hbuas.utils.OAuthUtil;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.net.URLEncoder;


/**
 * Created by ZSS on 2016/4/27.
 */
@WebServlet(name = "ShopServlet",urlPatterns = "/shop")
public class ShopServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       request.getRequestDispatcher("/WEB-INF/jsp/showInfo.jsp").forward(request,response);
    }
}
