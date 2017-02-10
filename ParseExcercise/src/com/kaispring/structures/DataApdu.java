package com.kaispring.structures;


import com.kaispring.types.Choice;

public class DataApdu extends Node{
	private Choice choice;
	
	public DataApdu(){
		super();
		choice = new Choice();
		choice.addOption(0x0100, EventReportArgumentSimple.class);
		choice.addOption(0x0101, EventReportArgumentSimple.class);
		choice.addOption(0x0300, ErrorResult.class);
		choice.addOption(0x0400, RejectResult.class);
	}
	
	public int parse(int[] message, int startIndex) {
		// parse length
		length = message[startIndex++];
		
		// parse invoke id
		children.add(new InvokeID());
		startIndex = children.get(0).parse(message, startIndex);
		
		// process choice
		parsedValue=message[startIndex++];
		Node node = choice.getSelected(parsedValue);
		parsedString=node.getName();
		infoString = "CHOICE="+parsedString;
		
		if(node != null ){
			children.add(node);
			startIndex = children.get(1).parse(message, startIndex);
		}
		return startIndex;
	}
}
