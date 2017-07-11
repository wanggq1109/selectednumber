package com.cvssp.selectednumber;

import com.alibaba.fastjson.JSONObject;
import com.cvssp.selectednumber.dao.NumberCategoryDao;
import com.cvssp.selectednumber.dao.NumberDao;
import com.cvssp.selectednumber.domain.CategoryCvsspNumber;
import com.cvssp.selectednumber.domain.CvsspNumber;
import com.cvssp.selectednumber.service.CvsspNumberCategoryService;
import com.cvssp.selectednumber.service.NumberService;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;


/**
 * Created by wgq on 2017/6/21.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class NumberTest {

    @Autowired
    private NumberDao numberDao;

    @Autowired
    NumberService numberService;

    @Autowired
    private NumberCategoryDao numberCategoryDao;

    @Autowired
    private CvsspNumberCategoryService cvsspNumberCategoryService;


    @Test
    public void createCategory2Number() {

        List<CvsspNumber> numberList = numberDao.getNumbersList();

        cvsspNumberCategoryService.saveNumberMappingCategory(numberList);


    }

    @Test
    public void maxAndmin() {

        String number = numberService.selected2RadomNO();
        System.out.println("随机选取的号码为--------" + number);


    }

    @Test
    public void query() {

        Page pagelist = numberCategoryDao.findNumberAndCategoryInfo("183", "AABB", new PageRequest(0, 5));
        System.out.println(pagelist.getTotalPages() + "-------" + pagelist.getContent().size());

        List list = pagelist.getContent();
        for (int i = 0; i < list.size(); i++) {
            Object[] objArray = (Object[]) list.get(i);
            for (Object obj : objArray) {
                if (obj instanceof CategoryCvsspNumber) {
                    CategoryCvsspNumber categoryCvsspNumber = (CategoryCvsspNumber) obj;
                    System.out.println("---------" + categoryCvsspNumber.getCvsspNumber().getNumber());
                    System.out.println("---------" + categoryCvsspNumber.getCategory().getName());
                    System.out.println("----------" + categoryCvsspNumber.getCategory().getGroupInfo().getPrice());
                }
            }

        }

    }



    @Test
    public void toPostOrderInfo() {

        JSONObject params = new JSONObject();
        params.put("mobile", "18621387368");
        params.put("userId", "156");
        params.put("number", "183000033");
        params.put("totalSum", "1");
        params.put("totalAmount", "100");
        String pathUrl = "http://localhost:8080/admin/selectedNum/toOrder";
        String result = doPost(pathUrl, params).toJSONString();
        System.out.println(result);


    }






    /**
     * post请求
     * @param url
     * @param json
     * @return
     */

    public static JSONObject doPost(String url,JSONObject json){
        DefaultHttpClient client = new DefaultHttpClient();
        HttpPost post = new HttpPost(url);
        JSONObject response = null;
        try {
            StringEntity s = new StringEntity(json.toString());
            s.setContentEncoding("UTF-8");
            s.setContentType("application/json");//发送json数据需要设置contentType
            post.setEntity(s);
            HttpResponse res = client.execute(post);
            if(res.getStatusLine().getStatusCode() == HttpStatus.SC_OK){
                HttpEntity entity = res.getEntity();
                String result = EntityUtils.toString(res.getEntity());// 返回json格式：
                response = JSONObject.parseObject(result);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return response;
    }

}