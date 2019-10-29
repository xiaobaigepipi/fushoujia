package com.lxh.fushoujia.service.serviceImpl;

import com.lxh.fushoujia.mapper.ProcessMapper;
import com.lxh.fushoujia.pojo.FirstProcess;
import com.lxh.fushoujia.pojo.SecondProcess;
import com.lxh.fushoujia.service.ProcessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/*
 * @PackageName: com.lxh.fushoujia.service.serviceImpl
 * @ClassName: ProcessServiceImpl
 * @Description:
 * @author: 辉
 * @date: 2019/10/25 18:42
 * */
@Service
public class ProcessServiceImpl implements ProcessService {
    @Autowired
    ProcessMapper processMapper;
    @Override
    public List<FirstProcess> listFirstProcess() {
        return processMapper.listFirstProcess();
    }

    @Override
    public int addFirstProcess(FirstProcess first) {
        return processMapper.addFirstProcess(first);
    }

    @Override
    public int updateFirstProcess(FirstProcess first) {
        return processMapper.updateFirstProcess(first);
    }

    @Override
    public int deleteFirstProcess(int id) {
        return processMapper.deleteFirstProcess(id);
    }

    @Override
    public FirstProcess getFirstProcess(int id) {
        return processMapper.getFirstProcess(id);
    }

    @Override
    public List<SecondProcess> listSecondProcess(Integer firstId) {
        return processMapper.listSecondProcess(firstId);
    }

    @Override
    public int addSecondProcess(SecondProcess second) {
        return processMapper.addSecondProcess(second);
    }

    @Override
    public int updateSecondProcess(SecondProcess second) {
        return processMapper.updateSecondProcess(second);
    }

    @Override
    public int deleteSecondProcess(int id) {
        return processMapper.deleteSecondProcess(id);
    }

    @Override
    public SecondProcess getSecondProcess(int id) {
        return processMapper.getSecondProcess(id);
    }
}
