package com.cvssp.selectednumber.dto;

import java.util.Date;

/**
 * Created by wgq on 2017/7/3.
 */
public class OrderDTO {

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
     *  预售订单 Y
     *  非预售订单
     */
    private String prePay;

    /**
     * 付款时间
     */
    private Date paidTime;

    /**
     * 订单状态
     *
     * unpaid 待支付
     * paid   已支付
     */
    private String status;


    /**
     * 有效时间
     */
    private Date validTime;

    /**
     * 支付方式:支付宝,银行卡、微信
     */
    private String paymentthod;

    /**
     * 用户id
     */
    private String userId;


    private String mobile;

    /**
     * 护照号
     */
    private String number;

    /**
     * 订单创建时间
     */
    private Date addTime;


    private Integer pageSize;


    private Integer totalPage;


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

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getAddTime() {
        return addTime;
    }

    public void setAddTime(Date addTime) {
        this.addTime = addTime;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(Integer totalPage) {
        this.totalPage = totalPage;
    }
}
