package com.cvssp.selectednumber.dao;

import com.cvssp.selectednumber.domain.Generator;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 * Created by wgq on 2017/6/14.
 */
public interface GeneratorDao extends JpaRepository<Generator, Long> {

    @Query(value = "SELECT MAX(G.max_value) From t_generator G  WHERE G.dnseg=?", nativeQuery = true)
    Long getMaxValue(String dnseg);


    @Query("FROM Generator b WHERE b.dnseg=?1 ")
    Generator FindGeneratorInfo(String dnseg);





}
