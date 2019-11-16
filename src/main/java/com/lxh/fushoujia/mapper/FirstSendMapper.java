package com.lxh.fushoujia.mapper;

import com.lxh.fushoujia.pojo.FirstSend;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/*
 * @PackageName: com.lxh.fushoujia.mapper
 * @ClassName: FirstSendMapper
 * @Description:
 * @author: 辉
 * @date: 2019/11/8 22:41
 * */
public interface FirstSendMapper {
    List<FirstSend> listFirstSend(@Param("projectId") Integer id);
    int addFirstSend(FirstSend firstSend);
    FirstSend getFirstSend(@Param("id") Integer id);
    int updateFirstSend(FirstSend firstSend);
    List<FirstSend> listFirstSendByDepart(Map<String, Object> map);
}
