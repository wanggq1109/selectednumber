package com.cvssp.selectednumber.domain;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by wgq on 2017/6/12.
 * <p>
 * 护照号码信息
 */
@Entity
@Table(name = "T_CVSSP_NUMBER")
public class CvsspNumber extends DomainImpl {

    /**
     * 护照号
     */
    @Column(length = 20)
    private String number;

    /**
     * 保留号
     */
    @Column(length = 20)
    private Integer remain = 0;

    /**
     * onReady    已准备好
     * sold     售出
     * finish   完成
     * lock     冻结
     * unfreeze 解冻
     * abandon  废弃
     */

    @Column(length = 10)
    private String status;


    @OneToMany(mappedBy = "cvsspNumber", cascade = {CascadeType.PERSIST, CascadeType.MERGE}, fetch = FetchType.EAGER)
    private Set<CategoryCvsspNumber> categorys = new HashSet<CategoryCvsspNumber>();

    @ManyToOne
    @JoinColumn(name = "batch")
    private Batch batch;


    /**
     * 号段
     */
    @Column(length = 3)
    private String dnseg;

    /**
     * 一卡通id
     */
    @Column(length = 50)
    private String userId;


    /**
     * 手机号(系统预留)
     */
    @Column(length = 11)
    private String mobile;


    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public Integer getRemain() {
        return remain;
    }

    public void setRemain(Integer remain) {
        this.remain = remain;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDnseg() {
        return dnseg;
    }

    public void setDnseg(String dnseg) {
        this.dnseg = dnseg;
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

    public Batch getBatch() {
        return batch;
    }

    public void setBatch(Batch batch) {
        this.batch = batch;
    }

    public Set<CategoryCvsspNumber> getCategorys() {
        return categorys;
    }

    public void setCategorys(Set<CategoryCvsspNumber> categorys) {
        this.categorys = categorys;
    }
}
