package com.kaispring.structures;

public class Handle extends Node {
	
	public int parse(int[] message, int startIndex) { 
		parsedValue = message[startIndex++];
		
		
		switch(parsedValue){
		case 0:
			parsedString="MDS Object";break;
		default:
			parsedString=String.valueOf(parsedValue);
		}
		infoString="obj-handle="+parsedString;
		
		return startIndex;
	}
}
