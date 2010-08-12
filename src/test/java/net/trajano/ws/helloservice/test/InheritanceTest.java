package net.trajano.ws.helloservice.test;

import org.junit.Assert;
import org.junit.Test;

public class InheritanceTest {

	static class A {
		private final String a = this.getClass().getName();

		public String getClassName() {
			return a;
		}

		public String getClassNameDynamic() {
			return this.getClass().getName();
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
	 * Tests the value of this.getClass() that is stored into a variable to
	 * prove the logger configuration.
	 */
	@Test
	public void thisGetGlass() {
		Assert.assertFalse(new A().getClassName()
				.equals(new B().getClassName()));
	}

	/**
	 * Tests the value of this.getClass() that is called to prove the logger
	 * configuration. Uses casting.
	 */
	@Test
	public void thisGetGlassCasted() {
		final A b = new B();
		Assert.assertFalse(new A().getClassNameDynamic().equals(
				b.getClassNameDynamic()));
	}

	/**
	 * Tests the value of this.getClass() that is called to prove the logger
	 * configuration.
	 */
	@Test
	public void thisGetGlassDynamic() {
		Assert.assertFalse(new A().getClassNameDynamic().equals(
				new B().getClassNameDynamic()));
	}
}
