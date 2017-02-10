package com.kaispring.out;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;


import com.kaispring.structures.Node;

public class XML {
	DocumentBuilderFactory docFactory;
	DocumentBuilder docBuilder;
	File file;
	Document doc;
	
	public XML(Node head){
		try {
			docFactory = DocumentBuilderFactory.newInstance();
			docBuilder = docFactory.newDocumentBuilder();
			doc = docBuilder.newDocument();
			try{
			file = new File("C:\\Tmp\\file.xml");
			if(!file.exists())
				file.createNewFile();
			}catch (IOException e) { e.printStackTrace(); }
			
			Element element = doc.createElement(head.getName());
			element.setAttribute("value", String.valueOf(head.getParsedValue()));
			element.setAttribute("meaning", head.getParsedString());
			doc.appendChild(element);
			addChild(head.getChildren().get(0), element);
			
			// write the content into xml file
			TransformerFactory transformerFactory = TransformerFactory.newInstance();
			Transformer transformer = transformerFactory.newTransformer();
			DOMSource source = new DOMSource(doc);
			StreamResult result = new StreamResult(file);

			// Output to console for testing
			//StreamResult result = new StreamResult(System.out);

			transformer.transform(source, result);

			System.out.println("File saved!");
			
		} catch (ParserConfigurationException pce) {
			pce.printStackTrace();
		} catch (TransformerException tfe) {
			tfe.printStackTrace();
		}
	}
	
	public void addChild(Node node, Element parent){
		Element element = doc.createElement(node.getName());
		element.setAttribute("raw_value", String.valueOf(node.getParsedValue()));
		if(node.getLength()>0)
			element.setAttribute("length", String.valueOf(node.getLength()));
		if(node.getParsedString().length()>0)
			element.setAttribute("parsed_value", node.getParsedString());
		if(node.getInfoString().length()>0)
			element.setAttribute("info", node.getInfoString());
		parent.appendChild(element);
		
		if(node.getChildren() != null && node.getChildren().size() > 0){
			for(Node child : node.getChildren())
			{
				addChild(child, element);
			}
		}
	}
}
