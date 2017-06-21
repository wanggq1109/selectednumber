package com.cvssp.selectednumber;


import com.cvssp.selectednumber.common.Constants;
import com.cvssp.selectednumber.dao.BatchDao;
import com.cvssp.selectednumber.dao.GeneratorDao;
import com.cvssp.selectednumber.domain.Batch;
import com.cvssp.selectednumber.domain.CvsspNumber;
import com.cvssp.selectednumber.domain.Generator;
import com.cvssp.selectednumber.service.GeneratorService;
import com.cvssp.selectednumber.service.NumberService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * Created by wgq on 2017/6/14.
 */

@RunWith(SpringRunner.class)
@SpringBootTest
public class GeneratorNumberTest {


    @Autowired
    GeneratorService generatorService;

    @Autowired
    GeneratorDao generatorDao;

    @Autowired
    NumberService numberService;

    @Autowired
    BatchDao batchDao;


    @Test
    public void QueryMaxValue() {

       /* Long maxValue = generatorDao.getMaxValue("183");*/
        Generator generator = generatorDao.FindGeneratorInfo("183");

        if (generator != null) {

            System.out.println("当前号段的尾号最大序列号-----" + generator.getMaxValue());

        }


    }

   /* @Test
    public void generatorInfoSave(){

        Generator generator = new Generator();
        generator.setCreatedTime(new Date());
        generator.setDnseg("183");
        generator.setMaxValue(200);
        generatorDao.save(generator);


    }*/





    @Test
    public void synchronizedBatchCountToGenerator() {

        String dnseg = "183";

        boolean sysnsuccess = generatorService.syschronBatchCount(dnseg);

        if (sysnsuccess) {
            Generator generator = generatorDao.FindGeneratorInfo(dnseg);
            List<String> numberlist = generatorService.batchGeneratorNumber("183", generator.getMaxValue());
            Batch batch = batchDao.findOne(generator.getBatchNumber());
            numberService.BatchAddNumber(numberlist,batch);
        }


    }

    @Test
    public  void QueryNumbersByType(){

        String type = Constants.REGEX_AABB;

        List<CvsspNumber> numbersList = numberService.findCvsspNumbersByCategory(type);

        for(CvsspNumber cvsspNumber :numbersList){

            System.out.println("号码************"+cvsspNumber.getNumber());



        }

    }
}



