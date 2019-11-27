package com.lxh.fushoujia.service;

import com.lxh.fushoujia.pojo.Income;
import com.lxh.fushoujia.pojo.Page;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/*
 * @PackageName: com.lxh.fushoujia.service
 * @ClassName: IncomeService
 * @Description:
 * @author: 辉
 * @date: 2019/11/27 17:31
 * */
public interface IncomeService {
    List<Income> listIncome(Page page);
    Income getIncome(@Param("id") int id);
    int addIncome(Income income);
    int deleteIncome(@Param("id") int id);
    int updateIncome(Income income);
}
