package kr.ac.knu.structures;

public class INT16 extends Node{
	public INT16(){
		name="INT-16";
	}
	
	public INT16(String param){
		name="INT-16";
		parsedString += (param+"=");
	}
	
	public int parse(char[] message, int startIndex){
		char[] chars = {0,0,0,0};
		System.arraycopy(message, startIndex, chars, 0, 4);
		//System.out.println(chars);
		parsedValue = (Integer.parseInt(String.valueOf(chars),16));
		parsedString+=String.valueOf(parsedValue);
		startIndex +=4;
		return startIndex;
	}
}
