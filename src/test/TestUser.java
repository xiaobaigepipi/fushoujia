import com.lxh.fushoujia.pojo.*;
import com.lxh.fushoujia.service.*;
import com.lxh.fushoujia.pojo.Page;
import com.lxh.fushoujia.util.PDFUtil;
import com.lxh.fushoujia.util.ProjectStatus;
import com.lxh.fushoujia.util.Util;
import org.apache.commons.lang.StringUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.ws.rs.PUT;
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
    @Autowired
    ProjectService projectService;

    @Test
    public void testData() {
        Project project = projectService.getProject(8);
        PDFUtil pdf = new PDFUtil();
        pdf.generatePDF(project);
        System.out.println("生成PDF成功311322222");
    }



}
