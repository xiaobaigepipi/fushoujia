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

    @Test
    public void testData() {
        List<User> list = userService.listUserAction();
        List<User> lists = new ArrayList<>();
        for (User u : list) {
            List<UserRole> urs = u.getUserRoles();
            sign:
            for (UserRole ur : urs) {
                List<RoleAction> ras = ur.getRole().getRoleActions();
                for (RoleAction ra : ras) {
                    Action a = ra.getAction();
                    if (a.getCode().equals("project")) {
                        lists.add(u);
                        System.out.println(u.getName());
                        break sign;
                    }
                }
            }
        }

    }



}
