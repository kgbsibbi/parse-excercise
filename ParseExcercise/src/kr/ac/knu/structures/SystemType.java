package kr.ac.knu.structures;

public class SystemType extends Node {
	
	public SystemType(){
		name="SystemType";
	}
	
	public int parse(char[] message, int startIndex) {
		parsedValue = BitString.getBit(message, startIndex, 8);
		startIndex+=8;
		parsedString += "bit(" + parsedValue + "): ";
		
		if(parsedValue == 8 )
			parsedString +="agent";
		else if(parsedValue == 0)
			parsedString +="manager";
		else
			parsedString +="undefined";

		return startIndex;
	}
}
