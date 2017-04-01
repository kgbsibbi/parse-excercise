package kr.ac.knu.structures;

public class DataProtoList extends Node{
	
	public DataProtoList(){
		name = "DataProtoList";
	}
	
	public int parse(char[] message, int startIndex) {
		children.add(new INT16("data-proto-list.count"));
		children.add(new INT16("data-proto-list.length"));
		startIndex = children.get(0).parse(message, startIndex);
		parsedValue = children.get(0).getParsedValue();
		startIndex = children.get(1).parse(message, startIndex);
		
		for(int i=0; i < parsedValue; i++){
			children.add(new DataProto());
			startIndex = children.get(i+2).parse(message, startIndex);
		}
		
		return startIndex;
	}
}
