package kr.ac.knu.structures;

public class EncodingRules extends Node{
	
	public EncodingRules(){
		name="EncodingRules";
	}
	
	public int parse(char[] message, int startIndex) {
		parsedValue = BitString.getBit(message, startIndex, 4);
		startIndex+=4;
		parsedString += "bit(" + parsedValue + "): ";
		
		switch(parsedValue){
		case 0:
		default:
			parsedString += "mder";
			break;
		case 1:
			parsedString += "xer";
			break;
		case 2:
			parsedString += "per";
			break;
		}
		return startIndex;
	}	
}
