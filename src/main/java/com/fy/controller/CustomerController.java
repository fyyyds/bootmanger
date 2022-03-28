package com.fy.controller;

import com.fy.pojo.BaseDict;
import com.fy.pojo.Customer;
import com.fy.service.BaseDictService;
import com.fy.service.CustomerService;
import com.fy.util.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author: fy
 * @create: 2022-03-24 18:24
 **/
@Controller
public class CustomerController {
    // 注入service
    @Autowired
    private CustomerService customerService;
    @Autowired
    private BaseDictService baseDictService;

    //  客户来源
    @Value("${customer.from.type}")
    private String FROM_TYPE;

    // 客户所属行业
    @Value("${customer.industry.type}")
    private String INDUSTRY_TYPE;

    // 客户级别
    @Value("${customer.level.type}")
    private String LEVEL_TYPE;

    // 客户列表
    @GetMapping("/customer/list")
    public String list(@RequestParam(defaultValue = "1") Integer page, @RequestParam(defaultValue = "10") Integer rows,
                       String custName, String custSource, String custIndustry, String custLevel, Model model) {

        // 条件查询所有客户
        Page<Customer> customers = customerService.selectCustomerList(page, rows, custName, custSource, custIndustry, custLevel);
        // 放到模型中
        model.addAttribute("page", customers);

        // 客户来源
        List<BaseDict> fromType = baseDictService.selectBaseDictByTypeCode(FROM_TYPE);
        // 客户所属行业
        List<BaseDict> industryType = baseDictService.selectBaseDictByTypeCode(INDUSTRY_TYPE);
        // 客户级别
        List<BaseDict> levelType = baseDictService.selectBaseDictByTypeCode(LEVEL_TYPE);

        // 添加参数
        model.addAttribute("fromType", fromType);
        model.addAttribute("industryType", industryType);
        model.addAttribute("levelType", levelType);
        model.addAttribute("custName", custName);
        model.addAttribute("custSource", custSource);
        model.addAttribute("custIndustry", custIndustry);
        model.addAttribute("custLevel", custLevel);

        return "customer";
    }

    @PostMapping("/customer/create")
    @ResponseBody
    public String create(Customer customer) {
        int num = customerService.createCustomer(customer);
        if (num == 1) {
            return "OK";
        }
        return "FALSE";
    }

    @GetMapping("/customer/getCustomerById")
    @ResponseBody
    public Customer getCustomerById(Integer id) {
        Customer customer = customerService.getCustomerById(id);
        return customer;
    }

    @PostMapping("/customer/update")
    @ResponseBody
    public String update(Customer customer) {
        int num = customerService.updateCustomer(customer);
        if (num == 1) {
            return "OK";
        }
        return "FALSE";
    }

    @PostMapping("/customer/delete")
    @ResponseBody
    public String delete(Integer id) {
        int num = customerService.deleteCustomer(id);
        if (num == 1) {
            return "OK";
        }
        return "FALSE";
    }
}
