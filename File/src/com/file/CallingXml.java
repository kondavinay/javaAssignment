package com.file;

import java.awt.List;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import com.file.CallingXml;
import com.file.ReadXmlFile2;

public class CallingXml extends DefaultHandler {
	private ReadXmlFile2 read;
	private String temp;
	private ArrayList<ReadXmlFile2> accList = new ArrayList<ReadXmlFile2>();

	public static void display() throws IOException, SAXException, ParserConfigurationException, ClassNotFoundException

	{

		SAXParserFactory spfac = SAXParserFactory.newInstance();

		SAXParser sp = spfac.newSAXParser();

		CallingXml handler = new CallingXml();

		sp.parse("C:\\Users\\Vinay Konda\\Desktop\\New folder (3)\\1\\filecode.XML", handler);

		handler.readList();
	}

	public void characters(char[] buffer, int start, int length) {
		temp = new String(buffer, start, length);
	}

	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
		temp = "";
		if (qName.equalsIgnoreCase("record")) {
			read = new ReadXmlFile2();
			read.setReference(attributes.getValue("reference"));

		}
	}

	public void endElement(String uri, String localName, String qName) throws SAXException {

		if (qName.equalsIgnoreCase("record")) {

			accList.add(read);

		} else if (qName.equalsIgnoreCase("accountNumber")) {
			read.setAccountNumber((temp));
		} else if (qName.equalsIgnoreCase("Description")) {
			read.setDescription((temp));
		} else if (qName.equalsIgnoreCase("startBalance")) {
			read.setStartBal((temp));
		} else if (qName.equalsIgnoreCase("mutation")) {
			read.setMutation((temp));
		}

		else if (qName.equalsIgnoreCase("endBalance")) {
			read.setEndBal((temp));
		}

	}

	private void readList() throws ClassNotFoundException, IOException {
		System.out.println("No of  the accounts in bank '" + accList.size() + "'.");
		Iterator<ReadXmlFile2> it = accList.iterator();
		while (it.hasNext()) {
			System.out.println(it.next().toString());
		}

		ReadXmlFile2[] use = accList.toArray(new ReadXmlFile2[accList.size()]);

		String[] input = new String[use.length];

		for (int i = 0; i < use.length; i++) {
			input[i] = use[i].getReference() + "," + use[i].getAccountNumber() + "," + use[i].getDescription() + ","
					+ use[i].getStartBal() + "," + use[i].getMutation() + "," + use[i].getEndBal();
		}

		ArrayList<String> tryme = new ArrayList<String>(Arrays.asList(input));

		for (String s1 : tryme) {
			System.out.println("Duplicates List " + s1);
		}

		

		RemoveDuplicate.method(tryme);

	}
}
