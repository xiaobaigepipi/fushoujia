package com.lxh.fushoujia.service;

import com.lxh.fushoujia.pojo.Contract;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/*
 * @PackageName: com.lxh.fushoujia.service
 * @ClassName: ContractService
 * @Description:
 * @author: 辉
 * @date: 2019/11/19 14:41
 * */
public interface ContractService {
    List<Contract> listContract(Map<String, Object> map);
    Contract getContract(@Param("id")int id);
    int addContract(Contract contract);
    int updateContract(Contract contract);
    int deleteContract(@Param("id") int id);
    int getTotal(@Param("projectId") int projectId, @Param("type") String type);
}
