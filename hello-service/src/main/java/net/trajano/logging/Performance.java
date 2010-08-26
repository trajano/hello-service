package net.trajano.logging;

import java.text.MessageFormat;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.aspectj.lang.ProceedingJoinPoint;

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
public class Performance {
	/**
	 * Logger.
	 */
	private final Log logger = LogFactory.getLog(this.getClass());

	/**
	 * Takes the start and end time and logs it.
	 */
	public Object log(final ProceedingJoinPoint joinPoint) throws Throwable {
		final long t0 = System.currentTimeMillis();
		try {
			return joinPoint.proceed();
		} finally {
			final long t1 = System.currentTimeMillis();
			logger.info(MessageFormat.format("{0}.{1} {2}ms", joinPoint
					.getSignature().getDeclaringTypeName(), joinPoint
					.getSignature().getName(), t1 - t0));
		}
	}

}
