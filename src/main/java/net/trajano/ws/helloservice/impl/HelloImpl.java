package net.trajano.ws.helloservice.impl;

import net.trajano.ws.helloservice.Hello;
import net.trajano.ws.helloservice.SayHello;
import net.trajano.ws.helloservice.SayHelloResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Required;

public class HelloImpl implements Hello {

	private String helloString;
	private final Log log = LogFactory.getLog(HelloImpl.class);

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
		log.debug("Injecting helloString = " + helloString);
		this.helloString = helloString;
	}

}
