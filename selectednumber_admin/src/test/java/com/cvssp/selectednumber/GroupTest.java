package com.cvssp.selectednumber;

import com.cvssp.selectednumber.dao.CategoryDao;
import com.cvssp.selectednumber.dao.GroupDao;
import com.cvssp.selectednumber.domain.Category;
import com.cvssp.selectednumber.domain.Group;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.junit.Test;

import java.util.Date;

/**
 * Created by wgq on 2017/6/20.
 */

@RunWith(SpringRunner.class)
@SpringBootTest
public class GroupTest {

    @Autowired
    private GroupDao groupDao;

    @Autowired
    private CategoryDao categoryDao;

    @Test
    public void saveGroup(){

        Group group = new Group();
        group.setName("g01");
        group.setCode("g01");
        group.setEffectiveTime(new Date());
        group.setNoeffectiveTime(new Date());
        group.setCreatedTime(new Date());
        group.setStatus("normal");
        group.setPrice(1000);
        groupDao.save(group);

    }

    @Test
    public  void saveTypeToGrop(){

        Group group = groupDao.findOne(1L);
        Category category = new Category();
        category.setName("ABAB");
        category.setCode("01");
        category.setCreatedTime(new Date());
        category.setGroupInfo(group);
        categoryDao.save(category);



    }


}
