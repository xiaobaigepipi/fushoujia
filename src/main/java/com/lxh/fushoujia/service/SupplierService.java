package com.lxh.fushoujia.service;

import com.lxh.fushoujia.pojo.Page;
import com.lxh.fushoujia.pojo.TSupplier;
import com.lxh.fushoujia.pojo.ZSupplier;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface SupplierService {
    List<TSupplier> listTSupplier(Map<String, Object> map);
    int addTSupplier(TSupplier ts);
    TSupplier getTSupplier(@Param("id") int id);
    int updateTSupplier(TSupplier ts);
    int getTotal(Map<String, Object> map);
    String getCode();
    List<TSupplier> listAllTSupplier();

    List<ZSupplier> listZSupplier(Page page);
    int addZSupplier(ZSupplier ts);
    TSupplier getZSupplier(@Param("id") int id);
    int updateZSupplier(ZSupplier ts);
    int getZTotal(String key);
}
