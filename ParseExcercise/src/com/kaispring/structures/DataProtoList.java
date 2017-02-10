package com.kaispring.structures;


public class DataProtoList extends Node{
	
	public int parse(int[] message, int startIndex) {
		parsedValue = message[startIndex++];
		parsedString = String.valueOf(parsedValue);
		length = message[startIndex++];
		
		infoString += "data-proto-list.count=" + parsedValue;
		
		for(int i=0; i < parsedValue; i++){
			children.add(new DataProto());
			startIndex = children.get(i).parse(message, startIndex);
		}
		
		return startIndex;
	}
}
