import com.lxh.fushoujia.pojo.*;
import com.lxh.fushoujia.service.*;
import com.lxh.fushoujia.pojo.Page;
import com.lxh.fushoujia.util.ProjectStatus;
import org.apache.commons.lang.StringUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.math.BigDecimal;
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
    @Autowired
    SecondSendService secondSendService;
    @Autowired
    ContractService contractService;
    @Autowired
    BillService billService;
    @Autowired
    IncomeService incomeService;
    @Autowired
    OutlayService outlayService;

    @Test
    public void testData() {
        Page page = new Page();
        page.setSearchKey(null);
        page.setStart(0);
        page.setCount(1);

        Outlay i = new Outlay();
        i.setAccount("account");
        i.setAmount(new BigDecimal(64127));
        i.setSunk(true);
        i.setOutDate(new Date());
        i.setProjectId(8);
        i.setType("设计费");
        i.setRemark("备注");
        outlayService.addOutlay(i);
    }



}
