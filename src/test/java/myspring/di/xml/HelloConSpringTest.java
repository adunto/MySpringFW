package myspring.di.xml;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
//Assertions 에 포함된 모든 static method를 import 한다.
import static org.junit.jupiter.api.Assertions.*;

import org.apache.jasper.tagplugins.jstl.core.ForEach;


@ExtendWith(SpringExtension.class)
@ContextConfiguration(locations = "classpath:hello-di.xml")
public class HelloConSpringTest {
	@Autowired
	@Qualifier("helloC")
	Hello hello;
	
	@Autowired
	Printer conPrinter;
	
	@Test
	void helloCons() {
		System.out.println(hello.sayHello());
		assertEquals("Hello 생성자", hello.sayHello());
		
		assertEquals(3, hello.getNames().size());
		assertEquals("스프링클라우드", hello.getNames().get(2));
		
		for (String name : hello.getNames()) {
			System.out.println(name);
		}
		
		// Iterable 인터페이스
		// ForEach(Consumer) 메서드 호출하기
		
	}
}
