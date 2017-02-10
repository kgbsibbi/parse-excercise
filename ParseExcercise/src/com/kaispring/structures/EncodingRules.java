package com.kaispring.structures;

import com.kaispring.types.BitString;

public class EncodingRules extends Node{
	
	public int parse(int[] message, int startIndex) {
		parsedValue = BitString.getBit(message[startIndex], 16);
		infoString += "bit(" + parsedValue + "): ";
		
		switch(parsedValue){
		case 0:
		default:
			parsedString = "mder";
			break;
		case 1:
			parsedString = "xer";
			break;
		case 2:
			parsedString = "per";
			break;
		}
		infoString += parsedString;
		
		startIndex+=1;
		return startIndex;
	}
}
