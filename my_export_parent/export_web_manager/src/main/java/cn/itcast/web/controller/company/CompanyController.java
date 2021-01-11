package cn.itcast.web.controller.company;

import cn.itcast.domain.company.Company;
import cn.itcast.service.company.CompanyService;
import com.github.pagehelper.PageInfo;
import com.github.pagehelper.util.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;


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
    public String list(@RequestParam(defaultValue = "1") Integer pageNum, @RequestParam(defaultValue = "5") Integer pageSize, HttpServletRequest request) {
        // 查询所有的企业
        PageInfo<Company> pageInfo = companyService.FindByPage(pageNum, pageSize);
        // 存储到request 域中
        request.setAttribute("pageInfo", pageInfo);
        // 回到页面
        return "company/company-list";
    }

    /**
     * 添加用户信息
     * company/toAdd.do
     * 作用 : 跳转到添加页面
     * 返回值: company/company-add.jsp
     */
    @RequestMapping("/toAdd")
    public String toAdd() {
        return "company/company-add";
    }

    /**
     * 用户数据保存：
     * url： company/edit.do
     * 响应地址: company-list
     */
    @RequestMapping("edit")
    public String edit(Company company) {
        // 判断是否携带id, 如果携带id, 则是修改信息, 如果没有, 则是添加
        // isEmpty: true :是没有值, false 是有值
        if (StringUtil.isEmpty(company.getId())) {
            // 没有id
            companyService.save(company);
        } else {
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
     * 响应地址
     */
    @RequestMapping("/toUpdate")
    public String toUpdate(String id, HttpServletRequest request) {
        //根据id获取企业信息
        Company company = companyService.findById(id);
        // 将企业信息存到请求域中
        request.setAttribute("company", company);
        return "/company/company-update";
    }

    /**
     * url: http://localhost:8080/company/delete.do?id=02e1da04-43f8-42e1-a4c2-66e162c6f4a5
     */
    @RequestMapping("delete")
    public String deleteById(String id) {
        companyService.deleteById(id);
        // 重定向到列表主页
        return "redirect:/company/list.do";
    }


}
