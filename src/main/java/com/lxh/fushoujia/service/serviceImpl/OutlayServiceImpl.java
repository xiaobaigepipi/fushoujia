package com.lxh.fushoujia.service.serviceImpl;

import com.lxh.fushoujia.mapper.OutlayMapper;
import com.lxh.fushoujia.pojo.Outlay;
import com.lxh.fushoujia.service.OutlayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

/*
 * @PackageName: com.lxh.fushoujia.service.serviceImpl
 * @ClassName: OutlayServiceImpl
 * @Description:
 * @author: 辉
 * @date: 2019/11/27 17:43
 * */
@Service
public class OutlayServiceImpl implements OutlayService {
    @Autowired
    OutlayMapper outlayMapper;

    @Override
    public List<Outlay> listOutlay(Map<String, Object> map) {
        return outlayMapper.listOutlay(map);
    }

    @Override
    public Outlay getOutlay(int id) {
        return outlayMapper.getOutlay(id);
    }

    @Override
    public int addOutlay(Outlay outlay) {
        return outlayMapper.addOutlay(outlay);
    }

    @Override
    public int deleteOutlay(int id) {
        return outlayMapper.deleteOutlay(id);
    }

    @Override
    public int updateOutlay(Outlay outlay) {
        return outlayMapper.updateOutlay(outlay);
    }

    @Override
    public BigDecimal getSunk() {
        BigDecimal i = outlayMapper.getSunk();
        if (i == null) {
            return new BigDecimal(0);
        }
        return i;
    }
}
