package com.kaispring.structures;

public class DataReqId extends Node {

	public int parse(int[] message, int startIndex){
		parsedValue = message[startIndex++];
		parsedString = String.valueOf(parsedValue);
		infoString=parsedString;
		
		int manager_initiated_min = 0;
		int manager_initiated_max = 0xEFFF; //61439;
		if(parsedValue >= manager_initiated_min && parsedValue <= manager_initiated_max)
			infoString+= ":manager-initiated measurement data transmission";
		else if(parsedValue == 0xF000)
			infoString += ":data-req-id-agent-initiated-confirmed";
		else if(parsedValue == 0xF001)
			infoString += ":data-req-id-agent-initiated-unconfirmed";
		
		return startIndex;
	}
}
