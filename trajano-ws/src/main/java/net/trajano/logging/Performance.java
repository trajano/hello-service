package net.trajano.logging;

import java.text.MessageFormat;

import javax.xml.ws.handler.LogicalHandler;
import javax.xml.ws.handler.LogicalMessageContext;
import javax.xml.ws.handler.MessageContext;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * <p>
 * Provides performance metrics per method. Spring has its own as well, this is
 * provided as an example for people to implement their own AOP method based
 * logger.
 * </p>
 * 
 * @author Archimedes Trajano <arch@trajano.net>
 * 
 */
public class Performance implements LogicalHandler<LogicalMessageContext> {
	/**
	 * Logger.
	 */
	private final Log logger = LogFactory.getLog(this.getClass());

	/**
	 * Start time.
	 */
	private ThreadLocal<Long> startTime;


	@Override
	public boolean handleMessage(LogicalMessageContext messagecontext) {
		if ((Boolean) messagecontext
				.get(MessageContext.MESSAGE_OUTBOUND_PROPERTY)) {
			final long t0 = startTime.get();
			final long t1 = System.currentTimeMillis();
			logger.info(MessageFormat.format("{0} {1}ms",
					messagecontext.get(MessageContext.WSDL_OPERATION), t1 - t0));
		} else {
			startTime.set(System.currentTimeMillis());
		}
		return true;
	}

	@Override
	public boolean handleFault(LogicalMessageContext messagecontext) {
		return handleMessage(messagecontext);
	}

	@Override
	public void close(MessageContext messagecontext) {

	}

}
