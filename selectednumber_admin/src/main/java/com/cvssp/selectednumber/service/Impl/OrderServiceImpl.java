package com.cvssp.selectednumber.service.Impl;

import com.cvssp.selectednumber.dao.NumberDao;
import com.cvssp.selectednumber.dao.OrderDao;
import com.cvssp.selectednumber.domain.CvsspNumber;
import com.cvssp.selectednumber.domain.Order;
import com.cvssp.selectednumber.dto.OrderDTO;
import com.cvssp.selectednumber.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

/**
 * Created by wgq on 2017/6/30.
 */
@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    OrderDao orderDao;

    @Autowired
    NumberDao numberDao;


    @Override
    public List<OrderDTO> getOrderInfoByUserId(String userId, Pageable pageRequest) {
        Page<Order> pageorderList = orderDao.findOrderInfoByUserId(userId, pageRequest);
        List<OrderDTO> orderDTOs = new ArrayList<OrderDTO>();
        for (Order order : pageorderList.getContent()) {
            OrderDTO dto = new OrderDTO();
            dto.setTradeNo(order.getTradeNo());
            dto.setStatus(order.getStatus());
            dto.setAddTime(order.getAddTime());
            dto.setMobile(order.getMobile());
            dto.setPrePay(order.getPrePay());
            dto.setUserId(order.getUserId());
            Set<CvsspNumber> numberSet = order.getCvsspNumbers();
            dto.setTotalAmount(order.getTotalAmount());
            dto.setTotalSum(order.getTotalSum());
            for (CvsspNumber number : numberSet) {
                dto.setNumber(number.getNumber());
            }
            dto.setPageSize(pageorderList.getSize());
            dto.setTotalPage(pageorderList.getTotalPages());
            orderDTOs.add(dto);

        }


        return orderDTOs;
    }

    @Override
    public boolean toOrderSuccess(OrderDTO orderDTO) {

        try {
            Order order = new Order();
            order.setTradeNo(orderDTO.getTradeNo());
            order.setUserId(orderDTO.getUserId());
            order.setMobile(orderDTO.getMobile());
            order.setCreatedTime(new Date());
            order.setTotalSum(orderDTO.getTotalSum());
            order.setTotalAmount(orderDTO.getTotalAmount());
            order.setPrePay(orderDTO.getPrePay());
            order.setAddTime(new Date());
            order.setStatus(orderDTO.getStatus());
            // order.setValidTime(new Date(+1));
            orderDao.save(order);
            CvsspNumber cvsspNumber = numberDao.getNumberObjetByName(orderDTO.getNumber());
            cvsspNumber.setOrderInfo(order);
            cvsspNumber.setMobile(orderDTO.getMobile());
            cvsspNumber.setStatus("sold");
            cvsspNumber.setUserId(orderDTO.getUserId());
            numberDao.save(cvsspNumber);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }


    }
}
