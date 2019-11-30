package com.lxh.fushoujia.service;

import com.lxh.fushoujia.pojo.Bill;
import com.lxh.fushoujia.pojo.Page;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BillService {
    List<Bill> listBill(Page page);
    Bill getBill(@Param("id") int id);
    List<Bill> listBillByStatus(@Param("status") String status);
    int addBill(Bill bill);
    int deleteBill(@Param("id") int id);
    int updateBill(Bill bill);

    Integer getAllBill(int id);
}
