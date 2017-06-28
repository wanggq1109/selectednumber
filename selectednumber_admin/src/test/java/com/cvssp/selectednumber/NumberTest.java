package com.cvssp.selectednumber;

import com.cvssp.selectednumber.dao.NumberCategoryDao;
import com.cvssp.selectednumber.dao.NumberDao;
import com.cvssp.selectednumber.domain.CategoryCvsspNumber;
import com.cvssp.selectednumber.domain.CvsspNumber;
import com.cvssp.selectednumber.service.CvsspNumberCategoryService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
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
    private NumberCategoryDao numberCategoryDao;

    @Autowired
    private CvsspNumberCategoryService cvsspNumberCategoryService;


    @Test
    public void createCategory2Number() {

        List<CvsspNumber> numberList = numberDao.getNumbersList();

        cvsspNumberCategoryService.saveNumberMappingCategory(numberList);


    }

    @Test
    public void query() {

        Page pagelist = numberCategoryDao.findNumberAndCategoryInfo("183","AABB", new PageRequest(0, 5));

        System.out.println(pagelist.getTotalPages() + "-------" + pagelist.getContent().size());

        List list = pagelist.getContent();

        for (int i = 0; i < list.size(); i++) {

            Object[] objArray = (Object[]) list.get(i);

            for (Object obj : objArray) {

                if (obj instanceof CategoryCvsspNumber) {

                    CategoryCvsspNumber categoryCvsspNumber = (CategoryCvsspNumber) obj;

                    System.out.println("---------" + categoryCvsspNumber.getCvsspNumber().getNumber());
                    System.out.println("---------" + categoryCvsspNumber.getCategory().getName());
                    System.out.println("----------" + categoryCvsspNumber.getCategory().getGroupInfo().getPrice());


                }
            }


        }

    }
}