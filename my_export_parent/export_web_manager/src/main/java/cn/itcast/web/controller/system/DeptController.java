package cn.itcast.web.controller.system;

import cn.itcast.domain.system.Dept;
import cn.itcast.service.system.DeptService;

import com.github.pagehelper.PageInfo;
import com.github.pagehelper.util.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author TongHu
 * @date 2021/1/12 - 21:52
 */

@Controller
@RequestMapping("/system/dept")
public class DeptController {
    @Autowired
    private DeptService deptService;

    /**
     * usr: http://localhost:8080/system/dept/list.do
     * 作用: 用于展示部门列表
     * 参数: 无
     * 返回值: 部门列表页面: system/dept/dept-list.do
     */
    @RequestMapping("/list")
    public String list(@RequestParam(defaultValue = "1") Integer pageNum, @RequestParam(defaultValue = "5") Integer pageSize, HttpServletRequest request) {
        // 企业id应该是登入者所属企业的, 没有做登入功能, 那么就先写死companyId
        String companyId = "1";

        // 查询部门列表:
        PageInfo<Dept> pageInfo = deptService.findById(pageNum, pageSize, companyId);
        // 将查询的信息存储到请求域中
        request.setAttribute("pageInfo", pageInfo);

        // 回到页面
        return "system/dept/dept-list";


    }

    /**
     * url: http://localhost:8080/system/dept/toAdd.do
     * 作用: 进入到添加页面
     * 返回值: system/dept/dept-add.jsp;
     */
    @RequestMapping("/toAdd")
    public String toAdd(HttpServletRequest request) {
        //根据登入者的公司id
        String companyId = "1";
        // 查询所有的部门信息用作下拉框
        List<Dept> deptList = deptService.findAll(companyId);
        System.out.println("结果: " + deptList);
        // 将部门信息存储到请求域中
        request.setAttribute("deptList", deptList);
        // 返回到请求页面
        return "system/dept/dept-add";
    }

    /**
     * url: http://localhost:8080/system/dept/edit.do
     * 作用: 用户保存部门信息
     * @param dept
     * @return 部门列表
     * */
    @RequestMapping("/edit")
    public String edit(Dept dept){
        // 需要部门信息和企业名称(因为这些数据属于登入者)
        String companyId = "1";
        String companyName = "传智播客教育股份有限公司";

        // 将这两个信息存在部门对象中
        dept.setCompanyId(companyId);
        dept.setCompanyName(companyName);

        // 判断是否携带id, 如果携带则是修改, 如果没有则是添加
        if(StringUtil.isEmpty(dept.getId())){
            deptService.save(dept);
        }else{
            deptService.update(dept);
        }
        return "redirect:/system/dept/list.do";
    }

    /**
     * url: http://localhost:8080/system/dept/toUpdate.do?id=1c9bd3a0-65f6-493f-8096-e154890c62f3
     * 作用: 进入到修改页面
     * @param : 部门id
     * @return :system/dept/dept-update.jsp
     * */
    @RequestMapping("/toUpdate")
    public String toUpdate(String id ,HttpServletRequest request){
        // 根据id查询部门名称
        Dept dept = deptService.findById(id);
        // 将查询的部门名称存入会话中
        request.setAttribute("dept",dept);

        // 查询所有部门, 用作数据回显
        String companyId = "1";
        List<Dept> deptList = deptService.findAll(companyId);
        // 将查询的部门信息存储到会话中
        request.setAttribute("deptList",deptList);

        // 回到更新页面
        return "system/dept/dept-update";

    }

    /**
     * url: /system/dept/delete.do",
     * 作用 : 删除部门信息
     * @param 部门 id
     * @retrun  json 对象
     * */
    @RequestMapping("/delete")
    @ResponseBody // 将数据响应给浏览器
    public Map<String, Object> delete(String id){
        boolean flag = deptService.delete(id);
        Map<String , Object> resultMap = new HashMap<>();

        // 不管成功都要添加flag
        resultMap.put("flag",flag);
        if(flag){
            // 删除成功
            resultMap.put("message","删除成功");
        }else{
            //删除失败
            resultMap.put("message","该部门有子部门, 不能直接删除");
        }

        return resultMap;
    }



}
