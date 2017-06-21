package com.cvssp.selectednumber.domain;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

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

    @OneToMany(mappedBy = "category", cascade = {CascadeType.PERSIST, CascadeType.MERGE}, fetch = FetchType.EAGER)
    private Set<CategoryCvsspNumber> numbers = new HashSet<CategoryCvsspNumber>();

    @ManyToOne
    @JoinColumn(name = "groupInfo")
    private Group groupInfo;


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

    public Set<CategoryCvsspNumber> getNumbers() {
        return numbers;
    }

    public void setNumbers(Set<CategoryCvsspNumber> numbers) {
        this.numbers = numbers;
    }

    public Group getGroupInfo() {
        return groupInfo;
    }

    public void setGroupInfo(Group groupInfo) {
        this.groupInfo = groupInfo;
    }
}
