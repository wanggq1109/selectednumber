package com.cvssp.selectednumber.service;

import com.cvssp.selectednumber.domain.Batch;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * Created by wgq on 2017/6/16.
 */
public interface BatchService {

    public Page<Batch> findBatchInfoPage(String dnseg,Pageable pageRequest);

}
