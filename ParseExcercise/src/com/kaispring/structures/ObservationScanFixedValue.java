package com.kaispring.structures;

public class ObservationScanFixedValue extends Node {
	public int parse(int[] message, int startIndex) { 
		children.add(new Handle());
		startIndex = children.get(0).parse(message, startIndex);
		
		length = message[startIndex++];

		children.add(new SimpleNuObservedValue());
		children.add(new AbsoluteTimeStamp());
		for(int i=1; i < children.size(); i++)
			startIndex = children.get(i).parse(message, startIndex);
		return startIndex;
	}
}
