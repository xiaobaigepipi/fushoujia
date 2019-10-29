package com.lxh.fushoujia.service.serviceImpl;

import com.lxh.fushoujia.mapper.SupplierMapper;
import com.lxh.fushoujia.pojo.Page;
import com.lxh.fushoujia.pojo.TSupplier;
import com.lxh.fushoujia.pojo.ZSupplier;
import com.lxh.fushoujia.service.SupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/*
 * @PackageName: com.lxh.fushoujia.service.serviceImpl
 * @ClassName: SupplierServiceImpl
 * @Description:
 * @author: 辉
 * @date: 2019/10/25 17:36
 * */
@Service
public class SupplierServiceImpl implements SupplierService {
    @Autowired
    SupplierMapper supplierMapper;
    @Override
    public List<TSupplier> listTSupplier(Map<String, Object> map) {
        return supplierMapper.listTSupplier(map);
    }

    @Override
    public int addTSupplier(TSupplier ts) {
        return supplierMapper.addTSupplier(ts);
    }

    @Override
    public TSupplier getTSupplier(int id) {
        return supplierMapper.getTSupplier(id);
    }

    @Override
    public int updateTSupplier(TSupplier ts) {
        return supplierMapper.updateTSupplier(ts);
    }

    @Override
    public List<ZSupplier> listZSupplier(Page map) {
        return supplierMapper.listZSupplier(map);
    }

    @Override
    public int addZSupplier(ZSupplier ts) {
        return supplierMapper.addZSupplier(ts);
    }

    @Override
    public TSupplier getZSupplier(int id) {
        return supplierMapper.getZSupplier(id);
    }

    @Override
    public int updateZSupplier(ZSupplier ts) {
        return supplierMapper.updateZSupplier(ts);
    }

    @Override
    public int getTotal(Map<String, Object> map) {
        return supplierMapper.getTotal(map);
    }

    @Override
    public int getZTotal(String key) {
        return supplierMapper.getZTotal(key);
    }

    @Override
    public String getCode() {
        return supplierMapper.getCode();
    }
}
