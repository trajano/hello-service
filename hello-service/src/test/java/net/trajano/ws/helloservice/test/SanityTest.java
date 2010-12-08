package net.trajano.ws.helloservice.test;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import net.trajano.ws.helloservice.SayHelloFault;
import net.trajano.ws.helloservice.impl.Configurable;
import net.trajano.ws.helloservice.impl.Hello;

import org.junit.Assert;
import org.junit.Test;
import org.w3c.dom.Document;

import sun.reflect.generics.tree.BaseType;

public class SanityTest {
	@Test(expected = SayHelloFault.class)
	public void doFault() throws Exception {
		final Hello h;
		{
			final Hello impl = new Hello();
			impl.setHelloString("ABC");
			impl.setConfigurable(new Configurable());
			h = impl;
		}

		final net.trajano.ws.helloservice.impl.BaseType parameters;
		h.sayHello(parameters);
	}

	@Test
	public void doHello() throws Exception {
		final Hello h;
		{
			final Hello impl = new Hello();
			impl.setHelloString("ABC");
			impl.setConfigurable(new Configurable());
			h = impl;
		}
		final BaseType parameters = new DerivedType();
		parameters.setMessage("abc");
		final DerivedType resp = h.sayHello(parameters);
		Assert.assertEquals("{{ABCabc", resp.getSomeOther());
	}

	@Test
	public void doNothing() {
		Assert.assertTrue(true);
	}

	@Test
	public void xmlCompare() throws Exception {

		final DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		dbf.setNamespaceAware(true);
		dbf.setCoalescing(true);
		dbf.setIgnoringElementContentWhitespace(true);
		dbf.setIgnoringComments(true);
		final DocumentBuilder db = dbf.newDocumentBuilder();

		final Document doc1 = db.parse(getClass().getResourceAsStream(
				"/cxf-beans.xml"));
		doc1.getDomConfig().setParameter("element-content-whitespace", false);
		doc1.normalizeDocument();

		final Document doc2 = db.parse(getClass().getResourceAsStream(
				"/cxf-beans2.xml"));
		doc2.getDomConfig().setParameter("element-content-whitespace", false);
		doc2.normalizeDocument();

		Assert.assertTrue(doc1.isEqualNode(doc2));
	}
}
