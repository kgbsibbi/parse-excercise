package com.kaispring.structures;

import com.kaispring.types.BitString;

public class AssociationVersion extends Node {
	
	public int parse(int[] message, int startIndex) {
		parsedValue = BitString.getBit(message[startIndex], 16);
		parsedString = String.valueOf(parsedValue);
		
		infoString = "bit("+parsedValue+")-";
		switch(parsedValue){
		case 0:
			infoString+="Association Protocol Supported";
			break;
		default:
			infoString+="Association Protocol NOT Supported";
			break;
		}
		
		startIndex+=2;
		return startIndex;
	}
}
