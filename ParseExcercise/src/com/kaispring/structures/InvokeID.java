package com.kaispring.structures;

public class InvokeID extends Node {
	
	public int parse(int[] message, int startIndex) {
		parsedValue = message[startIndex];
		parsedString = String.valueOf(parsedValue);
		infoString="invoke-id="+parsedValue+" ";
		
		startIndex++;
		return startIndex;
	}
}
