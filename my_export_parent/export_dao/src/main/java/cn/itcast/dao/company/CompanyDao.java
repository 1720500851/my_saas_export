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
}
