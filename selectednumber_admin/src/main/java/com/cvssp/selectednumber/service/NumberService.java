package com.cvssp.selectednumber.service;

import com.cvssp.selectednumber.domain.Batch;
import com.cvssp.selectednumber.domain.CvsspNumber;

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


    /**
     * 根据类型查找匹配的号码
     * @param type
     * @return
     */
    public List<CvsspNumber> findCvsspNumbersByCategory(String type);


    /**
     * 过滤组合号码
     * @param number
     * @return
     */
    public  String getNumberType(String number);



    /**
     * 过滤特殊号码
     *
     * @param code
     * @param number
     * @return
     */
    public  String SpecialNumber(String code, String number);


    /**
     * 获取号码最终的类型
     * @param cvsspNumber
     * @return
     */
    public  String findAllNumberType(CvsspNumber cvsspNumber);


    /**
     * 随机选取号码
     * @return
     */
    public String selected2RadomNO();
}
