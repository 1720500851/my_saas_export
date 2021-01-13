package cn.itcast.service.system.impl;

import cn.itcast.dao.system.DeptDao;
import cn.itcast.domain.system.Dept;
import cn.itcast.service.system.DeptService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

/**
 * @author TongHu
 * @date 2021/1/12 - 21:51
 */
@Service
public class DeptServiceImpl implements DeptService {

    @Autowired
    private DeptDao deptDao;


    /**
     * 查询所有的信息
     * */
    @Override
    public PageInfo<Dept> findById(Integer pageNum, Integer pageSize, String companyId) {
        // 设置页面大小
        PageHelper.startPage(pageNum,pageSize);

        // 查询所有部门
        List<Dept> deptList =  deptDao.findAll(companyId);

        // 构建pageInfo对象
        PageInfo<Dept> pageInfo = new PageInfo<>(deptList);
        return pageInfo;
    }

    /**
     * 根据id查询所有的部门
     * */
    @Override
    public List<Dept> findAll(String companyId) {
        return deptDao.findAll(companyId);
    }

    /**
     * 保存部门信息
     *
     * @param dept
     */
    @Override
    public void save(Dept dept) {
        dept.setId(UUID.randomUUID().toString());
        deptDao.save(dept);

    }

    /**
     * 修改部门信息
     *
     * @param dept
     */
    @Override
    public void update(Dept dept) {
        deptDao.update(dept);
    }

    /**
     * 根据id查询部门
     *
     * @param id
     */
    @Override
    public Dept findById(String id) {
        return deptDao.findById(id);
    }

    /**
     * 根据部门id删除部门
     *
     * @param id
     */
    @Override
    public boolean delete(String id) {
        // 查询该部门是否有子部门
        int count =  deptDao.findByParamId(id);
        // 判断该部门是否大于0 , 如果大于0 , 说明有子部门,返回false
        if(count>0){
            return false;
        }
            //等于0 , 说明没有子部门,直接删除
            deptDao.deleteById(id);
            return true;

    }
}
