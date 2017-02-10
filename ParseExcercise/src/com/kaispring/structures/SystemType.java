package com.kaispring.structures;

import com.kaispring.types.BitString;

public class SystemType extends Node {
	
	public int parse(int[] message, int startIndex) {
		parsedValue = BitString.getBit(message[startIndex], 16);
		infoString += "bit(" + parsedValue + "): ";
		
		if(parsedValue == 8 )
			parsedString ="agent";
		else if(parsedValue == 0)
			parsedString ="manager";
		else
			parsedString ="undefined";
		
		infoString += parsedString;
		
		startIndex+=2;
		return startIndex;
	}
}
