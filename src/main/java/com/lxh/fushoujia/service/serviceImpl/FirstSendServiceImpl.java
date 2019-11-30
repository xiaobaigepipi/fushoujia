package com.lxh.fushoujia.service.serviceImpl;

import com.lxh.fushoujia.mapper.FirstSendMapper;
import com.lxh.fushoujia.pojo.FirstSend;
import com.lxh.fushoujia.service.FirstSendService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/*
 * @PackageName: com.lxh.fushoujia.service.serviceImpl
 * @ClassName: FirstSendServiceImpl
 * @Description:
 * @author: 辉
 * @date: 2019/11/8 23:49
 * */
@Service
public class FirstSendServiceImpl implements FirstSendService {
    @Autowired
    FirstSendMapper firstSendMapper;
    @Override
    public List<FirstSend> listFirstSend(Integer id) {
        return firstSendMapper.listFirstSend(id);
    }

    @Override
    public int addFirstSend(FirstSend firstSend) {
        return firstSendMapper.addFirstSend(firstSend);
    }

    @Override
    public FirstSend getFirstSend(Integer id) {
        return firstSendMapper.getFirstSend(id);
    }

    @Override
    public int updateFirstSend(FirstSend firstSend) {
        return firstSendMapper.updateFirstSend(firstSend);
    }

    @Override
    public List<FirstSend> listFirstSendByDepart(Map<String, Object> map) {
        return firstSendMapper.listFirstSendByDepart(map);
    }

    @Override
    public List<FirstSend> listFirstSendByApproval(Integer id) {
        return firstSendMapper.listFirstSendByApproval(id);
    }
}
