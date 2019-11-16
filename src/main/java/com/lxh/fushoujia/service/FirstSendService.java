package com.lxh.fushoujia.service;

import com.lxh.fushoujia.pojo.FirstSend;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface FirstSendService {
    List<FirstSend> listFirstSend(@Param("projectId") Integer id);
    int addFirstSend(FirstSend firstSend);
    FirstSend getFirstSend(@Param("id") Integer id);
    int updateFirstSend(FirstSend firstSend);
    List<FirstSend> listFirstSendByDepart(Map<String, Object> map);
}
