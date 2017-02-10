package com.kaispring.structures;

import com.kaispring.types.BitString;

public class FunctionalUnits extends Node {
	
	public int parse(int[] message, int startIndex) {
		int bit1 = BitString.getBit(message[startIndex++], 16);
		int bit2 = BitString.getBit(message[startIndex++], 16);
		bit2+=8;
		if(bit1 != -1) parsedValue = bit1;
		else parsedValue=bit2;
		infoString += "bit(" + parsedValue + "): ";
		
		if(parsedValue == 0 )
			parsedString="fun-units-unindirectional";
		else if(parsedValue == 1 )
			parsedString="fun-units-havetestcap";
		else if( parsedValue == 2)
			parsedString="fun-units-createtestassoc";
		else
			parsedString="undefined";
		
		infoString += parsedString;
		
		return startIndex;
	}
}
