package com.cvssp.selectednumber.dao;

import com.cvssp.selectednumber.domain.Batch;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;


/**
 * Created by wgq on 2017/6/13.
 */
public interface BatchDao extends JpaRepository<Batch,Long> {

    @Query("FROM Batch b WHERE b.dnseg=?1 and b.status='onReady' order by b.createdTime desc")
    List<Batch> findBatchInfo(String dnseg);






}
