package com.kaispring.structures;

public class PRSTApdu extends Node {
	
	public int parse(int[] message, int startIndex) { 
		children.add(new DataApdu());
		
		for(int i=0; i < children.size(); i++){
			startIndex = children.get(i).parse(message, startIndex);
		}
		return startIndex;
	}
}
