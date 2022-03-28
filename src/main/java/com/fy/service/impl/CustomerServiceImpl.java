package com.fy.service.impl;

import com.fy.dao.CustomerDao;
import com.fy.pojo.Customer;
import com.fy.service.CustomerService;
import com.fy.util.Page;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * @author: fy
 * @create: 2022-03-24 18:14
 **/
@Service("customerService")
public class CustomerServiceImpl implements CustomerService {
    @Autowired
    private CustomerDao customerDao;

    @Override
    public Page<Customer> selectCustomerList(Integer page, Integer rows, String custName, String custSource,
                                             String custIndustry, String custLevel) {

        Page<Customer> result = new Page<Customer>();

        result.setPage(page);
        result.setSize(rows);
        // 构造一个Customer对象
        Customer customer = new Customer();
        // 非空判断
        if (StringUtils.isNotBlank(custName)) {
            customer.setCust_name(custName);
        }
        if (StringUtils.isNotBlank(custSource)) {
            customer.setCust_source(custSource);
        }
        if (StringUtils.isNotBlank(custIndustry)) {
            customer.setCust_industry(custIndustry);
        }
        if (StringUtils.isNotBlank(custLevel)) {
            customer.setCust_level(custLevel);
        }
        customer.setRows(rows);
        // 设置当前页的起始行
        customer.setStart((page-1)*rows);
        // 查询获得总的记录数
        Integer total = customerDao.selectCustomerListCount(customer);
        result.setTotal(total);
        List<Customer> customers = customerDao.selectCustomerList(customer);
        result.setRows(customers);
        return result;
    }

    @Override
    public Integer createCustomer(Customer customer) {
        Integer num = customerDao.createCustomer(customer);
        return num;
    }

    @Override
    public Customer getCustomerById(Integer id) {
        Customer customer = customerDao.getCustomerById(id);
        return customer;
    }

    @Override
    public Integer updateCustomer(Customer customer) {
        Integer num = customerDao.updateCustomer(customer);
        return  num;
    }

    @Override
    public Integer deleteCustomer(Integer id) {
        Integer num = customerDao.deleteCustomer(id);
        return  num;
    }
}
