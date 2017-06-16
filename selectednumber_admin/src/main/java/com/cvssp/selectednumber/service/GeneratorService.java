package com.cvssp.selectednumber.service;

import java.util.List;

/**
 * Created by wgq on 2017/6/14.
 */
public interface GeneratorService {

    /**
     * 查询某号段当前批次需生成的号码数量并同步到号码生成器
     * @param dnseg
     * @return
     */
    public  boolean syschronBatchCount(String dnseg);

    /**
     * 批量生成号码
     * @param dnseg
     * @param maxValue
     * @return
     */
    public List<String> batchGeneratorNumber(String dnseg, Integer maxValue);


    /**
     * 判断是否有号码记录
     * @param dnesg
     * @return
     */
    public boolean isExistNumber(String dnesg);
}
