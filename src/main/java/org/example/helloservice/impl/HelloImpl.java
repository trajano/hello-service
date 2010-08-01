package org.example.helloservice.impl;

import javax.jws.WebService;

import net.trajano.ws.helloservice.Hello;
import net.trajano.ws.helloservice.SayHello;
import net.trajano.ws.helloservice.SayHelloResponse;

@WebService()
public class HelloImpl implements Hello {

	private String helloString;

	public String getHelloString() {
		return helloString;
	}

	public void setHelloString(final String helloString) {
		System.out.println("INJECTION INVOKED " + helloString);
		this.helloString = helloString;
	}

	@Override
	public SayHelloResponse sayHello(SayHello parameters) {
		System.out.println("got " + parameters.getIn() + " for object "
				+ this.hashCode());
		SayHelloResponse r = new SayHelloResponse();
		r.setOut("{{" + getHelloString() + parameters.getIn());
		return r;
	}

}
