package com.kaispring.structures;

public class ObservationScanFixed extends Node {
	
	public int parse(int[] message, int startIndex) { 
		parsedValue = message[startIndex++]; // get count of items
		parsedString = String.valueOf(parsedValue);
		infoString="count="+parsedValue;
		
		length = message[startIndex++];
		
		for(int i=0; i < parsedValue; i++){
			children.add(new ObservationScanFixedValue());
			startIndex = children.get(i).parse(message, startIndex);
		}
		
		return startIndex;
	}
}
