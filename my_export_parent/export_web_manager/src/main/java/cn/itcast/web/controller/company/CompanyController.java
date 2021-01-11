package cn.itcast.web.controller.company;

import cn.itcast.domain.company.Company;
import cn.itcast.service.company.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;

/**
 * @author TongHu
 * @date 2021/1/10 - 20:23
 */

@Controller
@RequestMapping("/company")
public class CompanyController {

    @Autowired
    private CompanyService companyService;

    @RequestMapping("/list")
    public String list(HttpServletRequest request){
        // 查询所有的企业
        List<Company> list = companyService.findAll();
        // 存储到request 域中
        request.setAttribute("list",list);
        // 回到页面
        return "company/company-list";
    }

    /**
     * 日期类型自定义转换器定义步骤:
     *      1. 自定义一个类实现Converter 接口
     *      2. 实现Converter 接口
     *      3. 创建日期类型转换器对象
     *      4. 把日期类型转换器的对象交给转换器工厂
     *      5. 类型转换器的工厂交给注解驱动去启动
     * */
    @RequestMapping("/save")
    public String save(Date birthday){
//        System.out.println(10/0);
        System.out.println("生日: "+ birthday);
        return "success";
    }

}
