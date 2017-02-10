package com.kaispring.structures;

public class RelativeTime extends Node {
	
	public int parse(int[] message, int startIndex) {

		int value1 = message[startIndex++];
		int value2 = message[startIndex++];
		
		if(value1 == 0xFFFF && value2 == 0xFFFF){
			// not supported
			parsedValue = 0;
			parsedString=String.valueOf(parsedValue);
		} else {
			parsedString="event-time="+value1+""+value2;
		}
		infoString = "event-time=" + parsedString;
		return startIndex;
	}
}
