package cn.itcast.dao.company;

import cn.itcast.domain.company.Company;

import java.util.List;

/**
 * @author TongHu
 * @date 2021/1/10 - 19:21
 */
public interface CompanyDao {
    /**
     * 查询所有的企业
     * */
    List<Company> findAll();

    /**
     * 保存企业信息
     * */
    void save(Company company);

    /**
     * 更新企业信息
     * */
    void update(Company company);

    /**
     * 根据id查询企业信息
     * */
    Company findById(String id);

    /**
     *  根据id删除企业id
     * */
    void deleteById(String id);
}
