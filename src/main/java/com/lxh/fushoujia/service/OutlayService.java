package com.lxh.fushoujia.service;

import com.lxh.fushoujia.pojo.Outlay;
import org.apache.ibatis.annotations.Param;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

public interface OutlayService {
    List<Outlay> listOutlay(Map<String, Object> map);
    Outlay getOutlay(@Param("id") int id);
    int addOutlay(Outlay outlay);
    int deleteOutlay(@Param("id") int id);
    int updateOutlay(Outlay outlay);

    BigDecimal getSunk();
}
