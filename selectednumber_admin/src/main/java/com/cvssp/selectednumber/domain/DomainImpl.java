package com.cvssp.selectednumber.domain;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by wgq on 2017/6/12.
 */

@MappedSuperclass
public class DomainImpl {
    @Id
    @GeneratedValue
    private  Long id ;

    @Temporal(TemporalType.TIMESTAMP)
    private Date createdTime;



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
    }
}
