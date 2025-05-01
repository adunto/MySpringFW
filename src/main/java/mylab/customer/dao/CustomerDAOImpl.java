package mylab.customer.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import mylab.customer.vo.CustomerVO;

//@Repository("customerDAO")
public class CustomerDAOImpl implements CustomerDAO {
	
	private SqlSession session;
	
	public void setSqlSession(SqlSession session) {
		this.session = session;
	}
	
	@Override
	public void insertCustomer(CustomerVO customer) {
		session.update("insertCustomer", customer);
		System.out.println("등록된 Id=" + customer.getId() + " Name=" + customer.getName());
	}

	@Override
	public List<CustomerVO> selectAllCustomer() {
		List<CustomerVO> customerList = session.selectList("selectAllCustomer");
		return customerList;
	}

	@Override
	public CustomerVO selectCustomer(int id) {
		CustomerVO customerVO = session.selectOne("selectCustomer", id);
		return customerVO;
	}
}
