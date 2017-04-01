package kr.ac.knu.structures;

public class AssociationVersion extends Node {
	
	public AssociationVersion(){
		name="AssociationVersion";
	}
	
	public int parse(char[] message, int startIndex) {
		parsedValue = BitString.getBit(message, startIndex, 8);
		startIndex+=8;
		parsedString = "bit("+parsedValue+")-";
		
		switch(parsedValue){
		case 0:
			parsedString+="Association Protocol Supported";
			break;
		default:
			parsedString+="Association Protocol NOT Supported";
			break;
		}
		
		return startIndex;
	}
}
