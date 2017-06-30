package com.cvssp.selectednumber.dto;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wgq on 2017/6/30.
 */
public class CategoryDTO {

    private List<String> dnsengList = new ArrayList<String>();


    private List<String> typeList = new ArrayList<String>();


    public List<String> getDnsengList() {
        return dnsengList;
    }

    public void setDnsengList(List<String> dnsengList) {
        this.dnsengList = dnsengList;
    }

    public List<String> getTypeList() {
        return typeList;
    }

    public void setTypeList(List<String> typeList) {
        this.typeList = typeList;
    }
}
