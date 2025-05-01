package mylab.customer.service;

import java.util.List;


import mylab.customer.vo.CustomerVO;

public interface CustomerService {
//	- Customer 를 id 로 조회
	CustomerVO getCustomerInfo(int id);

//	-  Customer 목록 조회
	List<CustomerVO> getAllCustomerList();

//	-  Customer 등록 구현하기
	void insertCustomer(CustomerVO customer);
}
