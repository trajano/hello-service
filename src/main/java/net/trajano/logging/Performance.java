package net.trajano.logging;

import java.text.MessageFormat;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
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
public class Performance implements MethodInterceptor {
	/**
	 * Logger.
	 */
	private final Log log = LogFactory.getLog(this.getClass());

	/**
	 * Takes the start and end time and logs it.
	 */
	@Override
	public Object invoke(final MethodInvocation invocation) throws Throwable {
		final long t0 = System.currentTimeMillis();
		try {
			System.out.println("XXX");
			return invocation.proceed();
		} finally {
			final long t1 = System.currentTimeMillis();
			log.info(MessageFormat.format("{0}.{1} {2}ms", invocation
					.getMethod().getDeclaringClass().getName(), invocation
					.getMethod().getName(), t1 - t0));
		}
	}

}
