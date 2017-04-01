package kr.ac.knu.structures;

public class DataReqMode extends Node {
	
	public DataReqMode(){
		name="DataReqMode";
		parsedString="data-req-";
	}
	
	public int parse(char[] message, int startIndex){
		children.add(new INT16());
		startIndex = children.get(0).parse(message, startIndex);
		parsedValue = children.get(0).getParsedValue();	
		if(parsedValue == 0)
			parsedString += "start";
		else if(parsedValue == 1)
			parsedString += "stop";
		else
			parsedString += "undefined";
		return startIndex;
	}
}
