package net.trajano.logging;

import java.io.IOException;

import javax.annotation.Resource;
import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.xml.ws.WebServiceRef;

import net.trajano.ws.helloservice.Hello;
import net.trajano.ws.helloservice.HelloService;
import net.trajano.ws.helloservice.SayHelloFault;
import net.trajano.ws.helloservice.impl.HelloImpl;

public class InitServlet implements Servlet {

	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

	@Override
	public ServletConfig getServletConfig() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getServletInfo() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void init(final ServletConfig config) throws ServletException {
		System.out.println("INIT $Id$");
		try {
			hello.sayHello(null);
			// service.getDevPort().sayHello(null);
		} catch (Exception e) {
			e.printStackTrace();
			// throw new ServletException(e);
		}
	}

	@Resource(name = "net.trajano.ws.helloservice.impl.HelloImpl")
	private Hello hello;

	@Override
	public void service(ServletRequest arg0, ServletResponse arg1)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

	}

}
