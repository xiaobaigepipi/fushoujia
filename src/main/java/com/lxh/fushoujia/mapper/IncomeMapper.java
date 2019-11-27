package com.lxh.fushoujia.mapper;

import com.lxh.fushoujia.pojo.Income;
import com.lxh.fushoujia.pojo.Page;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface IncomeMapper {
    List<Income> listIncome(Page page);
    Income getIncome(@Param("id") int id);
    int addIncome(Income income);
    int deleteIncome(@Param("id") int id);
    int updateIncome(Income income);
}
