package net.trajano.ws.helloservice.impl;

import javax.ejb.Stateless;
import javax.jws.WebService;

import net.trajano.ws.helloservice.SayHelloFault;
import net.trajano.ws.schema.business.BaseType;
import net.trajano.ws.schema.business.DerivedType;
import net.trajano.ws.schema.common.ApplicationFaultType;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Required;

@Stateless
@WebService(targetNamespace = "http://ws.trajano.net/HelloService/", endpointInterface = "net.trajano.ws.helloservice.Hello", wsdlLocation = "Hello.wsdl")
public class Hello implements net.trajano.ws.helloservice.Hello {

	/**
	 * Injected value.
	 */
	private String helloString;

	/**
	 * <p>
	 * Logger. Personal preference is to use private final non-static loggers.
	 * Current logging frameworks do not make a preference for either. Here are
	 * my reasons:
	 * </p>
	 * <ul>
	 * <li><code>private</code>, as opposed to <code>protected</code> ensures
	 * that the scope of the logger object does not go outside the class. The
	 * logger I use for development and debugging should only log for itself,
	 * not its subclasses. It also prevents namespace pollution.</li>
	 * <li><code>final</code>, since I do not intend to change the logger I use
	 * for the lifetime of the object.</li>
	 * <li>non-<code>static</code>, this helps prevent any class loading issues
	 * that may or may not be present in the logging framework I am using.
	 * Although there is a penalty for object creation, the cost of creation is
	 * going to be less than the headaches someone may have to deal with when
	 * running in a shared class loader environment.</li>
	 * </ul>
	 */
	private final Log log = LogFactory.getLog(this.getClass());

	public String getHelloString() {
		return helloString;
	}

	@Override
	public DerivedType sayHello(final BaseType parameters) throws SayHelloFault {
		log.debug("Saying Hello");
		if ("fault".equals(parameters.getOtherElement())) {
			throw new SayHelloFault("got a hello fault",
					new ApplicationFaultType());
		}
		final DerivedType r = new DerivedType();
		r.setSomeOther("{{" + getHelloString() + parameters.getMessage());
		return r;
	}

	@Required
	public void setHelloString(final String helloString) {
		log.debug("Injecting helloString = " + helloString);
		this.helloString = helloString;
	}

}
