package com.cvssp.selectednumber.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created by wgq on 2017/6/12.
 * <p>
 * 号码生成器
 */

@Entity
@Table(name = "T_GENERATOR")
public class Generator extends DomainImpl {

    /**
     * 号段
     */
    @Column(length = 3 , unique=true)
    private String dnseg;

    /**
     * 当前号段的号码最大值
     */
    private Integer maxValue;

    /**
     * 某号段当前号码值
     */
    private Integer currentCount = 0;


    public String getDnseg() {
        return dnseg;
    }

    public void setDnseg(String dnseg) {
        this.dnseg = dnseg;
    }

    public Integer getMaxValue() {
        return maxValue;
    }

    public void setMaxValue(Integer maxValue) {
        this.maxValue = maxValue;
    }

    public Integer getCurrentCount() {
        return currentCount;
    }

    public void setCurrentCount(Integer currentCount) {
        this.currentCount = currentCount;
    }
}
