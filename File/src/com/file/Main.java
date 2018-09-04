package com.file;

import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;

public class Main {
public static void main(String[] args) throws ClassNotFoundException {
	System.out.println("Reading xml file");
	CallingXml ref= new CallingXml();
	
	try {
		ref.display();
	} catch (IOException | SAXException | ParserConfigurationException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	System.out.println("\n\nreading csv file");
	CsvReader ref2 = new CsvReader();
	
	ref2.display2();
	
}
}
