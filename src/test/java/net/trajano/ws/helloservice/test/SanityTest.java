package net.trajano.ws.helloservice.test;

import net.trajano.ws.helloservice.Hello;
import net.trajano.ws.helloservice.SayHello;
import net.trajano.ws.helloservice.SayHelloFault_Exception;
import net.trajano.ws.helloservice.SayHelloResponse;
import net.trajano.ws.helloservice.impl.HelloImpl;

import org.junit.Assert;
import org.junit.Test;

public class SanityTest {
	@Test(expected = SayHelloFault_Exception.class)
	public void doFault() throws Exception {
		final Hello h;
		{
			final HelloImpl impl = new HelloImpl();
			impl.setHelloString("ABC");
			h = impl;
		}
		final SayHello parameters = new SayHello();
		parameters.setIn("fault");
		h.sayHello(parameters);
	}

	@Test
	public void doHello() throws Exception {
		final Hello h;
		{
			final HelloImpl impl = new HelloImpl();
			impl.setHelloString("ABC");
			h = impl;
		}
		final SayHello parameters = new SayHello();
		parameters.setIn("abc");
		final SayHelloResponse sayHello = h.sayHello(parameters);
		Assert.assertEquals("{{ABCabc", sayHello.getOut());
	}

	@Test
	public void doNothing() {
		Assert.assertTrue(true);
	}
}
