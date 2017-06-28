package com.cvssp.selectednumber.dao;

import com.cvssp.selectednumber.domain.Order;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by wgq on 2017/6/27.
 */
public interface OrderDao extends JpaRepository<Order,Long> {
}
