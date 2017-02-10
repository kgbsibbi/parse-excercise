package com.kaispring.structures;

public class OCTETString extends Node {
	
	public int parse(int[] message, int startIndex) {
		length = message[startIndex++];
		parsedValue=length;
		for(int i=0; i < (length/2); i++){
			char first = (char)(message[startIndex+i] >> 8);
			char second = (char)(message[startIndex+i] & 0xFF );
			parsedString += first;
			parsedString += second;
		}
		infoString = parsedString;
		startIndex+=(length/2);
		return startIndex;
	}
}
