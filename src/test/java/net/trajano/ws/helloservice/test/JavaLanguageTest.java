package net.trajano.ws.helloservice.test;

import java.util.UUID;
import java.util.regex.Pattern;

import org.junit.Assert;
import org.junit.Test;

/**
 * These are tests on how the Java language and their APIs work.
 * 
 * @author Archimedes Trajano <arch@trajano.net>
 * 
 */
public class JavaLanguageTest {

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

	/**
	 * Checks if the UUID pattern matches.
	 */
	@Test
	public void uuidTest() {
		System.out.println(UUID.randomUUID().toString());
		System.out.println("12345678-1234-1234-1234-123456789012");
		Assert.assertTrue(Pattern
				.matches(
						"^[0-9a-f]{8}\\-[0-9a-f]{4}\\-[0-9a-f]{4}\\-[0-9a-f]{4}\\-[0-9a-f]{12}$",
						UUID.randomUUID().toString()));

	}
}
