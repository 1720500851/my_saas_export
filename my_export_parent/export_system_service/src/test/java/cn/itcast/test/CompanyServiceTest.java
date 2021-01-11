package cn.itcast.test;

import cn.itcast.service.company.CompanyService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author TongHu
 * @date 2021/1/10 - 20:05
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath*:spring/applicationContext-*.xml")
public class CompanyServiceTest {

    @Autowired
    private CompanyService companyService;

    @Test
    public void test01(){
        System.out.println("查询所有的用户: "+ companyService.findAll());
    }
}
