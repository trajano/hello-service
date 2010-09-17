package net.trajano.ws.helloservice.impl;

import java.io.Serializable;

import javax.inject.Inject;

import net.trajano.ws.helloservice.annotations.Mock;

@SuppressWarnings("serial")
public class Configurable implements Serializable {
	@Inject
	@Mock
	private Long long10;

	public Long getLong10() {
		return long10;
	}

	void setLong10(final Long long10) {
		this.long10 = long10;
	}
}
