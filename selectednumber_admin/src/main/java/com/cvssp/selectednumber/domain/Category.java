package com.cvssp.selectednumber.domain;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;

/**
 * Created by wgq on 2017/6/12.
 */

@Entity
@Table(name = "T_CATEGORY")
public class Category extends DomainImpl {
    /**
     * 类型名称,AABB,ABAB
     */
    private String name;

    /**
     * 策略选号
     * 个性选号
     */
    private String code;

    @OneToMany(mappedBy = "category")
    private List<CategoryCvsspNumber>  numbers;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public List<CategoryCvsspNumber> getNumbers() {
        return numbers;
    }

    public void setNumbers(List<CategoryCvsspNumber> numbers) {
        this.numbers = numbers;
    }
}
