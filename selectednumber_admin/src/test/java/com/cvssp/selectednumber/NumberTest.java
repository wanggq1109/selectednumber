package com.cvssp.selectednumber;

import com.cvssp.selectednumber.common.Constants;
import com.cvssp.selectednumber.dao.NumberDao;
import com.cvssp.selectednumber.domain.CvsspNumber;
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

    @Test
    public void NumberQueryByRegex(){

        List<CvsspNumber> cvsspNumberList = numberDao.getNumbersByTypeRegex(Constants.REGEX_AABB);

        for(CvsspNumber cvsspNumber :cvsspNumberList){

            System.out.println("**********" + cvsspNumber.getNumber());
        }

    }


}
