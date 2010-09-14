package net.trajano.ws.helloservice.impl;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Produces;

@ApplicationScoped
public class DataProvider {
	@Produces
	@HelloString
	String getHelloString() {
		return "cdi";
	}
}
