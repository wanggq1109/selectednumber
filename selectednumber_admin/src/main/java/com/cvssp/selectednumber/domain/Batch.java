package com.cvssp.selectednumber.domain;

import javax.persistence.*;
import java.util.List;

/**
 * Created by wgq on 2017/6/12.
 * <p>
 * 护照号生成批次
 */
@Entity
@Table(name = "T_BATCH")
public class Batch extends DomainImpl {

    /**
     * 当前批次下生成号码的总数量
     */
    private Integer count = 0;

    /**
     * 当前批次售出数量
     */
    private Integer saleCount = 0;



    @OneToMany(mappedBy = "batch" ,cascade=CascadeType.ALL,fetch= FetchType.LAZY)
    private List<CvsspNumber> cvsspNumbers;


    /**
     * 冻结数量
     */
    private Integer lockCount = 0;


    /**
     * onReady  已准备好
     * sold     售出
     * lock     冻结
     * unFreeze 解冻
     * abandon  废弃
     */
    @Column(length = 10)
    private String status = "onReady";

    /**
     * 废弃数量
     */
    private Integer abandonCount = 0;


    /**
     * 号段
     */
    @Column(length = 3)
    private String dnseg;


    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public Integer getSaleCount() {
        return saleCount;
    }

    public void setSaleCount(Integer saleCount) {
        this.saleCount = saleCount;
    }

    public Integer getLockCount() {

        return lockCount;
    }

    public void setLockCount(Integer lockCount) {
        this.lockCount = lockCount;
    }

    public String getStatus() {

        return status;
    }

    public void setStatus(String status) {

        this.status = status;
    }

    public Integer getAbandonCount() {
        return abandonCount;
    }

    public void setAbandonCount(Integer abandonCount) {
        this.abandonCount = abandonCount;
    }

    public String getDnseg() {
        return dnseg;
    }

    public void setDnseg(String dnseg) {

        this.dnseg = dnseg;
    }

    public List<CvsspNumber> getCvsspNumbers() {
        return cvsspNumbers;
    }

    public void setCvsspNumbers(List<CvsspNumber> cvsspNumbers) {
        this.cvsspNumbers = cvsspNumbers;
    }
}
