package com.cvssp.selectednumber.service.Impl;

import com.cvssp.selectednumber.dao.BatchDao;
import com.cvssp.selectednumber.domain.Batch;
import com.cvssp.selectednumber.service.BatchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;

/**
 * Created by wgq on 2017/6/16.
 * <p>
 * 批次业务处理接口
 */

@Service
public class BatchServiceImpl implements BatchService {

    @Autowired
    private BatchDao batchDao;

    /**
     * 某号段查询当前批次的分页数据
     *
     * @param dnseg
     * @param pageRequest
     * @return
     */
    public Page<Batch> findBatchInfoPage(String dnseg, Pageable pageRequest) {

        Pageable pageable = new PageRequest(pageRequest.getPageNumber(),pageRequest.getPageSize(), new Sort(Sort.Direction.DESC, "id"));
        Batch batch = new Batch();
        batch.setDnseg(dnseg);
        batch.setStatus("onReady");

        ExampleMatcher matcher = ExampleMatcher.matching()
                .withIgnorePaths("saleCount","lockCount","abandonCount","count");


        Example<Batch> example = Example.of(batch,matcher);

        Page<Batch> batches = batchDao.findAll(example, pageable);

        return batches;


    }

}
