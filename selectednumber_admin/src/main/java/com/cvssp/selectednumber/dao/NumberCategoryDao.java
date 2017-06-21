package com.cvssp.selectednumber.dao;

import com.cvssp.selectednumber.domain.CategoryCvsspNumber;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by wgq on 2017/6/21.
 */
public interface NumberCategoryDao extends JpaRepository<CategoryCvsspNumber,Long> {


}
