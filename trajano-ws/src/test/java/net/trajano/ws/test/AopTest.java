package net.trajano.ws.test;

import net.trajano.ws.helloservice.Hello;
import net.trajano.ws.helloservice.impl.HelloImpl;
import net.trajano.ws.schema.business.BaseType;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AopTest {
	@Test
	public void noAopSanity() throws Exception {
		final Hello p = new HelloImpl();
		p.sayHello(new BaseType());
	}

	@Test
	public void withAop() throws Exception {
		final ApplicationContext ctx = new ClassPathXmlApplicationContext(
				"beans-aop.xml");
		final Hello p = (Hello) ctx.getBean("hello");
		p.sayHello(new BaseType());
	}
}
