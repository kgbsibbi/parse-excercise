package kr.ac.knu.structures;

public class DataProto extends Node{
	
	public DataProto(){
		name="DataProto";
	}
	
	public int parse(char[] message, int startIndex) {
		children.add(new INT16("data-proto-id"));
		children.add(new INT16("data-proto-length"));
		startIndex = children.get(0).parse(message, startIndex);
		startIndex = children.get(1).parse(message, startIndex);
		
		parsedValue = children.get(0).getParsedValue();
		
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
		
		for(int i=2; i < children.size(); i++){
			startIndex = children.get(i).parse(message, startIndex);
		}
		return startIndex;
	}
}
