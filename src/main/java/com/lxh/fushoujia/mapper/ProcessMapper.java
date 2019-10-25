package com.lxh.fushoujia.mapper;

import com.lxh.fushoujia.pojo.FirstProcess;
import com.lxh.fushoujia.pojo.SecondProcess;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ProcessMapper {
    List<FirstProcess> listFirstProcess();
    int addFirstProcess(FirstProcess first);
    int updateFirstProcess(FirstProcess first);
    int deleteFirstProcess(@Param("id")int id);
    FirstProcess getFirstProcess(@Param("id")int id);

    List<SecondProcess> listSecondProcess();
    int addSecondProcess(SecondProcess second);
    int updateSecondProcess(SecondProcess second);
    int deleteSecondProcess(@Param("id")int id);
    SecondProcess getSecondProcess(@Param("id")int id);


}
