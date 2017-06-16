package com.cvssp.selectednumber.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Date;

/**
 * Created by wgq on 2017/6/12.
 *
 * 系统通过手机发送消息
 */

@Entity
@Table(name = "T_MESSAGE")
public class Message extends DomainImpl {

    /**
     * 验证码
     */
    @Column(length = 50)
    private String checkpass;

    /**
     * 发送验证码手机号
     */
    @Column(length = 11)
    private String mobile;

    /**
     * 验证时间
     */
    private Date validTime;

    /**
     * 消息标签类
     */
    @Column(length = 10)
    private String tag;

    /**
     * 发送消息数量
     */
    private Integer sendCount;

    /**
     * tag+mobile
     */
    private String uKey;


    public String getCheckpass() {
        return checkpass;
    }

    public void setCheckpass(String checkpass) {
        this.checkpass = checkpass;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public Date getValidTime() {
        return validTime;
    }

    public void setValidTime(Date validTime) {
        this.validTime = validTime;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public Integer getSendCount() {
        return sendCount;
    }

    public void setSendCount(Integer sendCount) {
        this.sendCount = sendCount;
    }

    public String getuKey() {
        return uKey;
    }

    public void setuKey(String uKey) {
        this.uKey = uKey;
    }
}
