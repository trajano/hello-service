package net.trajano.ws.helloservice.test;

import java.io.IOException;
import java.io.StringWriter;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;

import net.trajano.ws.schema.business.LessChoicesType;
import net.trajano.ws.schema.business.ObjectFactory;
import net.trajano.ws.schema.business.TryOut;

import org.junit.Assert;
import org.junit.Test;
import org.xml.sax.SAXException;

/**
 * Tests against the XSD schemas
 * 
 * @author Archimedes Trajano <arch@trajano.net>
 * 
 */
public class TryOutSchemaTest {
	/**
	 * Object factory used.
	 */
	private final ObjectFactory businessObjectFactory = new ObjectFactory();

	@Test
	public void choices() throws Exception {
		final TryOut o = businessObjectFactory.createTryOut();
		final LessChoicesType lessChoicesType = new LessChoicesType();
		lessChoicesType.setD("ABC");
		o.setLessChoices(lessChoicesType);
		marshal(o);
	}

	/**
	 * This turns the marshalled version of the {@link TryOut} object. It also
	 * performs a validation to make sure what was build validates against the
	 * schema.
	 * 
	 * @param o
	 * @return
	 * @throws JAXBException
	 * @throws SAXException
	 * @throws IOException
	 */
	private String marshal(final TryOut o) throws JAXBException, SAXException,
			IOException {
		final Marshaller m = JAXBContext.newInstance(TryOut.class)
				.createMarshaller();
		final Schema schema = SchemaFactory.newInstance(
				"http://www.w3.org/2001/XMLSchema").newSchema(
				getClass().getResource("/META-INF/wsdl/business.xsd"));
		m.setSchema(schema);
		final StringWriter writer = new StringWriter();
		m.marshal(o, writer);
		writer.close();
		return writer.toString();
	}

	@Test
	public void nothing() throws Exception {
		final TryOut o = businessObjectFactory.createTryOut();
		Assert.assertEquals(
				"<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>"
						+ "<ns2:TryOut xmlns:ns2=\"http://ws.trajano.net/schema/business\"/>",
				marshal(o));

	}
}