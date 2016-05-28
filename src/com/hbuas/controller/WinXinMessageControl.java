package com.hbuas.controller;

import com.hbuas.service.impl.MessageService;
import com.hbuas.utils.SignUtil;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;


/**
 * Created by zss on 2016/5/2.
 */
@Controller
public class WinXinMessageControl {
    private Logger logger = LogManager.getLogger();
    @Autowired
    private MessageService messageService;
    @Resource
    private HttpServletRequest request;
    @RequestMapping(value = "/check",method = RequestMethod.GET)
    @ResponseBody
    public String SignCheck(){
        String signature = request.getParameter("signature");
        String timestamp = request.getParameter("timestamp");
        String nonce = request.getParameter("nonce");
        String echostr = request.getParameter("echostr");
        //请求校验
        boolean flag =  SignUtil.CheckSignature(signature, timestamp, nonce);
        try{
            //如果校验成功，原样恢复echostr
            if(flag)
                return echostr;
            logger.info("校验成功");
        }catch (Exception e){
            logger.error("校验失败");
        }
        return null;
    }
    @RequestMapping(value = "/check",method = RequestMethod.POST)
    @ResponseBody
    public String messageHandler(){

        return  messageService.processRequest(request);
    }
    //测试
    @RequestMapping(value = "/charset")
    @ResponseBody
    public String message(){
         String mess = "这是中文 this is english 123456 !@##$$";
        return  mess;
    }



}
