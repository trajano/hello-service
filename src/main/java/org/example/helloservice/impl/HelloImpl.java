package org.example.helloservice.impl;

import net.trajano.ws.helloservice.Hello;
import net.trajano.ws.helloservice.SayHello;
import net.trajano.ws.helloservice.SayHelloResponse;

public class HelloImpl implements Hello {

	private String helloString;

	public String getHelloString() {
		return helloString;
	}

	@Override
	public SayHelloResponse sayHello(final SayHello parameters) {
		System.out.println("got " + parameters.getIn() + " for object "
				+ hashCode());
		final SayHelloResponse r = new SayHelloResponse();
		r.setOut("{{" + getHelloString() + parameters.getIn());
		return r;
	}

	public void setHelloString(final String helloString) {
		System.out.println("INJECTION INVOKED " + helloString);
		this.helloString = helloString;
	}

}
