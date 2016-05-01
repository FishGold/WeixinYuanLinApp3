package com.hbuas.utils;

import com.hbuas.pojo.WebToken;
import com.hbuas.pojo.entity.SNSUserInfo;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

/**
 * Created by ZSS on 2016/4/27.
 */
public class OAuthUtil {
    public static String userOAthUrl = "https://open.weixin.qq.com/connect/oauth2/authorize?appid=APPID&redirect_uri=REDIRECT_URI&response_type=code&scope=SCOPE&state=STATE#wechat_redirect";
    public static String webTokenUrl  = "https://api.weixin.qq.com/sns/oauth2/access_token?appid=APPID&secret=SECRET&code=CODE&grant_type=authorization_code";
    public static String userInfoUrl = "https://api.weixin.qq.com/sns/userinfo?access_token=ACCESS_TOKEN&openid=OPENID&lang=zh_CN";
    private static Logger logger = LogManager.getLogger();
    public  static JSONObject getWebToken(String  appid,String appSecret,String code){
        String url = webTokenUrl.replaceFirst("APPID",appid)
                .replaceFirst("SECRET",appSecret)
                .replaceFirst("CODE",code);
        System.out.println(url);
        JSONObject jsonObject = null;
        jsonObject = CommonUtil.httpsRequest(url,"GET",null);
        logger.info(jsonObject.toString());
        return jsonObject;
    }
    public static SNSUserInfo getUserInfo(String access_token,String openid){
        SNSUserInfo userInfo = null;
        String url = userInfoUrl.replaceFirst("ACCESS_TOKEN",access_token)
                .replaceFirst("OPENID",openid);
        JSONObject jsonObject = CommonUtil.httpsRequest(url,"GET",null);
        if (jsonObject!=null){
            userInfo = new SNSUserInfo();
            logger.info(jsonObject.toString());
            userInfo.setOpenId(jsonObject.getString("openid"));
            userInfo.setNickname(jsonObject.getString("nickname"));
            userInfo.setCountry(jsonObject.getString("country"));
            userInfo.setCity(jsonObject.getString("city"));
            String sexs;
            int sex = jsonObject.getInt("sex");
            if (sex ==1)
                sexs = "男";
            else if (sex ==2)
                sexs = "女";
            else
                sexs = "未知";
            userInfo.setSex(sexs);
            userInfo.setProvince(jsonObject.getString("province"));
            userInfo.setHeadImgUrl(jsonObject.getString("headimgurl"));
        }
        return  userInfo;
    }

}
