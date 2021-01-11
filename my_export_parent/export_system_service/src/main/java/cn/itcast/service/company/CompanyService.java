package cn.itcast.service.company;

import cn.itcast.domain.company.Company;

import java.util.List;

/**
 * @author TongHu
 * @date 2021/1/10 - 19:48
 */
public interface CompanyService  {
    /**
     * 查询所有的企业
     * */
    public List<Company> findAll();
}
