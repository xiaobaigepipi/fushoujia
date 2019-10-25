import com.lxh.fushoujia.pojo.*;
import com.lxh.fushoujia.service.BasicService;
import com.lxh.fushoujia.service.CustomerService;
import com.lxh.fushoujia.service.SupplierService;
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

    @Autowired
    SupplierService supplierService;

    @Test
    public void testData() {

       ZSupplier zs = new ZSupplier();
       zs.setCharges("收费标准1");
       zs.setContact("contact1");
       zs.setName("name1");
       zs.setPhone("phone1");
       zs.setType("type1");
       zs.setDelete(true);
       zs.setId(1);
       supplierService.updateZSupplier(zs);

       Page page = new Page();
       page.setCount(4);
       page.setStart(0);
       page.setSearchKey("3213");
       System.out.println(supplierService.listZSupplier(page).size());

    }



}
