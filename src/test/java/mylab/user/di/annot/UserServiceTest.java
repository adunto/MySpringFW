package mylab.user.di.annot;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

// UserServiceTest 클래스를 작성
@ExtendWith(SpringExtension.class)
@ContextConfiguration(locations = "classpath:mylab-user-di.xml")
public class UserServiceTest {

	// UserService 를 주입 받기
	@Autowired
	UserService userService;

	@Test
	void testUserService() {
		// UserService의 레퍼런스가 Not Null 인지 검증
		assertNotNull(userService, "userService is null");
			
		// userService.getUserRepository() 가 Not Null 인지 검증
		assertNotNull(userService.getUserRepository(), "userService.getUserRepository() is null");
		
		// userService.getUserRepository().getDbType() 값이 MySQL 인지 값을 비교하기
		assertEquals("MySQL", userService.getUserRepository().getDbType());
		
		// userService.getSecurityService() 가 Not Null 인지 검증
		assertNotNull(userService.getSecurityService(), "userService.getSecurityService() is null");
		
		// userService.registerUser() 메서드가 True 인 검증
		assertTrue(userService.registerUser("U100", "홍길동", "hong123"));

	}
}
