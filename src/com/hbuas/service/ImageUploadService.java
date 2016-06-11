package com.hbuas.service;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by zss on 2016/5/29.
 * 文件上传服务组件
 */
public interface ImageUploadService {
    public boolean processUpload(HttpServletRequest request);
}
