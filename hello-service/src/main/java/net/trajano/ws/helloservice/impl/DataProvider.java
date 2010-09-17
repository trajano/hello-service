package net.trajano.ws.helloservice.impl;

import javax.decorator.Decorator;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Produces;

import net.trajano.ws.helloservice.annotations.HelloString;
import net.trajano.ws.helloservice.annotations.Mock;

/**
 * <p>
 * Try the following out: Instead of iterating through a list of something to
 * use {@link Decorator} annotation?
 * </p>
 * <p>
 * Composites still cannot be done though.
 * </p>
 * 
 * @author Archimedes Trajano <arch@trajano.net>
 * 
 */

@ApplicationScoped
public class DataProvider {
	@Produces
	@HelloString
	String getHelloString() {
		return "cdi";
	}

	@Produces
	Long long1() {
		return 1L;
	}

	@Produces
	Long long10() {
		return 10L;
	}

	@Produces
	Long long2() {
		return 2L;
	}

	@Produces
	@Mock
	Long long3() {
		return 3L;
	}

	@Produces
	Long long4() {
		return 4L;
	}
}
