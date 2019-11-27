package com.lxh.fushoujia.mapper;

import com.lxh.fushoujia.pojo.Contract;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface ContractMapper {
    List<Contract> listContract(Map<String, Object> map);
    Contract getContract(@Param("id")int id);
    int addContract(Contract contract);
    int updateContract(Contract contract);
    int deleteContract(@Param("id") int id);
    int getTotal(@Param("projectId") int projectId, @Param("type") String type);
}
