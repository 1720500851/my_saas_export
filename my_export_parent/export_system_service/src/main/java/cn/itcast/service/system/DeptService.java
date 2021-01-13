package cn.itcast.service.system;

import cn.itcast.domain.system.Dept;
import com.github.pagehelper.PageInfo;

import java.util.List;

/**
 * @author TongHu
 * @date 2021/1/12 - 21:50
 */
public interface DeptService {

    //查询部门列表
    PageInfo<Dept> findById(Integer pageNum, Integer pageSize, String companyId);

    // 根据公司id查询所有的部门
    List<Dept> findAll(String companyId);

    /**
     * 保存部门信息
     * */
    void save(Dept dept);

    /**
     * 修改部门信息
     * */
    void update(Dept dept);

    /**
     * 根据id查询部门
     * */
    Dept findById(String id);

    /**
     * 根据部门id删除部门
     * */
    boolean delete(String id);
}
