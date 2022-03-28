package com.fy.service;

import com.fy.pojo.Customer;
import com.fy.util.Page;

/**
 * @author: fy
 * @create: 2022-03-24 18:12
 **/
public interface CustomerService {
    // 查询客户列表
    Page<Customer> selectCustomerList(Integer page, Integer rows, String custName, String custSource, String custIndustry, String custLevel);

    Integer createCustomer(Customer customer);

    Customer getCustomerById(Integer id);

    Integer updateCustomer(Customer customer);

    Integer deleteCustomer(Integer id);
}
