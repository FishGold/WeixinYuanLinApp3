package com.hbuas.pojo.entity;

import java.util.Date;

/**
 * Created by zss on 2016/5/27.
 * 订单实体类
 */
public class Order {
    private int orderId;//订单主键id
    private int posting;//快递单号
    private int userid;
    private int receiveAddressId;//收获地址
    private String postingStatus;//订单物流状态
    private String dealStatus;//订单处理的状态 待付款 待收货 待发货 待评价
    private float fare;//运费
    private int wareId;//订单对应的商品id
    private Date beginDate;//下单时间
    private Date endDate;//订单结束时间 有一个默认值下单时间加上14天
    private boolean isValid;//订单是否有效
    private boolean isPaied;//订单是否被支付
}
