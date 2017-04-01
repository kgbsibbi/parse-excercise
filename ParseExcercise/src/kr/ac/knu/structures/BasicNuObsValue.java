package kr.ac.knu.structures;

public class BasicNuObsValue extends Node{
	public BasicNuObsValue(){
		name="BasicNuObsValue";
	}
	
	public BasicNuObsValue(String mean){
		name="BasicNuObsValue";
		parsedString += mean + "=";
	}

	public int parse(char[] message, int startIndex){
		char[] chars = {0,0,0,0};
		System.arraycopy(message, startIndex, chars, 0, 4);
		//System.out.println(chars);
		parsedValue = (Integer.parseInt(String.valueOf(chars), 16));
		parsedString+=String.valueOf(parsedValue);
		startIndex +=4;
		return startIndex;
	}
}
