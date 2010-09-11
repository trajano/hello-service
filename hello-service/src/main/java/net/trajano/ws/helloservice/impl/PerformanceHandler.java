package net.trajano.ws.helloservice.impl;

import java.text.MessageFormat;

import javax.xml.ws.handler.LogicalHandler;
import javax.xml.ws.handler.LogicalMessageContext;
import javax.xml.ws.handler.MessageContext;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PerformanceHandler implements
		LogicalHandler<LogicalMessageContext> {

	private final Log log = LogFactory.getLog(this.getClass());

	private final ThreadLocal<Long> startTimeInMilli = new ThreadLocal<Long>();

	@Override
	public void close(final MessageContext arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean handleFault(final LogicalMessageContext arg0) {
		return handleMessage(arg0);
	}

	@Override
	public boolean handleMessage(final LogicalMessageContext context) {
		if ((Boolean) context.get(MessageContext.MESSAGE_OUTBOUND_PROPERTY)) {
			final long t0 = startTimeInMilli.get();
			final long t1 = System.currentTimeMillis();
			log.info(MessageFormat.format("{0} {1}ms",
					context.get(MessageContext.WSDL_SERVICE), t1 - t0));
		} else {
			startTimeInMilli.set(System.currentTimeMillis());
		}
		return true;
	}

}
