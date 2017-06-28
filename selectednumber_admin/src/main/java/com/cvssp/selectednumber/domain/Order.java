package com.cvssp.selectednumber.domain;

/**
 * Created by wgq on 2017/6/27.
 */

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "T_ORDER")
public class Order extends DomainImpl {

    /**
     * 订单号
     */
    private String tradeNo;

    /**
     * 总金额
     */
    private Integer totalAmount;


    /**
     * 总数量
     */
    private  Integer totalSum;

    /**
     * 用户下单时间
     */
    private Date addTime;

    /**
     * 用户修改时间
     */
    private Date updateTime;

    /**
     *  预售订单 Y
     *  非预售订单
     */
    private String prePay;

    /**
     * 付款时间
     */
    private Date paidTime;


    /**
     * 有效时间
     */
    private Date validTime;

    /**
     * 支付方式:支付宝,银行卡、微信
     */
    private String paymentthod;


    /**
     * 关联商品(护照号码)
     */

    @OneToMany(mappedBy = "orderInfo", cascade = {CascadeType.PERSIST, CascadeType.MERGE}, fetch = FetchType.EAGER)
    private Set<CvsspNumber> cvsspNumbers = new HashSet<CvsspNumber>();


    private String userId;


    private String mobile;


    public String getTradeNo() {
        return tradeNo;
    }

    public void setTradeNo(String tradeNo) {
        this.tradeNo = tradeNo;
    }

    public Integer getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(Integer totalAmount) {
        this.totalAmount = totalAmount;
    }

    public Integer getTotalSum() {
        return totalSum;
    }

    public void setTotalSum(Integer totalSum) {
        this.totalSum = totalSum;
    }

    public Set<CvsspNumber> getCvsspNumbers() {
        return cvsspNumbers;
    }

    public void setCvsspNumbers(Set<CvsspNumber> cvsspNumbers) {
        this.cvsspNumbers = cvsspNumbers;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }


    public Date getAddTime() {
        return addTime;
    }

    public void setAddTime(Date addTime) {
        this.addTime = addTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getPrePay() {
        return prePay;
    }

    public void setPrePay(String prePay) {
        this.prePay = prePay;
    }

    public Date getPaidTime() {
        return paidTime;
    }

    public void setPaidTime(Date paidTime) {
        this.paidTime = paidTime;
    }

    public Date getValidTime() {
        return validTime;
    }

    public void setValidTime(Date validTime) {
        this.validTime = validTime;
    }

    public String getPaymentthod() {
        return paymentthod;
    }

    public void setPaymentthod(String paymentthod) {
        this.paymentthod = paymentthod;
    }


}
