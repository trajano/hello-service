package net.trajano.ws.helloservice.itest;

import java.net.URL;

import javax.xml.namespace.QName;

import junit.framework.Assert;
import net.trajano.ws.helloservice.Hello;
import net.trajano.ws.helloservice.HelloService;
import net.trajano.ws.helloservice.SayHello;
import net.trajano.ws.helloservice.SayHelloResponse;

import org.junit.Test;

/**
 * These are tests that use Jetty. In order to run these tests, use
 * <code>mvn jetty:run</code> first.
 * 
 * @author Archimedes Trajano <arch@trajano.net>
 * 
 */
public class ConnectionTest {
	@Test
	public void testSomething() throws Exception {
		final Hello h = new HelloService(new URL(
				"http://localhost:8080/Hello/Hello?wsdl"), new QName(
				"http://ws.trajano.net/HelloService/", "HelloServiceService"))
				.getHelloPort();
		final SayHello parameters = new SayHello();
		parameters.setIn("abc");
		final SayHelloResponse sayHello = h.sayHello(parameters);
		Assert.assertEquals("{{HelloStrinCXFabc", sayHello.getOut());
	}
}
