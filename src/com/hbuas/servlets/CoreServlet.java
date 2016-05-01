package com.hbuas.servlets;

import com.hbuas.utils.SignUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by 王成 on 2015/11/11.
 * 2015/12/20 改动
 */

@WebServlet(name = "core",urlPatterns = "/check")
//CoreServlet是一个核心的公共的请求的处理与相应类
public class CoreServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
         //doPost()用于处理微信服务器发送过来的 各种类型的消息
      //将请求的，响应的编码均设置成utf8字
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");

        //接收参数：微信加密签名，时间戳，随机数
        String signature = request.getParameter("signature");
        String timestamp = request.getParameter("timestamp");
        String nonce = request.getParameter("nonce");



        //请求校验
       PrintWriter out = response.getWriter();
        boolean flag =  SignUtil.CheckSignature(signature, timestamp, nonce);
        //如果校验成功
        if(flag) {
            //调用核心服务类接收程序处理请求
            String respXml = CoreService.processRequest(request);
            out.print(respXml);//这个语句是发送给微信服务器的
            System.out.println(respXml);//这个是显示到我的本地服务器的控制台的
        }

        out.close();
    }


    //该方法以后都不会再用了
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //doGet()方法用于请求的校验
        // response.setContentType("text/html");这里的返回的类型不可以随便的更改
        String signature = request.getParameter("signature");
        String timestamp = request.getParameter("timestamp");
        String nonce = request.getParameter("nonce");
        String echostr = request.getParameter("echostr");
        //请求校验
        boolean flag =  SignUtil.CheckSignature(signature, timestamp, nonce);
        PrintWriter out = response.getWriter();
        //如果校验成功，原样恢复echostr
        if(flag) out.print(echostr);
        out.close();
    }
}
