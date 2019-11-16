import com.lxh.fushoujia.pojo.*;
import com.lxh.fushoujia.service.*;
import com.lxh.fushoujia.pojo.Page;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.text.SimpleDateFormat;
import java.util.*;

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

    @Autowired
    SupplierService supplierService;

    @Autowired
    ProcessService processService;

    @Autowired
    FirstSendService firstSendService;

    @Test
    public void testData() {
        Department d = new Department();

        Map<String, Object> map = new HashMap<>();
        map.put("start", 0);
        map.put("count", 5);
        map.put("searchKey", null);
        map.put("departmentId", 32);
        map.put("page","231");
        List<FirstSend> list = firstSendService.listFirstSendByDepart(map);
        System.out.println(list.size());
    }



}
