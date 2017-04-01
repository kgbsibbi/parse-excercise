package kr.ac.knu.structures;

public class OIDType extends Node {
	public OIDType(){
		name="OIDType";
	}
	
	public int parse(char[] message, int startIndex){
		children.add(new INT16("enent-type"));
		startIndex = children.get(0).parse(message, startIndex);
		parsedValue = children.get(0).getParsedValue();
		return startIndex;
	}
}
