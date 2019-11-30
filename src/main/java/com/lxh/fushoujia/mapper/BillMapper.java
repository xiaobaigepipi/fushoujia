package com.lxh.fushoujia.mapper;

import com.lxh.fushoujia.pojo.Bill;
import com.lxh.fushoujia.pojo.Page;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BillMapper {
    List<Bill> listBill(Page page);
    Bill getBill(@Param("id") int id);
    List<Bill> listBillByStatus(@Param("status") String status);
    int addBill(Bill bill);
    int deleteBill(@Param("id") int id);
    int updateBill(Bill bill);

    Integer getAllBill(@Param("projectId") int id);
}
