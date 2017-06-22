package com.cvssp.selectednumber;

import com.cvssp.selectednumber.dao.NumberDao;
import com.cvssp.selectednumber.domain.CvsspNumber;
import com.cvssp.selectednumber.service.CvsspNumberCategoryService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * Created by wgq on 2017/6/21.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class NumberTest {

    @Autowired
    private NumberDao numberDao;

    @Autowired
    private CvsspNumberCategoryService cvsspNumberCategoryService;


    @Test
    public void createCategory2Number() {

        List<CvsspNumber> numberList = numberDao.getNumbersList();
        /*for(CvsspNumber cvsspNumber :numberList){

            System.out.println("------"+cvsspNumber.getNumber());



        }*/

        cvsspNumberCategoryService.saveNumberMappingCategory(numberList);


    }


}
