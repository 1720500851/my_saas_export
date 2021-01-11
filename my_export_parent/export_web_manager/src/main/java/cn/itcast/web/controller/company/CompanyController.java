package cn.itcast.web.controller.company;

import cn.itcast.domain.company.Company;
import cn.itcast.service.company.CompanyService;
import com.github.pagehelper.util.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
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
//    @RequestMapping("/save")
//    public String save(Date birthday){
////        System.out.println(10/0);
//        System.out.println("生日: "+ birthday);
//        return "success";
//    }

    /**
     * 添加用户信息
     *company/toAdd.do
     * 作用 : 跳转到添加页面
     * 返回值: company/company-add.jsp
     * */
    @RequestMapping("/toAdd")
    public String toAdd(){
        return "company/company-add";
    }

    /**
     * 用户数据保存：
     * url： company/edit.do
     * 响应地址: company-list
     * */
    @RequestMapping("edit")
    public String edit(Company company){
        // 判断是否携带id, 如果携带id, 则是修改信息, 如果没有, 则是添加
        // isEmpty: true :是没有值, false 是有值
        if(StringUtil.isEmpty(company.getId())){
            // 没有id
            companyService.save(company);
        }else{
            // 携带id
            companyService.update(company);
        }
        //重定向到列表主页
        return "redirect:/company/list.do";

    }

    /**
     * url: toUpdate.do;
     * 更新企业信息
     * 参数: 企业的信息
     *  响应地址
     * */
    @RequestMapping("/toUpdate")
    public String toUpdate(String id ,HttpServletRequest request){
        //根据id获取企业信息
        Company company = companyService.findById(id);
        // 将企业信息存到请求域中
        request.setAttribute("company",company);
        return "/company/company-update";
    }

    /**
     * url: http://localhost:8080/company/delete.do?id=02e1da04-43f8-42e1-a4c2-66e162c6f4a5
     * */
    @RequestMapping("delete")
    public String deleteById(String id){
        companyService.deleteById(id);
        // 重定向到列表主页
        return "redirect:/company/list.do";
    }





}
