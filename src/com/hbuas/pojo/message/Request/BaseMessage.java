package com.hbuas.pojo.message.Request;

/**
 * Created by asus on 2015/11/15.
 */
public class BaseMessage {

    private String ToUserName;
    private String FromUserName;
    private long CreateTime;
    private String MsgType;
    private  long MsgId;

    public String getToUserName() {
        return ToUserName;
    }

    public void setToUserName(String toUserName) {
        ToUserName = toUserName;
    }

    public long getMsgId() {
        return MsgId;
    }

    public void setMsgId(long msgId) {
        MsgId = msgId;
    }



    public String getMsgType() {

        return MsgType;
    }

    public void setMsgType(String msgType) {
        MsgType = msgType;
    }



    public long getCreateTime() {

        return CreateTime;
    }

    public void setCreateTime(long createTime) {
        CreateTime = createTime;
    }




    public String getFromUserName() {

        return FromUserName;
    }

    public void setFromUserName(String fromUserName) {
        FromUserName = fromUserName;
    }


}
