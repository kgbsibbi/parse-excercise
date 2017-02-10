package com.kaispring.structures;

public class DataProto extends Node{
	
	public int parse(int[] message, int startIndex) {
		parsedValue = message[startIndex++];
		parsedString = String.valueOf(parsedValue);
		length = message[startIndex++];
		
		infoString += "data-proto-id=" + parsedValue;
		
		switch(parsedValue){
		case 0:
			break;
		case 20601:
		default:
			children.add(new PhdAssociationInformation());
			break;
		case 65535:
			break;
		}
		
		for(int i=0; i < children.size(); i++)
		{
			startIndex = children.get(i).parse(message, startIndex);
		}
		return startIndex + 4;
	}
}
