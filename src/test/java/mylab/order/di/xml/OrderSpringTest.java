package mylab.order.di.xml;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

//@ExtendWith(SpringExtension.class)
//@ContextConfiguration(locations = "classpath:mylab-order-di.xml")
class OrderSpringTest {

	// 테스트 전반적으로 사용할 컨테이너
	ApplicationContext context;

	@Test
	void shoppingCartBeanTest() {
		// XML 설정 파일을 로드하여 스프링 컨테이너 생성
		context = new GenericXmlApplicationContext("classpath:mylab-order-di.xml");

		// 컨테이너로부터 id가 shoppingCart 인 빈을 가져오기
		ShoppingCart cart = (ShoppingCart) context.getBean("shoppingCart");

		// ShoppingCart 스프링Bean을 테스트
		assertEquals(73000.0, cart.getTotalPrice());

	}

	@Test
	void orderServiceBeanTest() {
		// XML 설정 파일을 로드하여 스프링 컨테이너 생성
		context = new GenericXmlApplicationContext("classpath:mylab-order-di.xml");

		// 컨테이너로부터 id가 shoppingCart 인 빈을 가져오기
		OrderService service = (OrderService) context.getBean("orderService");

		// OrderService 스프링Bean을 테스트
		System.out.println(service.calculateOrderTotal());
		assertEquals(73000.0, service.calculateOrderTotal());
	}

}
