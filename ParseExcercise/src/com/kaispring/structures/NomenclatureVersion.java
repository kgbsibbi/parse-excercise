package com.kaispring.structures;

import com.kaispring.types.BitString;

public class NomenclatureVersion extends Node {
	
	public int parse(int[] message, int startIndex) {
		parsedValue = BitString.getBit(message[startIndex], 16);
		infoString="bit("+parsedValue+") - ";
		
		if(parsedValue ==0 )
			parsedString="Nomenclature supported";
		else
			parsedString="Nomenclature undefined";
		
		infoString+=parsedString;
		
		startIndex+=2;
		return startIndex;
	}
}
