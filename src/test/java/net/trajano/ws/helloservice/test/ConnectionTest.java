package net.trajano.ws.helloservice.test;

import junit.framework.Assert;
import net.trajano.ws.helloservice.Hello;
import net.trajano.ws.helloservice.HelloService;
import net.trajano.ws.helloservice.SayHello;
import net.trajano.ws.helloservice.SayHelloResponse;

import org.apache.cxf.test.AbstractCXFSpringTest;
import org.junit.Test;

/**
 * These are tests that use Jetty. In order to run these tests, use
 * <code>mvn jetty:run</code> first.
 * 
 * @author Archimedes Trajano <arch@trajano.net>
 * 
 */
public class ConnectionTest extends AbstractCXFSpringTest {
	@Test
	public void doNothing() {

	}

	@Override
	protected String[] getConfigLocations() {
		return new String[] { "classpath:cxf-beans.xml" };
	}

	@Test
	public void getFromSpring() throws Exception {
		final HelloService helloService = new HelloService();
		final Hello h = helloService.getDevPort();
		final SayHello req = new SayHello();
		req.setIn("abc");
		final SayHelloResponse sayHello = h.sayHello(req);
		Assert.assertEquals("{{CxfTestabc", sayHello.getOut());
	}

}
