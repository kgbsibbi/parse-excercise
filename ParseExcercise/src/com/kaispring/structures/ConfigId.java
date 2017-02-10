package com.kaispring.structures;

public class ConfigId extends Node {
	
	public int parse(int[] message, int startIndex) {
		parsedValue = message[startIndex];
		infoString="value="+parsedValue+" ";
		
		if (parsedValue == 0)
			parsedString="manager-config-response";
		else if( parsedValue > 0 && parsedValue < 16384)
			parsedString+="standard-config";
		else if( parsedValue > 16383 && parsedValue < 32768)
			parsedString+="extended-config";
		else
			parsedString+="reserved";
		
		infoString+=parsedString;
		
		startIndex++;
		return startIndex;
	}
}
