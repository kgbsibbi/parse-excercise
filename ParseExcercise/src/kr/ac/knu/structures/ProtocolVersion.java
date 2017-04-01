package kr.ac.knu.structures;

public class ProtocolVersion extends Node{
	String versionString;
	
	public ProtocolVersion(){
		name="ProtocolVersion";
	}
	
	public int parse(char[] message, int startIndex) {
		parsedValue = BitString.getBit(message, startIndex, 8);
		startIndex+=8;
		parsedString += "bit(" + parsedValue + "): ";
		
		switch(parsedValue){
		case 0:
			parsedString += "IEEE 11073-20601-2008";
			break;
		case 1:
		default:
			parsedString += "IEEE 11073-20601a-2010";
			break;
		case 2:
			parsedString += "IEEE 11073-20601-2014";
			break;
		}
		
		return startIndex;
	}
}
