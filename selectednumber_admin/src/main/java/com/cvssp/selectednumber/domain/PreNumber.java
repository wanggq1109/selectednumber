package com.cvssp.selectednumber.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Date;

/**
 * Created by wgq on 2017/6/12.
 *
 * 预购号信息
 */
@Entity
@Table(name = "T_PRENUMBER")
public class PreNumber extends DomainImpl {
    /**
     * 预购号
     */
    @Column(length = 20)
    private String number;

    /**
     * use:领用
     * presale:预售
     */

    @Column(length = 10)
    private String status;

    /**
     * 预购时间
     */
    private Date preTime;

    /**
     * 领用时间
     */
    private Date  useTime;


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

    public Date getPreTime() {
        return preTime;
    }

    public void setPreTime(Date preTime) {
        this.preTime = preTime;
    }

    public Date getUseTime() {
        return useTime;
    }

    public void setUseTime(Date useTime) {
        this.useTime = useTime;
    }
}
