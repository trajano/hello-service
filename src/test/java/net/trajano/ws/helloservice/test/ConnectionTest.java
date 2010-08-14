package net.trajano.ws.helloservice.test;

import javax.xml.ws.BindingProvider;

import junit.framework.Assert;
import net.trajano.ws.helloservice.Hello;
import net.trajano.ws.helloservice.HelloService;
import net.trajano.ws.helloservice.SayHello;
import net.trajano.ws.helloservice.SayHelloResponse;
import net.trajano.ws.helloservice.impl.HelloImpl;

import org.apache.cxf.endpoint.Server;
import org.apache.cxf.frontend.ServerFactoryBean;
import org.apache.cxf.jaxws.JaxWsServerFactoryBean;
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
	public void testSomething() throws Exception {

		// Create an HTTP endpoint
		final ServerFactoryBean sfb = new JaxWsServerFactoryBean();
		sfb.setServiceClass(HelloImpl.class);
		sfb.setAddress("http://localhost:9001/Hello");
		// sfb.setDestinationFactory(destinationFactory)
		final Server server = sfb.create();

		final HelloService helloService = new HelloService();
		final Hello h = helloService.getDevPort();
		final SayHello parameters = new SayHello();
		parameters.setIn("abc");
		final SayHelloResponse sayHello = h.sayHello(parameters);
		Assert.assertEquals("{{HelloStrinCXFabc", sayHello.getOut());
	}

	/**
	 * This unit test shows how to connect to an arbitrary endpoint that is not
	 * defined in the WSDL.
	 * 
	 * @throws Exception
	 */
	@Test
	public void testSomethingElse() throws Exception {
		final HelloService helloService = new HelloService();
		final Hello h = helloService.getDevPort();
		((BindingProvider) h).getRequestContext().put(
				BindingProvider.ENDPOINT_ADDRESS_PROPERTY,
				"http://localhost:8080/hello-service/hello");
		final SayHello parameters = new SayHello();
		parameters.setIn("abc");
		final SayHelloResponse sayHello = h.sayHello(parameters);
		Assert.assertEquals("{{HelloStrinCXFabc", sayHello.getOut());
	}
}
