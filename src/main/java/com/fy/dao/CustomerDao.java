package com.fy.dao;

import com.fy.pojo.Customer;

import java.util.List;

/**
 * @author: fy
 * @create: 2022-03-24 18:07
 **/
public interface CustomerDao {
    // 客户列表
    List<Customer> selectCustomerList(Customer customer);
    // 客户数
    Integer selectCustomerListCount(Customer customer);

    Integer createCustomer(Customer customer);

    Customer getCustomerById(Integer id);

    Integer updateCustomer(Customer customer);

    Integer deleteCustomer(Integer id);
}
