package com.cvssp.selectednumber.dao;

import com.cvssp.selectednumber.domain.CvsspNumber;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * Created by wgq on 2017/6/14.
 */
public interface NumberDao extends JpaRepository<CvsspNumber,Long> {

    @Query("FROM CvsspNumber n WHERE n.dnseg=?1")
    List<CvsspNumber> findNumberStateless(String dnseg);
}
