package com.cvssp.selectednumber.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.cvssp.selectednumber.common.AmountUtils;
import com.cvssp.selectednumber.common.OrderNumUtils;
import com.cvssp.selectednumber.dao.BatchDao;
import com.cvssp.selectednumber.dao.CategoryDao;
import com.cvssp.selectednumber.dao.NumberCategoryDao;
import com.cvssp.selectednumber.domain.CategoryCvsspNumber;
import com.cvssp.selectednumber.dto.CategoryDTO;
import com.cvssp.selectednumber.dto.MessageDTO;
import com.cvssp.selectednumber.dto.NumberInfo;
import com.cvssp.selectednumber.dto.OrderDTO;
import com.cvssp.selectednumber.service.NumberService;
import com.cvssp.selectednumber.service.OrderService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wgq on 2017/6/26.
 */
@RestController
@RequestMapping("/selectedNum")
public class SelectedNumController {

    @Autowired
    private NumberCategoryDao numberCategoryDao;

    @Autowired
    private BatchDao batchDao;

    @Autowired
    private CategoryDao categoryDao;

    @Autowired
    NumberService numberService;

    @Autowired
    OrderService orderService;


    /**
     * 初始化类型和号段用于H5展示
     *
     * @return
     */
    @RequestMapping(value = "/index", method = RequestMethod.GET)
    @ApiOperation("初始化页面号段和号码类型")
    public List<CategoryDTO> InitCategoryQueryInfo() {

        List<CategoryDTO> results = new ArrayList<CategoryDTO>();
        CategoryDTO categoryDTO = new CategoryDTO();
        List<String> categoryList = categoryDao.FindAllCategory();
        List<String> batchList = batchDao.findAllDnseg();
        categoryDTO.setTypeList(categoryList);
        categoryDTO.setDnsengList(batchList);
        results.add(categoryDTO);

        return results;

    }


    /**
     * 提交订单
     *
     * @param requestBody
     * @return
     */
    @RequestMapping(value = "/toOrder", method = RequestMethod.POST)
    @ApiOperation("提交购买订单信息")
    public MessageDTO toOrder(@ApiParam("json对象")@RequestBody String requestBody) {

        MessageDTO messageDTO = new MessageDTO();

        try {
            JSONObject json = (JSONObject) JSON.parse(requestBody);
            String mobile = (String) json.get("mobile");
            String userId = (String) json.get("userId");
            String number = (String) json.get("number");
            String totalSum = (String) json.get("totalSum");
            String totalAmount = (String) json.get("totalAmount");
            String prePay = (String) json.get("prePay");


            String tradeNo = OrderNumUtils.makeOrderNum();
            OrderDTO dto = new OrderDTO();
            dto.setMobile(mobile);
            dto.setUserId(userId);
            dto.setNumber(number);
            dto.setTotalSum(Integer.valueOf(totalSum));
            dto.setTradeNo(tradeNo);
            dto.setPrePay(prePay);
            dto.setTotalAmount(Integer.valueOf(AmountUtils.changeY2F(totalAmount)));

            orderService.toOrderSuccess(dto);
            messageDTO.setCode("0");
            messageDTO.setMsg("SUCCESS");
            messageDTO.setContent("tradeNo:" + tradeNo);
        } catch (NumberFormatException e) {

            messageDTO.setCode("1");
            messageDTO.setMsg("false");
            e.printStackTrace();

        }


        return messageDTO;
    }

    /**
     * 随机选取号码
     *
     * @return
     */
    @GetMapping("/radomNum")
    @ApiOperation("随机选取号码")
    public NumberInfo selectedRadom() {

        NumberInfo numberInfo = new NumberInfo();
        String number = numberService.selected2RadomNO();
        numberInfo.setPrice("1000");
        numberInfo.setType("normal");
        numberInfo.setNumber(number);
        return numberInfo;

    }


    /**
     * 特定策略选取中意号码
     *
     * @param dnseg
     * @param numberType
     * @param page
     * @return
     */
    @GetMapping("/{dnseg}/{numberType}")
    @ApiOperation("特殊选号")
    public List<NumberInfo> query(@ApiParam("号段")@PathVariable String dnseg, @ApiParam("号码类型")@PathVariable String numberType,@ApiParam("分页") @PageableDefault(size = 10) Pageable page) {

        List<NumberInfo> numberInfos = new ArrayList<NumberInfo>();
        Page pagelist = numberCategoryDao.findNumberAndCategoryInfo(dnseg, numberType, page);
        List list = pagelist.getContent();
        for (int i = 0; i < list.size(); i++) {
            Object[] objArray = (Object[]) list.get(i);
            for (Object obj : objArray) {
                if (obj instanceof CategoryCvsspNumber) {
                    CategoryCvsspNumber categoryCvsspNumber = (CategoryCvsspNumber) obj;
                    NumberInfo numberInfo = new NumberInfo();
                    numberInfo.setNumber(categoryCvsspNumber.getCvsspNumber().getNumber());
                    numberInfo.setType(categoryCvsspNumber.getCategory().getName());
                    numberInfo.setPrice(String.valueOf(categoryCvsspNumber.getCategory().getGroupInfo().getPrice()));
                    numberInfos.add(numberInfo);
                }
            }

        }
        return numberInfos;
    }


    /**
     * 显示当前用户的订单
     * @param userId
     * @return
     */
    @RequestMapping(value = "/showOrders/{userId}",method = RequestMethod.GET)
    @ApiOperation("显示当前用户订单")
    public  List<OrderDTO> showOrderInfoList(@ApiParam("用户id") @PathVariable String userId,@PageableDefault(size = 10) Pageable page){

        List<OrderDTO> orderDTOList =  orderService.getOrderInfoByUserId(userId, page);

        return orderDTOList;
    }

}


