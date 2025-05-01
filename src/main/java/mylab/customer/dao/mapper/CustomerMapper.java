package mylab.customer.dao.mapper;

import java.util.List;

import mylab.customer.vo.CustomerVO;

public interface CustomerMapper {
	void insertCustomer(CustomerVO customerVO);
	List<CustomerVO> selectAllCustomer();
	CustomerVO selectCustomer(int id);
}
