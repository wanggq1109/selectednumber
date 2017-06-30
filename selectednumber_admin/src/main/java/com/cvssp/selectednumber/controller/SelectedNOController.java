package com.cvssp.selectednumber.controller;

import com.cvssp.selectednumber.dao.BatchDao;
import com.cvssp.selectednumber.dao.CategoryDao;
import com.cvssp.selectednumber.dao.NumberCategoryDao;
import com.cvssp.selectednumber.domain.CategoryCvsspNumber;
import com.cvssp.selectednumber.dto.CategoryDTO;
import com.cvssp.selectednumber.dto.NumberInfo;
import com.cvssp.selectednumber.service.NumberService;
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
public class SelectedNOController {

    @Autowired
    private NumberCategoryDao numberCategoryDao;

    @Autowired
    private BatchDao batchDao;

    @Autowired
    private CategoryDao categoryDao;

    @Autowired
    NumberService numberService;


    /**
     * 初始化类型和号段用于H5展示
     * @return
     */
    @RequestMapping(value = "/index", method = RequestMethod.GET)
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
     * @param userId
     * @param mobile
     * @param number
     * @return
     */
    @RequestMapping(value = "/toOrder",method = RequestMethod.POST)
    public String toOrder(String userId,String mobile,String number){




        return  "success";
    }

    /**
     * 随机选取号码
     * @return
     */
    @GetMapping("/radomNum")
    public  NumberInfo selectedRadom(){

        NumberInfo numberInfo = new NumberInfo();
        String number = numberService.selected2RadomNO();
        numberInfo.setPrice("1000");
        numberInfo.setType("normal");
        numberInfo.setNumber(number);
        return numberInfo;

    }


    /**
     * 查询中意的号码
     *
     * @param dnseg
     * @param numberType
     * @param page
     * @return
     */
    @GetMapping("/{dnseg}/{numberType}")
    public List<NumberInfo> query(@PathVariable String dnseg, @PathVariable String numberType, @PageableDefault(size = 10) Pageable page) {

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

}


