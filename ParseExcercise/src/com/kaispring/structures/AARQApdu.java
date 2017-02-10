package com.kaispring.structures;

public class AARQApdu extends Node {
	
	public int parse(int[] message, int startIndex) { 
		children.add(new AssociationVersion());
		children.add(new DataProtoList());
		
		for(int i=0; i < children.size(); i++){
			startIndex = children.get(i).parse(message, startIndex);
		}
		return startIndex;
	}
}
