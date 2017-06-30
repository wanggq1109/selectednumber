package com.cvssp.selectednumber.dao;

import com.cvssp.selectednumber.domain.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * Created by wgq on 2017/6/19.
 */
public interface CategoryDao extends JpaRepository<Category,Long> {



    @Query("FROM Category c WHERE c.code=?1 ")
    Category findCategoryByname(String code);


    @Query("SELECT C.name FROM Category C")
    List<String>  FindAllCategory();




}
