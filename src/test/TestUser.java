import com.lxh.fushoujia.pojo.*;
import com.lxh.fushoujia.service.BasicService;
import com.lxh.fushoujia.service.CustomerService;
import com.lxh.fushoujia.service.UserService;
import com.lxh.fushoujia.pojo.Page;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @program: fushoujia
 * @description:
 * @author: Mr.Wang
 * @create: 2019-10-09 14:48
 **/
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring-mybatis.xml")
public class TestUser {

    @Autowired
    UserService userService;

    @Autowired
    BasicService basic;

    @Autowired
    CustomerService customerService;

   /* @Test
    public void test() {
       *//* int size = userService.list().size();
        User u = new User();
        u.setEmail("123");
        String token = JwtUtil.sign("123", 89);
        System.out.println(token);
        //String token = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1c2VyTmFtZSI6IjEyMyIsImV4cCI6MTU3MDc4MjE4OSwidXNlcklkIjoxfQ.DSDJolV7h-6PCeDvfBXIF36n1fl0WrMynERhFOwA9Lk";
        //boolean b = JwtUtil.verify(token);
        int id = JwtUtil.getUserId(token);
        System.out.println(id);*//*
        Department d = new Department();
        d.setId(1);
        d.setName("商务部");
        d.setDelete(true);
        //system.addDepartment(d);
        system.updateDepartmentDelete(d);
        List<Department> list = system.listDepartment();
        Department d1 = list.get(0);
        System.out.println(d1.isDelete());

    }*/
    @Test
    public void testData() {
       /* Province p = new Province();
        p.setId(2);
        p.setName("广西壮族自治区");
        //basic.addProvince(p);
        //basic.deleteProvince(1);
        City c = new City();
        c.setName("南宁市");
        c.setProvince(p);
        //basic.addCity(c);
        System.out.println(basic.listCity(p.getId()).size());*/
       /* List<City> list = basic.listCity(2);
        System.out.println(list.get(0).getId());*/
       //int d = Integer.parseInt("56.34");
        //System.out.println(d);*/
        //PageHelper.offsetPage(0, 5);
        Customer c = new Customer();
        c.setName("name1");
        c.setAddress("Address1");
        c.setBank("bank1");
        c.setBillNumber("billNumber1");
        c.setCode("code1");
        c.setContact("contact1");
        c.setDelete(true);
        c.setEmail("email1");
        c.setPhone("phone1");
        c.setSale("sale1");
        c.setReceiveAddress("receive1");
        c.setRemark("remark1");
        c.setTaxNumber("taxnumber1");
        c.setWechat("wechat1");
        //customerService.addCustomer(c);
        System.out.println(customerService.getCustomer(1).getName());
        Map<String, Object> map = new HashMap<>();
        map.put("name", "nam");
        map.put("start", 0);
        map.put("count", 10);
        List<Customer> list = customerService.listCustomer(map);
        System.out.println(list.size());
        c.setId(1);
        customerService.updateCustomer(c);
    }



}
