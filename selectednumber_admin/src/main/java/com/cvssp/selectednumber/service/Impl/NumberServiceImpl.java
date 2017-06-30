package com.cvssp.selectednumber.service.Impl;

import com.cvssp.selectednumber.dao.NumberDao;
import com.cvssp.selectednumber.domain.Batch;
import com.cvssp.selectednumber.domain.CvsspNumber;
import com.cvssp.selectednumber.service.NumberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

/**
 * Created by wgq on 2017/6/16.
 * <p>
 * 护照号业务逻辑层
 */

@Service
public class NumberServiceImpl implements NumberService {

    @Autowired
    private NumberDao numberDao;

    /**
     * 批量存储某批次的号码
     *
     * @param numberlist
     */
    public void BatchAddNumber(List<String> numberlist, Batch batch) {

        List<CvsspNumber> cvsspNumbersList = new ArrayList<CvsspNumber>();
        for (String numberInfo : numberlist) {
            CvsspNumber number = new CvsspNumber();
            number.setBatch(batch);
            number.setDnseg(batch.getDnseg());
            number.setStatus("onReady");
            number.setNumber(numberInfo);
            number.setCreatedTime(new Date());
            cvsspNumbersList.add(number);
        }
        numberDao.save(cvsspNumbersList);

    }

    /**
     * 根据类型查找匹配的号码
     *
     * @param regex
     * @return
     */
    public List<CvsspNumber> findCvsspNumbersByCategory(String regex) {
        CvsspNumber cvsspNumbernumber = new CvsspNumber();
        cvsspNumbernumber.setStatus("onReady");
        // cvsspNumbernumber.setMobile(regex);
        cvsspNumbernumber.setNumber(regex);
        ExampleMatcher matcher = ExampleMatcher.matching().withMatcher("cvsspNumbernumber.number", ExampleMatcher.GenericPropertyMatchers.regex())
                .withIgnorePaths("remain");
        Example<CvsspNumber> example = Example.of(cvsspNumbernumber, matcher);
        List<CvsspNumber> cvsspNumbersList = numberDao.findAll(example);
        return cvsspNumbersList;
    }


    @Override
    public String getNumberType(String number) {

        String type = "";
        char[] c = number.toCharArray();
        if (c[0] == c[1] && c[2] == c[3] && c[1] != c[2] && !number.endsWith("3344") && !number.endsWith("6688")) {
            type = "AABB";
        } else if (c[0] == c[2] && c[1] == c[3] && c[1] != c[2] && !number.endsWith("6868")) {
            type = "ABAB";
        } else if (c[0] == c[1] && c[0] == c[2] && c[3] != c[2]) {
            type = "AAAB";
        } else if (c[0] == c[3] && c[1] == c[2] && c[2] != c[3]) {
            type = "ABBA";
        } else if (c[0] == c[1] && c[2] == c[0] && c[3] == c[0] && !number.endsWith("888") && !number.endsWith("666")) {
            type = "AAAA";
        } else if (c[0] != c[1] && c[2] != c[0] && c[3] != c[1] && !number.endsWith("520") && !number.endsWith("168") && !number.endsWith("518") && !number.endsWith("1573")) {
            type = "ABCD";
        } else if (c[0] == c[2] && c[1] != c[0] && c[1] != c[2] && c[1] != c[3] && c[3] != c[2] && c[3] != c[0] && !number.endsWith("1314")) {
            type = "ABAC";
        } else {
            type = "default";
        }

        return type;
    }

    @Override
    public String SpecialNumber(String code, String number) {
        if (number.endsWith("1314")) {
            code = "一生一世1314";
        } else if (number.endsWith("520")) {
            code = "我爱你520";
        } else if (number.endsWith("3344")) {
            code = "生生世世3344";
        } else if (number.endsWith("888")) {
            code = "发发发888";
        } else if (number.endsWith("666")) {
            code = "六六大顺666";
        } else if (number.endsWith("168")) {
            code = "一路发168";
        } else if (number.endsWith("518")) {
            code = "我要发518";
        } else if (number.endsWith("6868")) {
            code = "要发要发6868";
        } else if (number.endsWith("1573")) {
            code = "一往情深1573";
        } else if (number.endsWith("6688")) {
            code = "顺顺发发6688";
        } else {
            code = "normal";
        }

        return code;
    }

    /**
     * 获取号码最终的类型
     *
     * @param cvsspNumber
     * @return
     */
    public String findAllNumberType(CvsspNumber cvsspNumber) {

        String str = cvsspNumber.getNumber();
        String number = str.substring(5);
        String type = getNumberType(number);
        String result = "";
        if ("default".equals(type)) {
            result = SpecialNumber(type, number);
        } else {
            result = type;
        }

        return result;

    }

    /**
     * 随机选取号码
     * @return
     */
    public String selected2RadomNO(){

        String number = "";

        Object resutlt =  numberDao.getMaxIdAndMinId();
        Object[] obj = (Object[])resutlt;
        int max = Integer.valueOf(obj[0].toString());
        int min = Integer.valueOf(obj[1].toString());

        Random random = new Random();
        int num = min + (int)(Math.random() * (max-min+1));
        Long id = new Long((long)num);
        CvsspNumber cvsspNumber =numberDao.findOne(id);
        if(null!=cvsspNumber){
            number = cvsspNumber.getNumber();
        }

        return  number;
    }
}
