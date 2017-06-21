package com.cvssp.selectednumber;

import com.cvssp.selectednumber.dao.CategoryDao;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Created by wgq on 2017/6/19.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class CategoryTest {

    @Autowired
    private CategoryDao categoryDao;

    @Test
    public  void  AddCategory(){



       /* Category category = new Category();
        category.setCreatedTime(new Date());
        category.setCode("clxh");
        category.setName("AABB");
        categoryDao.save(category);*/

    }

}
