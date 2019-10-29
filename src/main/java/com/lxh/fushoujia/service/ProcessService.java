package com.lxh.fushoujia.service;

import com.lxh.fushoujia.pojo.FirstProcess;
import com.lxh.fushoujia.pojo.SecondProcess;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ProcessService {
    List<FirstProcess> listFirstProcess();
    int addFirstProcess(FirstProcess first);
    int updateFirstProcess(FirstProcess first);
    int deleteFirstProcess(@Param("id")int id);
    FirstProcess getFirstProcess(@Param("id")int id);

    List<SecondProcess> listSecondProcess(Integer firstId);
    int addSecondProcess(SecondProcess second);
    int updateSecondProcess(SecondProcess second);
    int deleteSecondProcess(@Param("id")int id);
    SecondProcess getSecondProcess(@Param("id")int id);
}
