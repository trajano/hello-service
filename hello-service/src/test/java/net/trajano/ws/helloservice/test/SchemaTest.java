package net.trajano.ws.helloservice.test;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.MarshalException;
import javax.xml.bind.Marshaller;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;

import net.trajano.ws.schema.business.DerivedCommonType;
import net.trajano.ws.schema.business.DerivedType;
import net.trajano.ws.schema.business.ObjectFactory;
import net.trajano.ws.schema.common.NestedType;

import org.junit.Test;

/**
 * Tests against the XSD schemas
 * 
 * @author Archimedes Trajano <arch@trajano.net>
 * 
 */
public class SchemaTest {
	/**
	 * Object factory used.
	 */
	private final ObjectFactory businessObjectFactory = new ObjectFactory();

	@Test
	public void containment() throws Exception {
		final DerivedCommonType derivedCommonType = businessObjectFactory
				.createDerivedCommonType();
		derivedCommonType.setGenericString("ABCDEF");
		final net.trajano.ws.schema.business.NestedType nestedType = new net.trajano.ws.schema.business.NestedType();
		nestedType.setNestedString("en-US");
		nestedType.getChained().add(new NestedType());
		derivedCommonType.setNested(nestedType);

		final JAXBElement<DerivedCommonType> derivation = businessObjectFactory
				.createDerivation(derivedCommonType);
		final Marshaller m = JAXBContext.newInstance(DerivedCommonType.class)
				.createMarshaller();
		final Schema schema = SchemaFactory.newInstance(
				"http://www.w3.org/2001/XMLSchema").newSchema(

		getClass().getResource("/META-INF/wsdl/business.xsd"));
		m.setSchema(schema);
		m.marshal(derivation, System.out);
	}

	@Test(expected = MarshalException.class)
	public void violation() throws Exception {
		final DerivedType p = new DerivedType();
		p.setMessage("longstring");
		final Marshaller m = JAXBContext.newInstance(DerivedType.class)
				.createMarshaller();
		final Schema schema = SchemaFactory.newInstance(
				"http://www.w3.org/2001/XMLSchema").newSchema(
				getClass().getResource("/META-INF/wsdl/business.xsd"));
		final JAXBElement<DerivedType> response = businessObjectFactory
				.createHelloResponse(p);
		m.setSchema(schema);
		m.marshal(response, System.out);
	}
}
