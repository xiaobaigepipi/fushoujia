package com.lxh.fushoujia.service;

import com.lxh.fushoujia.pojo.SecondSend;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SecondSendService {
    List<SecondSend> listSecondSend(@Param("firstId") int id);
    int addSecondSend(SecondSend s);
    int updateSecondSend(SecondSend s);
    SecondSend getSecondSend(@Param("id") int id);
    List<SecondSend> listSecondSendByUser(@Param("userId") Integer id);
}
