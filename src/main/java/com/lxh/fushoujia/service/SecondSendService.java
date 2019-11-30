package com.lxh.fushoujia.service;

import com.lxh.fushoujia.pojo.SecondSend;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface SecondSendService {
    List<SecondSend> listSecondSend(@Param("firstId") int id);
    int addSecondSend(SecondSend s);
    int updateSecondSend(SecondSend s);
    SecondSend getSecondSend(@Param("id") int id);
    List<SecondSend> listSecondSendByUser(Map<String, Object> map);
    List<SecondSend> listSecondSendByApproval(Integer id);
    List<SecondSend> listSecondSendByInvalid(Integer id);
}
