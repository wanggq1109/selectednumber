package com.cvssp.selectednumber.domain;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by wgq on 2017/6/12.
 *
 * 添加不同类型号码的组
 *
 */
@Entity
@Table(name="T_GROUP")
public class Group extends DomainImpl {

    /**
     * 组名
     */
    @Column(length = 20)
    private String name;

    /**
     * 当前组的价格(单位:分)
     */
    private  int price;


    @OneToMany(mappedBy = "groupInfo", cascade = {CascadeType.PERSIST, CascadeType.MERGE}, fetch = FetchType.EAGER)
    private Set<Category> categories = new HashSet<Category>();

    /**
     * 组value==g01
     */
    @Column(length = 10)
    private String code;

    /**
     * 当前组生效时间
     */
    private Date effectiveTime;

    /**
     * 当前组失效时间
     */
    private Date noeffectiveTime;

    /**
     * 当前组状态:lock,normal
     */
    @Column(length = 10)
    private String status;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Date getEffectiveTime() {
        return effectiveTime;
    }

    public void setEffectiveTime(Date effectiveTime) {
        this.effectiveTime = effectiveTime;
    }

    public Date getNoeffectiveTime() {
        return noeffectiveTime;
    }

    public void setNoeffectiveTime(Date noeffectiveTime) {
        this.noeffectiveTime = noeffectiveTime;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Set<Category> getCategories() {
        return categories;
    }

    public void setCategories(Set<Category> categories) {
        this.categories = categories;
    }
}
