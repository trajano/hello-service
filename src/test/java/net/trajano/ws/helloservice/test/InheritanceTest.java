package net.trajano.ws.helloservice.test;

import org.junit.Assert;
import org.junit.Test;

public class InheritanceTest {

	static class A {
		private final String a = this.getClass().getName();

		public String getClassName() {
			return a;
		}
	}

	static class B extends A {
		private final String a = this.getClass().getName();

		@Override
		public String getClassName() {
			return a;
		}
	}

	/**
	 * Tests the value of this.getClass() to prove the logger configuration.
	 */
	@Test
	public void thisGetGlass() {
		Assert.assertFalse(new A().getClassName()
				.equals(new B().getClassName()));
	}
}
