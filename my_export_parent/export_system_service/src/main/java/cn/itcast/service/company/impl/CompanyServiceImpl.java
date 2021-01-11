package cn.itcast.service.company.impl;

import cn.itcast.dao.company.CompanyDao;
import cn.itcast.domain.company.Company;
import cn.itcast.service.company.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

/**
 * @author TongHu
 * @date 2021/1/10 - 19:49
 */
@Service
public class CompanyServiceImpl implements CompanyService {

    @Autowired
    private CompanyDao companyDao;

    /**
     * 查询所有的企业
     */
    @Override
    public List<Company> findAll() {
        return companyDao.findAll();
    }

    /**
     * 保存企业信息
     *
     * @param company
     */
    @Override
    public void save(Company company) {
        // 创建随机生成的企业id
        company.setId(UUID.randomUUID().toString());
        companyDao.save(company);
    }

    /**
     * 修改企业信息
     *
     * @param company
     */
    @Override
    public void update(Company company) {
        companyDao.update(company);
    }

    /**
     * 根据id查询企业信息
     *
     * @param id
     */
    @Override
    public Company findById(String id) {
        return companyDao.findById(id);
    }

    /**
     * 根据id删除企业信息
     *
     * @param id
     */
    @Override
    public void deleteById(String id) {
        companyDao.deleteById(id);
    }
}
