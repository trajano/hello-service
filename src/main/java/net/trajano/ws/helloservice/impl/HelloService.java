package net.trajano.ws.helloservice.impl;

import javax.jws.WebService;

import net.trajano.ws.helloservice.Hello;
import net.trajano.ws.helloservice.SayHello;
import net.trajano.ws.helloservice.SayHelloResponse;

import org.springframework.beans.factory.annotation.Required;

@WebService(name = "Hello", portName = "HelloPort", endpointInterface = "net.trajano.ws.helloservice.Hello", targetNamespace = "http://ws.trajano.net/HelloService/")
public class HelloService implements Hello {

	private String helloString;

	public String getHelloString() {
		return helloString;
	}

	@Override
	public SayHelloResponse sayHello(final SayHello parameters) {
		final SayHelloResponse r = new SayHelloResponse();
		r.setOut("{{" + getHelloString() + parameters.getIn());
		return r;
	}

	@Required
	public void setHelloString(final String helloString) {
		this.helloString = helloString;
	}

}
