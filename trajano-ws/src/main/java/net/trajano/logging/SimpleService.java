package net.trajano.logging;

import javax.jws.WebService;

@WebService()
public class SimpleService {
	public long add(long a, long b) {
		System.out.println("adding " + a + " and " + b);
		return a + b;
	}
}
