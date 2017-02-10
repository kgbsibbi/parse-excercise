package com.kaispring.structures;

public class INT16 extends Node {
	private String valueName;
	public INT16(){
		super();
	}
	public INT16(String valueName){
		super();
		this.valueName = valueName;
	}
	
	
	public int parse(int[] message, int startIndex) { 
		parsedValue = message[startIndex++];
		parsedString = String.valueOf(parsedValue);
		infoString = valueName+"="+parsedValue;
		return startIndex;
	}

}
