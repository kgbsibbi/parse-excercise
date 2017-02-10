package com.kaispring.structures;

public class DataReqMode extends Node {
	
	public int parse(int[] message, int startIndex){
		parsedValue = message[startIndex];
		
		parsedString="data-req-";
		
		if(parsedValue == 0)
			parsedString += "start";
		else if(parsedValue == 1)
			parsedString += "stop";
		else
			parsedString += "undefined";
		infoString = parsedString;
		startIndex++;
		return startIndex;
	}
}
