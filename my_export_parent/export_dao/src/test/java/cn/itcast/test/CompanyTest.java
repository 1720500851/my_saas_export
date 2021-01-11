package cn.itcast.test;

import cn.itcast.dao.company.CompanyDao;
import cn.itcast.domain.company.Company;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * @author TongHu
 * @date 2021/1/10 - 19:35
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring/applicationContext-dao.xml")
public class CompanyTest {

    @Autowired
    private CompanyDao companyDao;

    @Test
    public void test1(){
        List<Company> list = companyDao.findAll();
        list.forEach(System.out::println);
    }

    /**
     * 分页插件的测试
     * */
    @Test
    public void test01(){
        /**
         * pageHelper
         * public static <E> Page<E> startPage(int pageNum, int pageSize) {
         *         return startPage(pageNum, pageSize, DEFAULT_COUNT);
         *     }
         *     pageNum : 当前页
         *     pageSize: 页面大小
         * */
        PageHelper.startPage(1,3);
        // 查询分页的数据
        List<Company> list = companyDao.findAll();

        //构建一个pageInfo 对象, 这个pageInfo对象类似于pageBean对象
        PageInfo<Company> pageInfo = new PageInfo<>(list);
        System.out.println("当前页: "+ pageInfo.getPageNum());
        System.out.println("总页数: "+ pageInfo.getPages());
        System.out.println("总记录数: "+pageInfo.getTotal());
        System.out.println("页面大小: "+ pageInfo.getPageSize());
        System.out.println("下一页: "+ pageInfo.getNextPage());
        System.out.println("页面的数据: "+ pageInfo.getList());
    }
}
