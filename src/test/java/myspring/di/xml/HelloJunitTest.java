package myspring.di.xml;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.test.context.junit.jupiter.SpringExtension;

// Assertions 에 포함된 모든 static method를 import 한다.
import static org.junit.jupiter.api.Assertions.*;

import javax.naming.Context;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;

public class HelloJunitTest {
	
	ApplicationContext context;
	
	@BeforeEach
	void init() {
		// 1. Container 객체 생성
		context = new GenericXmlApplicationContext("classpath:hello-di.xml");
	}

	@Test
	void helloBean() {
		// 2. Container 객체가 생성한 Spring Bean을 요청하기
		Hello helloById = (Hello) context.getBean("hello");
		Hello helloByType = context.getBean("hello", Hello.class);

		// Spring Bean 의 주소비교
		System.out.println(helloById == helloByType);
		assertSame(helloById, helloByType);

		// <property name="name" value="스프링"/>
		assertEquals("Hello 스프링", helloById.sayHello());
		System.out.println(helloById.sayHello());

		helloById.print();

		// Container 객체가 생성한 StringPrinter Bean을 요청하기
		// <property name="printer" ref="strPrinter" />
		Printer printer = context.getBean("strPrinter", Printer.class);
		assertEquals("Hello 스프링", printer.toString());

	}

}
