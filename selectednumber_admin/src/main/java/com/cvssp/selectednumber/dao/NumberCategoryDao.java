package com.cvssp.selectednumber.dao;

import com.cvssp.selectednumber.domain.CategoryCvsspNumber;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 * Created by wgq on 2017/6/21.
 */
public interface NumberCategoryDao extends JpaRepository<CategoryCvsspNumber,Long> {


        @Query("FROM CategoryCvsspNumber N,Category C,CvsspNumber M,Group G WHERE N.cvsspNumber=M.id and N.category = C.id and C.groupInfo = G.id and N.category.name=?2 and N.cvsspNumber.dnseg=?1 ")
        Page findNumberAndCategoryInfo(String dnseg, String type,Pageable page);



}
