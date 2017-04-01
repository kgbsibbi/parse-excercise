package kr.ac.knu.structures;

public class AttributeList extends Node {
	int count;
	
	public AttributeList(){
		name = "AttributeList";
	}

	public int parse(char[] message, int startIndex){
		children.add(new INT16("count"));
		children.add(new INT16("length"));
		startIndex = children.get(0).parse(message, startIndex);
		startIndex = children.get(1).parse(message, startIndex);
		parsedValue = children.get(0).getParsedValue();
		length=children.get(1).getParsedValue();
		return startIndex;
	}
}
