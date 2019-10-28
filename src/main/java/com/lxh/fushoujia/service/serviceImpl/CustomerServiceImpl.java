package com.lxh.fushoujia.service.serviceImpl;

import com.lxh.fushoujia.mapper.CustomerMapper;
import com.lxh.fushoujia.pojo.Customer;
import com.lxh.fushoujia.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/*
 * @PackageName: com.lxh.fushoujia.service.serviceImpl
 * @ClassName: CustomerServiceImpl
 * @Description:
 * @author: 辉
 * @date: 2019/10/25 2:11
 * */
@Service
public class CustomerServiceImpl implements CustomerService {
    @Autowired
    CustomerMapper customerMapper;

    @Override
    public List<Customer> listCustomer(Map<String, Object> map) {
        return customerMapper.listCustomer(map);
    }

    @Override
    public int addCustomer(Customer customer) {
        return customerMapper.addCustomer(customer);
    }

    @Override
    public Customer getCustomer(int id) {
        return customerMapper.getCustomer(id);
    }

    @Override
    public int updateCustomer(Customer customer) {
        return customerMapper.updateCustomer(customer);
    }

    @Override
    public int getTotal(Map<String, Object> map) {
        return customerMapper.getTotal(map);
    }

    @Override
    public String getCode() {
        return customerMapper.getCode();
    }
}
