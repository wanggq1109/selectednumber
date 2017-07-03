package com.cvssp.selectednumber;

import com.cvssp.selectednumber.common.OrderNumUtils;
import com.cvssp.selectednumber.dto.OrderDTO;
import com.cvssp.selectednumber.service.OrderService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Created by wgq on 2017/7/3.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class OrderTest {

    @Autowired
    OrderService orderService;

    @Test
    public  void summitOrders(){

        OrderDTO dto = new OrderDTO();
        dto.setNumber("183000055");
        dto.setPrePay("N");
        dto.setUserId("001");
        dto.setStatus("unpaid");
        dto.setTotalAmount(1000);
        dto.setTotalSum(1);
        dto.setMobile("18302359800");
        dto.setTradeNo(OrderNumUtils.makeOrderNum());

        orderService.toOrderSuccess(dto);

    }
}
