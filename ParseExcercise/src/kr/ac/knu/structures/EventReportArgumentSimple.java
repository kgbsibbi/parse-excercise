package kr.ac.knu.structures;

public class EventReportArgumentSimple extends Node {
	public EventReportArgumentSimple(){
		name="EventReportArgumentSimple";
	}
	
	public int parse(char[] message, int startIndex){
		int i=0;
		
		children.add(new INT16("HANDLE"));
		children.add(new RelativeTime());
		children.add(new OIDType());
		
		for(i=0; i < children.size(); i++)
			startIndex = children.get(i).parse(message, startIndex);
		
		parsedValue = children.get(2).getParsedValue(); // event-type
		children.add(new EventInfo(parsedValue));
		startIndex = children.get(3).parse(message, startIndex);
		
		return startIndex;
	}
}
