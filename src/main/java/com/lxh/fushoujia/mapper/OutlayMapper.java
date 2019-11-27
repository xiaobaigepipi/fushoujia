package com.lxh.fushoujia.mapper;

import com.lxh.fushoujia.pojo.Outlay;
import com.lxh.fushoujia.pojo.Page;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface OutlayMapper {
    List<Outlay> listOutlay(Map<String, Object> map);
    Outlay getOutlay(@Param("id") int id);
    int addOutlay(Outlay outlay);
    int deleteOutlay(@Param("id") int id);
    int updateOutlay(Outlay outlay);
}
