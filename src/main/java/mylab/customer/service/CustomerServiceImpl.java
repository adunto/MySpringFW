package mylab.customer.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mylab.customer.dao.CustomerDAO;
import mylab.customer.dao.mapper.CustomerMapper;
import mylab.customer.vo.CustomerVO;

@Service("customerService")
public class CustomerServiceImpl implements CustomerService{
	@Autowired
    CustomerMapper customerMapper;
	
	@Override
	public List<CustomerVO> getAllCustomerList() {
		return customerMapper.selectAllCustomer();
	}
	
	@Override
	public CustomerVO getCustomerInfo(int id) {
		return customerMapper.selectCustomer(id);
	}
	
	@Override
	public void insertCustomer(CustomerVO customer) {
		customerMapper.insertCustomer(customer);
		System.out.println("등록됨 : Name=" + customer.getName());
	}
}
