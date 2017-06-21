package com.cvssp.selectednumber.service;

import com.cvssp.selectednumber.domain.CvsspNumber;

import java.util.List;

/**
 * Created by wgq on 2017/6/21.
 */
public interface CvsspNumberCategoryService {

    /**
     * 保存类型和号码关系
     * @param numberList
     */
    public  void saveNumberMappingCategory(List<CvsspNumber> numberList);
}
