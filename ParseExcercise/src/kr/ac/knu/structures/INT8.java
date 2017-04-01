package kr.ac.knu.structures;

public class INT8 extends Node{
	public INT8(){
		name="INT-8";
	}
	
	public INT8(String param){
		name="INT-8";
		parsedString += (param+"=");
	}
	
	public int parse(char[] message, int startIndex){
		char[] chars = {0,0};
		System.arraycopy(message, startIndex, chars, 0, 2);
		parsedValue = (Integer.parseInt(String.valueOf(chars),16));
		parsedString+=String.valueOf(parsedValue);
		startIndex +=2;
		return startIndex;
	}
}
