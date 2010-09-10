package net.trajano.logging;

import javax.jws.WebService;

@WebService(wsdlLocation = "WEB-INF/wsdl/SimpleServiceService.wsdl")
public class SimpleService {
	public long add(long a, long b) {
		System.out.println("adding " + a + " and " + b);
		return a + b;
	}
}
