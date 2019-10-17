package com.kakinari.core.xml;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.StringReader;

import javax.xml.namespace.QName;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

public class XMLDocument {
	public static Document getDocument() 
			throws SAXException, IOException, ParserConfigurationException {
		return getBuilder().newDocument();
	}

	public static Document getDocument(String context) 
			throws SAXException, IOException, ParserConfigurationException {
		return getBuilder().parse(new InputSource(new StringReader(context)));
	}
	
	public static Document getDocument(File file) 
			throws SAXException, IOException, ParserConfigurationException {
		return getBuilder().parse(file);
	}

	public static Document getDocument(InputSource source) 
			throws SAXException, IOException, ParserConfigurationException {
		return getBuilder().parse(source);
	}

	public static Document getDocument(InputStream istream) 
			throws SAXException, IOException, ParserConfigurationException {
		return getBuilder().parse(istream);
	}
	
	public static Document getDocumentFromURI(String uri) 
			throws SAXException, IOException, ParserConfigurationException {
		return getBuilder().parse(uri);
	}
	
	public static Boolean searchBoolean(Object context, String pattern) throws XPathExpressionException {
		return (Boolean) searchQName(context, pattern, XPathConstants.BOOLEAN);
	}

	public static String searchString(Object context, String pattern) throws XPathExpressionException {
		return (String) searchQName(context, pattern, XPathConstants.STRING);
	}
	public static Node searchNode(Object context, String pattern) throws XPathExpressionException {
		return (Node) searchQName(context, pattern, XPathConstants.NODE);
	}

	public static NodeList searchNodeList(Object context, String pattern) throws XPathExpressionException {
		return (NodeList) searchQName(context, pattern, XPathConstants.NODESET);
	}

	public static Double searchNumber(Object context, String pattern) throws XPathExpressionException {
		return (Double) searchQName(context, pattern, XPathConstants.NUMBER);
	}
	
	private static Object searchQName(Object context, String pattern, QName datatype) throws XPathExpressionException {
		return (context != null && pattern != null) ? 
				XPathFactory
					.newInstance()
					.newXPath()
					.compile(pattern)
					.evaluate(context, datatype) : null;
	}

	private static DocumentBuilder getBuilder() throws ParserConfigurationException {
		return DocumentBuilderFactory
						.newInstance()
						.newDocumentBuilder();
	}
}
