package com.kaispring.structures;

import com.kaispring.types.BitString;

public class ProtocolVersion extends Node{
	
	public int parse(int[] message, int startIndex) {
		int bit = BitString.getBit(message[startIndex++], 16);
		int bit2 = BitString.getBit(message[startIndex++], 16);
		bit2+=8;
		if(bit != -1) parsedValue = bit;
		else parsedValue=bit2;
		infoString += "bit(" + parsedValue + "): ";
		
		switch(bit){
		case 0:
			parsedString = "IEEE 11073-20601-2008";
			break;
		case 1:
		default:
			parsedString = "IEEE 11073-20601a-2010";
			break;
		case 2:
			parsedString = "IEEE 11073-20601-2014";
			break;
		}
		infoString += parsedString;
		
		return startIndex;
	}
}
