package com.cvssp.selectednumber;

import com.alibaba.fastjson.JSON;
import com.cvssp.selectednumber.dao.BatchDao;
import com.cvssp.selectednumber.domain.Batch;
import com.cvssp.selectednumber.service.BatchService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;
import java.util.List;

/**
 * Created by wgq on 2017/6/13.
 */

@RunWith(SpringRunner.class)
@SpringBootTest
public class BatchTest {

    @Autowired
    private BatchDao batchDao;

    @Autowired
    private BatchService batchService;

    private  String DNSEG = "183";

    private  Pageable page = new PageRequest(0,10);

    @Test
    public void selectedBatchSuccess() {

        List<Batch> batch = batchDao.findBatchInfo("183");

        System.out.println(batch.get(0).getCount());


    }

    @Test
    public void saveBatch() {

        Batch batch = new Batch();
        batch.setCount(90);
        batch.setDnseg("183");
        batch.setCreatedTime(new Date());

        batchDao.save(batch);
    }

    @Test
    public void BatchPageData(){

        Page<Batch> batches = batchService.findBatchInfoPage("183",page);

        List list = batches.getContent();

        String jsonStr = JSON.toJSONString(list);
        System.out.println(jsonStr);


    }


}
