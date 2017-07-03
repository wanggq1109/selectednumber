package com.cvssp.selectednumber.service;

import com.cvssp.selectednumber.dto.OrderDTO;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * Created by wgq on 2017/6/30.
 */
public interface OrderService {

    /**
     * 提交订单
     * @param orderDTO
     * @return
     */
    public  boolean toOrderSuccess(OrderDTO orderDTO);

    /**
     * 显示当前用户的订单信息
     * @param userId
     * @return
     */
    public  List<OrderDTO> getOrderInfoByUserId(String userId, Pageable pageRequest);

}
