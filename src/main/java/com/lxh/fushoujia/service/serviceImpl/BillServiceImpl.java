package com.lxh.fushoujia.service.serviceImpl;

import com.lxh.fushoujia.mapper.BillMapper;
import com.lxh.fushoujia.mapper.ProjectMapper;
import com.lxh.fushoujia.pojo.Bill;
import com.lxh.fushoujia.pojo.Page;
import com.lxh.fushoujia.service.BillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/*
 * @PackageName: com.lxh.fushoujia.service.serviceImpl
 * @ClassName: BillServiceImpl
 * @Description:
 * @author: 辉
 * @date: 2019/11/27 16:35
 * */
@Service
public class BillServiceImpl implements BillService {
    @Autowired
    BillMapper billMapper;
    @Autowired
    ProjectMapper projectMapper;

    @Override
    public List<Bill> listBill(Page page) {
        return billMapper.listBill(page);
    }

    @Override
    public Bill getBill(int id) {
        return billMapper.getBill(id);
    }

    @Override
    public List<Bill> listBillByStatus(String status) {
        return billMapper.listBillByStatus(status);
    }

    @Override
    public int addBill(Bill bill) {
        return billMapper.addBill(bill);
    }

    @Override
    public int deleteBill(int id) {
        return billMapper.deleteBill(id);
    }

    @Override
    public int updateBill(Bill bill) {
        return billMapper.updateBill(bill);
    }
}
