package myspring.user;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.logging.log4j.LogManager;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import myspring.user.dao.mapper.UserMapper;
import myspring.user.service.UserService;
import myspring.user.vo.UserVO;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(locations = "classpath:spring-beans-mybatis.xml")
public class UserMyBatisTest {

	protected static final Logger logger = LogManager.getLogger();
	
	@Autowired
	DataSource dataSource;
	
	@Autowired
	@Qualifier("sqlSessionFactory")
	SqlSessionFactory sessionFactory;
	
	@Autowired
	SqlSession sqlSession;
	
	@Autowired
	UserMapper userMapper;
	
	@Autowired
	UserService userService;
	
	@Test
	void serviceTest() {
		userService.insertUser(new UserVO("boot", "아임부트", "남", "서울"));
		UserVO user = userService.getUser("boot");
		logger.debug(user);
	}
	
	@Test @Disabled
	void scanUserMapper() {
		UserVO user = userMapper.selectUserById("gildong");
		System.out.println(user.toString());
	}
	
	@Test @Disabled
	void userMapper() {
		UserVO user = sqlSession.selectOne("userNS.selectUserById", "dooly");
		logger.debug(user);
	}
	
	@Test @Disabled
	void sqlSession() {
		// org.apache.ibatis.session.defaults.DefaultSqlSessionFactory
		System.out.println(sessionFactory.getClass().getName());
		
//		UserVO user = sqlSession.selectOne("userNS.selectUserById", "dooly");
//		logger.debug(user);
		
		// Anonymous Inner Class (익명 내부 클래스)
		List<UserVO> userList = sqlSession.selectList("userNS.selectUserList");
//		userList.forEach(new Consumer<UserVO>() {
//			@Override
//			public void accept(UserVO t) {
//				// TODO Auto-generated method stub
//				System.out.println(t.toString());
//			}
//		});
		userList.forEach(user -> System.out.println(user.toString()));
		// .forEach(Consumer)에서 Consumer를 Method Reference 으로 선언하는 방식
		userList.forEach(System.out::println);	// :: arg 바로 바디로 넣어줌
		
	}

	@Test @Disabled
	void connection() {
		try {
			Connection connection = dataSource.getConnection();
			DatabaseMetaData metaData = connection.getMetaData();
			logger.debug("DB URL: " + metaData.getURL());
			logger.debug("DBs Username: " + metaData.getUserName());
			logger.debug("DB Vendor Name: " + metaData.getDatabaseProductName());
		} catch(SQLException e) {
			e.printStackTrace();
		}
	}
}
