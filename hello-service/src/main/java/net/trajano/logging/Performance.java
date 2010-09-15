package net.trajano.logging;

import java.text.MessageFormat;

import javax.interceptor.AroundInvoke;
import javax.interceptor.InvocationContext;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class Performance {
	/**
	 * Logger.
	 */
	private final Log log = LogFactory.getLog(Performance.class);

	// private final ThreadLocal<Long> startTimeInMilli = new
	// ThreadLocal<Long>();
	@AroundInvoke
	public Object log(final InvocationContext i) throws Exception {
		final long t0 = System.currentTimeMillis();
		try {
			return i.proceed();
		} finally {
			final long t1 = System.currentTimeMillis();
			log.info(MessageFormat.format("{0}.{1} {2}ms", i.getMethod()
					.getDeclaringClass().getName(), i.getMethod().getName(), t1
					- t0));
		}
	}
}
