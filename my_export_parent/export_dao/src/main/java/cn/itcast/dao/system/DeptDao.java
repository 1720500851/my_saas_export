package cn.itcast.dao.system;

import cn.itcast.domain.system.Dept;

import java.util.List;

/**
 * @author TongHu
 * @date 2021/1/12 - 21:45
 */
public interface DeptDao {

    /**
     * 查询所有的部门
     * */
    List<Dept> findAll(String companyId);

    /**
     * 根据部门id查询部门
     * */
    Dept findById(String id);

    /**
     * 保存部门信息
     * */
    void save(Dept dept);

    /**
     * 修改部门信息
     * */
    void update(Dept dept);

    /**
     * 根据id查询该部门id是否有子部门
     * */
    int findByParamId(String id);

    /**
     * 根据部门id删除部门
     * */
    void deleteById(String id);
}
