package kr.ac.knu.structures;

public class NomenclatureVersion extends Node {
	
	public NomenclatureVersion(){
		name="NomenclatureVersion";
	}
	
	public int parse(char[] message, int startIndex) {
		parsedValue = BitString.getBit(message, startIndex, 8);
		startIndex+=8;
		parsedString += "bit(" + parsedValue + "): ";
		
		if(parsedValue ==0 )
			parsedString+="Nomenclature supported";
		else
			parsedString+="Nomenclature undefined";
		
		return startIndex;
	}
}
