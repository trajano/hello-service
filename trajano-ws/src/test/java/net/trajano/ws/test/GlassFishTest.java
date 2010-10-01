package net.trajano.ws.test;

import javax.xml.ws.BindingProvider;

import net.trajano.ws.helloservice.Hello;
import net.trajano.ws.helloservice.HelloService;
import net.trajano.ws.schema.business.BaseType;
import net.trajano.ws.schema.business.DerivedType;

import org.junit.Assert;
import org.junit.Test;

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
				"http://localhost:8080/trajano-ws/HelloImplService");
		final BaseType parameters = new BaseType();
		parameters.setMessage("abc");
		final DerivedType sayHello = h.sayHello(parameters);
		Assert.assertEquals("{{HelloStrinCXFabc", sayHello.getSomeOther());
	}
}