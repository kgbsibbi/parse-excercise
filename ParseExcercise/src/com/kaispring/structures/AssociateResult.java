package com.kaispring.structures;

public class AssociateResult extends Node {
	
	public int parse(int[] message, int startIndex) {
		parsedValue = message[startIndex++];
		parsedString = String.valueOf(parsedValue);
		
		return startIndex;
	}
}
