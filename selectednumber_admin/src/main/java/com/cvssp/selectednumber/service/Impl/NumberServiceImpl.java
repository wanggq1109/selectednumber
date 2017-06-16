package com.cvssp.selectednumber.service.Impl;

import com.cvssp.selectednumber.dao.NumberDao;
import com.cvssp.selectednumber.domain.Batch;
import com.cvssp.selectednumber.domain.CvsspNumber;
import com.cvssp.selectednumber.service.NumberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by wgq on 2017/6/16.
 * <p>
 * 护照号业务逻辑层
 */

@Service
public class NumberServiceImpl implements NumberService {

    @Autowired
    private NumberDao numberDao;

    /**
     * 批量存储某批次的号码
     *
     * @param numberlist
     */
    public void BatchAddNumber(List<String> numberlist, Batch batch) {

        List<CvsspNumber> cvsspNumbersList = new ArrayList<CvsspNumber>();

        for (String numberInfo : numberlist) {

            CvsspNumber number = new CvsspNumber();
            number.setBatch(batch);
            number.setDnseg(batch.getDnseg());
            number.setStatus("onReady");
            number.setNumber(numberInfo);
            number.setCreatedTime(new Date());
            cvsspNumbersList.add(number);
        }

        numberDao.save(cvsspNumbersList);

    }


}
