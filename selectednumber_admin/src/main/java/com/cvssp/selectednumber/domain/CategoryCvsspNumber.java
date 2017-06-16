package com.cvssp.selectednumber.domain;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Created by wgq on 2017/6/12.
 * 类型和护照号多对多中间数据实体表
 */

@Entity
@Table(name = "T_CATEGROY_NUMBER")
public class CategoryCvsspNumber extends  DomainImpl{

    @ManyToOne
    private Category category;

    @ManyToOne
    private CvsspNumber cvsspNumber;


    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public CvsspNumber getCvsspNumber() {
        return cvsspNumber;
    }

    public void setCvsspNumber(CvsspNumber cvsspNumber) {
        this.cvsspNumber = cvsspNumber;
    }
}
