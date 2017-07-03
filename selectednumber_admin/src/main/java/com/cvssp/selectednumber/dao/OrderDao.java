package com.cvssp.selectednumber.dao;

import com.cvssp.selectednumber.domain.Order;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 * Created by wgq on 2017/6/27.
 */
public interface OrderDao extends JpaRepository<Order,Long> {


    @Query("FROM Order o where o.userId =?1")
    Page findOrderInfoByUserId(String userId,Pageable page);


}
