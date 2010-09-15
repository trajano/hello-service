package net.trajano.ws.helloservice.impl;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Produces;

import net.trajano.ws.helloservice.annotations.HelloString;

@ApplicationScoped
public class DataProvider {
	@Produces
	@HelloString
	String getHelloString() {
		return "cdi";
	}
}
