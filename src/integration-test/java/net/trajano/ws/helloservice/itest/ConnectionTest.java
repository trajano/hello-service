package net.trajano.ws.helloservice.itest;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import javax.xml.ws.soap.SOAPBinding;

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
		final HelloService helloService = new HelloService();
		final Hello h = helloService.getDevPort();
		final SayHello parameters = new SayHello();
		parameters.setIn("abc");
		final SayHelloResponse sayHello = h.sayHello(parameters);
		Assert.assertEquals("{{HelloStrinCXFabc", sayHello.getOut());
	}

	@Test
	public void testSomethingElse() throws Exception {
		final Service helloService = Service.create(new QName(
				"http://ws.trajano.net/HelloService/"));
		helloService.addPort(new QName("http://ws.trajano.net/HelloService/",
				"GeronimoPort"), SOAPBinding.SOAP11HTTP_BINDING,
				"http://localhost:8080/Hello/Hello");
		final Hello h = helloService.getPort(new QName(
				"http://ws.trajano.net/HelloService/", "GeronimoPort"),
				Hello.class);
		final SayHello parameters = new SayHello();
		parameters.setIn("abc");
		final SayHelloResponse sayHello = h.sayHello(parameters);
		Assert.assertEquals("{{HelloStrinCXFabc", sayHello.getOut());
	}
}
