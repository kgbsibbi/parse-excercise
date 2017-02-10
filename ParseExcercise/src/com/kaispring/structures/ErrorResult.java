package com.kaispring.structures;

public class ErrorResult extends Node {
	
	public int parse(int[] message, int startIndex) {
		parsedValue = message[startIndex];
		parsedString="error-value="+parsedValue+" ";
		
		switch(parsedValue){
		case 1:
			parsedString+="no-such-object-instance"; break;
		case 9:
			parsedString+="no-such-action";break;
		case 17:
			parsedString+="invalid-object-instance"; break;
		case 23:
			parsedString+="protocol-violation"; break;
		case 24:
			parsedString+="not-allowed-by-object"; break;
		case 25:
			parsedString+="action-timed-out"; break;
		case 26:
			parsedString+="action-aborted"; break;
		case 27:
			parsedString+="unsupported-choice";break;
		case 28:
		default:
			parsedString+="invalid-choice"; break;	
		}
		
		startIndex++;
		return startIndex;
	}

}
