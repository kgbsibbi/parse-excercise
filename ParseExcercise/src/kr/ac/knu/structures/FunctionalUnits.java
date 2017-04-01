package kr.ac.knu.structures;

public class FunctionalUnits extends Node {
	
	public FunctionalUnits(){
		name="FunctionalUnits";
	}
	
	public int parse(char[] message, int startIndex) {
		parsedValue = BitString.getBit(message, startIndex, 8);
		startIndex+=8;
		parsedString += "bit(" + parsedValue + "): ";
		
		if(parsedValue == 0 )
			parsedString+="fun-units-unindirectional";
		else if(parsedValue == 1 )
			parsedString+="fun-units-havetestcap";
		else if( parsedValue == 2)
			parsedString+="fun-units-createtestassoc";
		else
			parsedString+="undefined";
		
		return startIndex;
	}
}
