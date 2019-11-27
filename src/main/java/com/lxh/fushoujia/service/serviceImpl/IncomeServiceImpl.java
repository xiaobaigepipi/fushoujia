package com.lxh.fushoujia.service.serviceImpl;

import com.lxh.fushoujia.mapper.IncomeMapper;
import com.lxh.fushoujia.pojo.Income;
import com.lxh.fushoujia.pojo.Page;
import com.lxh.fushoujia.service.IncomeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/*
 * @PackageName: com.lxh.fushoujia.service.serviceImpl
 * @ClassName: IncomeServiceImpl
 * @Description:
 * @author: 辉
 * @date: 2019/11/27 17:31
 * */
@Service
public class IncomeServiceImpl implements IncomeService {
    @Autowired
    IncomeMapper incomeMapper;

    @Override
    public List<Income> listIncome(Page page) {
        return incomeMapper.listIncome(page);
    }

    @Override
    public Income getIncome(int id) {
        return incomeMapper.getIncome(id);
    }

    @Override
    public int addIncome(Income income) {
        return incomeMapper.addIncome(income);
    }

    @Override
    public int deleteIncome(int id) {
        return incomeMapper.deleteIncome(id);
    }

    @Override
    public int updateIncome(Income income) {
        return incomeMapper.updateIncome(income);
    }
}
