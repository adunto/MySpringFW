package mylab.customer;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import mylab.customer.dao.mapper.CustomerMapper;
import mylab.customer.service.CustomerService;
import mylab.customer.vo.CustomerVO;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(locations = "classpath:spring-beans-mybatis.xml")
public class CustomerSpringTest {
	protected static final Logger logger = LogManager.getLogger();

	@Autowired
	DataSource dataSource;
	
	@Autowired
	@Qualifier("sqlSessionFactory")
	SqlSessionFactory sessionFactory;
	
	@Autowired
	SqlSession sqlSession;
	
	@Autowired
	CustomerMapper customerMapper;
	
	@Autowired
	CustomerService customerService;

	
	@Test
	void serviceTest() {
		CustomerVO customer1 = new CustomerVO("Lee1216@hero.com", "이순신", 54);
		customerService.insertCustomer(customer1);
		System.out.println(customerService.getAllCustomerList());
		System.out.println(customerService.getCustomerInfo(1));
	}
}
