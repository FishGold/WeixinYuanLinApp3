package com.hbuas.pojo;

/**
 * Created by 王成 on 2015/11/21.
 */
public class Token {
    //接口访问凭证
    private String accessToken;
    //凭证有效期
    private int expiresIn;

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public int getExpiresIn() {
        return expiresIn;
    }

    public void setExpiresIn(int expiresIn) {
        this.expiresIn = expiresIn;
    }
}
