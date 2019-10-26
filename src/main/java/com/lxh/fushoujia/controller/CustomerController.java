package com.lxh.fushoujia.controller;

import com.lxh.fushoujia.pojo.Customer;
import com.lxh.fushoujia.pojo.Page;
import com.lxh.fushoujia.service.CustomerService;
import com.lxh.fushoujia.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * @PackageName: com.lxh.fushoujia.controller
 * @ClassName: CustomerController
 * @Description:
 * @author: 辉
 * @date: 2019/10/26 0:10
 * */
@Controller
@RequestMapping("/")
public class CustomerController {
    @Autowired
    CustomerService customerService;

    @RequestMapping(value = "/clients", method = RequestMethod.GET)
    @ResponseBody
    public Result listCustomer(Customer customer, @RequestParam("start") Integer start, @RequestParam("count") Integer count) {
        System.out.println(count);
        Map<String, Object> map = new HashMap<>();
        map.put("start", start);
        map.put("count", count);
        map.put("name", customer.getName());
        map.put("code", customer.getCode());
        map.put("address", customer.getAddress());
        map.put("phone", customer.getPhone());
        map.put("contact", customer.getContact());
        map.put("sale", customer.getSale());
        List<Customer> list = customerService.listCustomer(map);
        int total = customerService.getTotal(map);
        Page page = new Page();
        page.setStart(start);
        page.setCount(count);
        page.setTotal(total);
        return new Result("查询成功", "200", page, list);
    }
    @RequestMapping(value = "/clients", method = RequestMethod.PUT)
    @ResponseBody
    public Result deleteCustomer(@RequestBody Integer[] selects) {
        for (int i = 0; i < selects.length; i++) {
            Customer c = new Customer();
            c.setId(selects[i]);
            c.setDelete(true);
            customerService.updateCustomer(c);
        }
        return new Result("删除成功", "200");
    }
}
