package com.kaispring.structures;


public class EventReportArgumentSimple extends Node {
	
	public int parse(int[] message, int startIndex) {
		
		// parse length
		length = message[startIndex++];
		
		EventType event = new EventType();
		
		children.add(new Handle());
		children.add(new RelativeTime());
		children.add(event);
		
		for(int i=0; i < children.size(); i ++)
			startIndex = children.get(i).parse(message, startIndex);
		
		Node infoParameter = event.getEventInfoParameter();
		if(infoParameter != null){
			children.add(infoParameter);
			startIndex = infoParameter.parse(message, startIndex);
		}
		
		return startIndex;
	}

}
