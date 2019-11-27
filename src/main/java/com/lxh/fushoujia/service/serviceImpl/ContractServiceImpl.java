package com.lxh.fushoujia.service.serviceImpl;

import com.lxh.fushoujia.mapper.ContractMapper;
import com.lxh.fushoujia.pojo.Contract;
import com.lxh.fushoujia.service.ContractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/*
 * @PackageName: com.lxh.fushoujia.service.serviceImpl
 * @ClassName: ContractServiceImpl
 * @Description:
 * @author: 辉
 * @date: 2019/11/19 14:42
 * */
@Service
public class ContractServiceImpl implements ContractService {
    @Autowired
    ContractMapper contractMapper;

    @Override
    public List<Contract> listContract(Map<String, Object> map) {
        return contractMapper.listContract(map);
    }

    @Override
    public Contract getContract(int id) {
        return contractMapper.getContract(id);
    }

    @Override
    public int addContract(Contract contract) {
        return contractMapper.addContract(contract);
    }

    @Override
    public int updateContract(Contract contract) {
        return contractMapper.updateContract(contract);
    }

    @Override
    public int deleteContract(int id) {
        return contractMapper.deleteContract(id);
    }

    @Override
    public int getTotal(int projectId, String type) {
        return contractMapper.getTotal(projectId, type);
    }
}
