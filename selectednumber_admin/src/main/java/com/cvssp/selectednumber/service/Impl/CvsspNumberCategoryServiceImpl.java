package com.cvssp.selectednumber.service.Impl;

import com.cvssp.selectednumber.dao.CategoryDao;
import com.cvssp.selectednumber.dao.NumberCategoryDao;
import com.cvssp.selectednumber.dao.NumberDao;
import com.cvssp.selectednumber.domain.Category;
import com.cvssp.selectednumber.domain.CategoryCvsspNumber;
import com.cvssp.selectednumber.domain.CvsspNumber;
import com.cvssp.selectednumber.service.CvsspNumberCategoryService;
import com.cvssp.selectednumber.service.NumberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * Created by wgq on 2017/6/21.
 */
@Service
public class CvsspNumberCategoryServiceImpl implements CvsspNumberCategoryService {

    @Autowired
    private NumberCategoryDao numberCategoryDao;

    @Autowired
    private NumberService numberService;

    @Autowired
    private CategoryDao categoryDao;


    @Autowired
    private NumberDao numberDao;

    /**
     * 保存类型和号码关系
     *
     * @param numberList
     */
    @Override
    public void saveNumberMappingCategory(List<CvsspNumber> numberList) {

        for (CvsspNumber cvsspNumber : numberList) {

            String numberType = numberService.findAllNumberType(cvsspNumber);

            if (!numberType.equals("normal")){
                CategoryCvsspNumber categoryCvsspNumber = new CategoryCvsspNumber();
                categoryCvsspNumber.setCvsspNumber(cvsspNumber);
                cvsspNumber.setStatus("finish");

                Category category = categoryDao.findCategoryByname(numberType);
                categoryCvsspNumber.setCategory(category);
                categoryCvsspNumber.setCreatedTime(new Date());
                numberCategoryDao.save(categoryCvsspNumber);
                numberDao.save(cvsspNumber);
            }


        }


    }
}
