package mylab.customer.dao;

import java.util.List;

import mylab.customer.vo.CustomerVO;

public interface CustomerDAO {

//	 Customer 를 id 로 조회
	CustomerVO selectCustomer(int id);

//	 Customer 목록 조회
	List<CustomerVO> selectAllCustomer();

//	 Customer 등록 구현하기
	void insertCustomer(CustomerVO customer);
}
