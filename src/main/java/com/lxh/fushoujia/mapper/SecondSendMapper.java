package com.lxh.fushoujia.mapper;

import com.lxh.fushoujia.pojo.SecondSend;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SecondSendMapper {

    List<SecondSend> listSecondSend(@Param("firstId") int id);
    int addSecondSend(SecondSend s);
    int updateSecondSend(SecondSend s);
    SecondSend getSecondSend(@Param("id") int id);
    List<SecondSend> listSecondSendByUser(@Param("userId") Integer id);
}
