package org.example.helloservice.impl;

import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService
public class Cook {
	private String helloString;

	@WebMethod
	public String cookMe(String in) {
		System.out.println("got " + in);
		return helloString + in;
	}

	public String getHelloString() {
		return helloString;
	}

	public void setHelloString(final String helloString) {
		System.out.println("INJECTION INVOKED " + helloString);
		this.helloString = helloString;
	}
}
