package com.kaispring.structures;

public class RejectResult extends Node {
	
	public int parse(int[] message, int startIndex) {
		parsedValue = message[startIndex];
		parsedString="problem="+parsedValue+" ";
		
		switch(parsedValue){
		case 0:
			parsedString+="unrecognized-apdu"; break;
		case 2:
			parsedString+="badlu-structured-apdu";break;
		case 101:
			parsedString+="unrecognozed-operation"; break;
		case 103:
			parsedString+="resource-limitation"; break;
		case 303:
		default:
			parsedString+="unexpected-error"; break;	
		}
		
		startIndex++;
		return startIndex;
	}

}
