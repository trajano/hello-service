package net.trajano.ws.helloservice.test;

import javax.xml.ws.BindingProvider;

import junit.framework.Assert;
import net.trajano.ws.helloservice.Hello;
import net.trajano.ws.helloservice.HelloService;
import net.trajano.ws.helloservice.SayHello;
import net.trajano.ws.helloservice.SayHelloResponse;

import org.junit.Ignore;
import org.junit.Test;

/**
 * These are Unit tests done on Glassfish. Ideally this class would be a
 * separate project as integration tests should be separate.
 * 
 * @author Archimedes Trajano <arch@trajano.net>
 * 
 */
@Ignore
public class GlassFishTest {

	/**
	 * This unit test shows how to connect to an arbitrary endpoint that is not
	 * defined in the WSDL. This is used when testing on Glassfish.
	 * 
	 * @throws Exception
	 */
	@Test
	public void switchEndpointForGlassfish() throws Exception {
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
