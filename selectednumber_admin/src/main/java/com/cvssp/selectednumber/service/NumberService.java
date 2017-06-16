package com.cvssp.selectednumber.service;

import com.cvssp.selectednumber.domain.Batch;

import java.util.List;

/**
 * Created by wgq on 2017/6/16.
 *
 * 护照号业务逻辑
 */

public interface NumberService {

    /**
     * 批量存储某批次的号码
     * @param numberlist
     */
    public  void  BatchAddNumber(List<String> numberlist,Batch batch);
}
