package com.cvssp.selectednumber.dao;

import com.cvssp.selectednumber.domain.CvsspNumber;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * Created by wgq on 2017/6/14.
 */
public interface NumberDao extends JpaRepository<CvsspNumber,Long> {

    @Query("FROM CvsspNumber n WHERE n.dnseg=?1")
    List<CvsspNumber> findNumberStateless(String dnseg);

    @Query("FROM CvsspNumber n WHERE n.number=?1")
    CvsspNumber getNumberObjetByName(String name);



    /**
     * 通过正则查询当前符合类型的号码
     * @param regex
     * @return
     */
    @Query(value = "SELECT * FROM t_cvssp_number c WHERE  c.status = 'onReady' AND c.number REGEXP ? ",nativeQuery = true)
    List<CvsspNumber> getNumbersByTypeRegex(String regex);


    /**
     * 查询所有已经准备就绪的号码
     * @return
     */
    @Query("FROM CvsspNumber n WHERE n.status = 'onReady'")
    List<CvsspNumber> getNumbersList();


    @Query(value = "SELECT  MIN(id),MAX(id) FROM  t_cvssp_number N WHERE N.status = 'onReady' ",nativeQuery = true)
    Object getMaxIdAndMinId();


}
