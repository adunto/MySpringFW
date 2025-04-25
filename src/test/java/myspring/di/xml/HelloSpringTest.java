package myspring.di.xml;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

//Assertions 에 포함된 모든 static method를 import 한다.
import static org.junit.jupiter.api.Assertions.*;

import javax.annotation.Resource;

// SpringExtension 클래스는 ApplicationContext(Container) 를 생성하는 역할
// ApplicationContext context = new GenericXmlApplicationContext("classpath:hello-di.xml");
@ExtendWith(SpringExtension.class)
@ContextConfiguration(locations = "classpath:hello-di.xml")
public class HelloSpringTest {
	// context.getBean("hello", Hello.class);
	@Autowired
	Hello hello;
	
	// context.getBean("strPrinter", Printer.class);
	@Autowired
	Printer strPrinter;
	
	// context.getBean("strPrinter", Printer.class);
	@Autowired
	@Qualifier("strPrinter")
	Printer printer;
	
	// name : 내가 찾고자 하는 Bean 이름
	@Resource(name = "hello")
	Hello helloBean;
	
	@Test
	void helloSpringBean() {
		assertEquals("Hello 스프링", hello.sayHello());
		
		hello.print();
		
		assertEquals("Hello 스프링", strPrinter.toString());
		System.out.println(strPrinter.getClass().getName());
		
		assertEquals("Hello 스프링", printer.toString());
		
		assertEquals("Hello 스프링", helloBean.sayHello());
	}
}
