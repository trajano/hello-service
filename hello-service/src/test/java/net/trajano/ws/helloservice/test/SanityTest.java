package net.trajano.ws.helloservice.test;

import net.trajano.ws.helloservice.Hello;
import net.trajano.ws.helloservice.SayHelloFault;
import net.trajano.ws.helloservice.impl.HelloImpl;
import net.trajano.ws.schema.business.BaseType;
import net.trajano.ws.schema.business.DerivedType;

import org.junit.Assert;
import org.junit.Test;

public class SanityTest {
	@Test(expected = SayHelloFault.class)
	public void doFault() throws Exception {
		final Hello h;
		{
			final HelloImpl impl = new HelloImpl();
			impl.setHelloString("ABC");
			h = impl;
		}
		final BaseType parameters = new DerivedType();
		parameters.setOtherElement("fault");
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
		final BaseType parameters = new DerivedType();
		parameters.setMessage("abc");
		final DerivedType resp = h.sayHello(parameters);
		Assert.assertEquals("{{ABCabc", resp.getSomeOther());
	}

	@Test
	public void doNothing() {
		Assert.assertTrue(true);
	}
}
