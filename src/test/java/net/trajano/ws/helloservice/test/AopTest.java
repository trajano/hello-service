package net.trajano.ws.helloservice.test;

import net.trajano.ws.helloservice.Hello;
import net.trajano.ws.helloservice.SayHello;
import net.trajano.ws.helloservice.impl.HelloImpl;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AopTest {
	@Test
	public void noAopSanity() {
		final Hello p = new HelloImpl();
		p.sayHello(new SayHello());
	}

	@Test
	public void withAop() {
		final ApplicationContext ctx = new ClassPathXmlApplicationContext(
				"beans-aop.xml");
		final Hello p = (Hello) ctx.getBean("hello");
		p.sayHello(new SayHello());
	}
}
