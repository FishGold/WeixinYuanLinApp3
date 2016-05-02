package com.hbuas.test;




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
@WebServlet(name = "Servlet",urlPatterns = "/db")
public class Servlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException,
            IOException {
        WebApplicationContext applicationContext = WebApplicationContextUtils.getWebApplicationContext(getServletContext());

        SessionFactory sessionFactory = (SessionFactory)applicationContext.getBean("sessionFactory");
        System.out.println(sessionFactory);
        System.out.println(sessionFactory.openSession());


    }
}
