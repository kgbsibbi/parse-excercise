package kr.ac.knu.structures;

public class Message extends Node {
	private Choice choice;
	
	public Message(){
		name="Message";
		choice = new Choice();
		choice.addOption(0x0101, EventReportArgumentSimple.class);
	}
	
	public int parse(char[] message, int startIndex){
		children.add(new INT16("message"));
		startIndex = children.get(0).parse(message, startIndex);
		parsedValue = children.get(0).getParsedValue();
		children.add(new INT16("message.length"));
		startIndex = children.get(1).parse(message, startIndex);
		
		Node node= choice.getSelected(parsedValue);
		if(node != null){
			children.add(node);
			startIndex = children.get(2).parse(message, startIndex);
		}
		return startIndex;
	}
}
