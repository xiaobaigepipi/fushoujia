package com.lxh.fushoujia.service.serviceImpl;

import com.lxh.fushoujia.mapper.SecondSendMapper;
import com.lxh.fushoujia.pojo.SecondSend;
import com.lxh.fushoujia.service.SecondSendService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/*
 * @PackageName: com.lxh.fushoujia.service.serviceImpl
 * @ClassName: SecondSendServiceImpl
 * @Description:
 * @author: 辉
 * @date: 2019/11/16 19:20
 * */
@Service
public class SecondSendServiceImpl implements SecondSendService {
    @Autowired
    SecondSendMapper secondSendMapper;

    @Override
    public List<SecondSend> listSecondSend(int id) {
        return secondSendMapper.listSecondSend(id);
    }

    @Override
    public int addSecondSend(SecondSend s) {
        return secondSendMapper.addSecondSend(s);
    }

    @Override
    public int updateSecondSend(SecondSend s) {
        return secondSendMapper.updateSecondSend(s);
    }

    @Override
    public SecondSend getSecondSend(int id) {
        return secondSendMapper.getSecondSend(id);
    }

    @Override
    public List<SecondSend> listSecondSendByUser(Map<String, Object> map) {
        return secondSendMapper.listSecondSendByUser(map);
    }

    @Override
    public List<SecondSend> listSecondSendByApproval(Integer id) {
        return secondSendMapper.listSecondSendByApproval(id);
    }

    @Override
    public List<SecondSend> listSecondSendByInvalid(Integer id) {
        return secondSendMapper.listSecondSendByInvalid(id);
    }
}
