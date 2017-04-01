package kr.ac.knu.structures;

public class INTU8 extends Node{
	// Java는 unsigned type을 지원하지 않음.
	// 8bit unsigned는 16bit signed로 처리함.
	//그래서 내부적으로는 그냥 Integer를 사용함.
	public INTU8(){
		name="INT-U8";
	}
	
	public INTU8(String param){
		name="INT-U8";
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
