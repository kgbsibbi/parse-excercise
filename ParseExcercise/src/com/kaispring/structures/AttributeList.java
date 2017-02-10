package com.kaispring.structures;

public class AttributeList extends Node {
	
	public int parse(int[] message, int startIndex){
		parsedValue = message[startIndex++];
		parsedString = String.valueOf(parsedValue);
		length= message[startIndex++];
		infoString+="count=" + parsedValue + ", length=" + length;
		
		return startIndex;
	}
}
