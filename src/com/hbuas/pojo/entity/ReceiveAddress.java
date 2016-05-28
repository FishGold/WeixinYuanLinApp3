package com.hbuas.pojo.entity;

/**
 * Created by zss on 2016/5/27.
 * 收货地址实体类
 */
public class ReceiveAddress {
    private int id;//自动增加的主键id
    private String receiverName;//收获人姓名
    private String telNummer;//联系方式
    private String address;//收获地址
    private String appendDetail;//追加地址
    private boolean isDefault;//是否是默认收获地址
}
