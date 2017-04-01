package kr.ac.knu.structures;

import java.util.ArrayList;

public class EventInfo extends Node {
	private Choice choice;
	
	public EventInfo(){
		name="EventInfo";
		
		choice = new Choice();
		choice.addOption(0x0D1D, ScanReportInfoFixed.class);
	}
	
	public EventInfo(int eventType){
		name="EventInfo(" + eventType + ")";
		parsedValue = eventType;
		children = new ArrayList<>();
		
		choice = new Choice();
		choice.addOption(0x0D1D, ScanReportInfoFixed.class);
	}
	
	public int parse(char[] message, int startIndex){
		Node node = choice.getSelected(parsedValue);
		if(node != null){
			children.add(node);
			startIndex = node.parse(message, startIndex);
		}
		return startIndex;
	}
}
