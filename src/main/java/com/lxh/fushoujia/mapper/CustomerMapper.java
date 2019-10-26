package com.lxh.fushoujia.mapper;

import com.lxh.fushoujia.pojo.Customer;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface CustomerMapper {
    List<Customer> listCustomer(Map<String, Object> map);
    int addCustomer(Customer customer);
    Customer getCustomer(@Param("id")int id);
    int updateCustomer(Customer customer);
    int getTotal(Map<String, Object> map);
}
