package kr.ac.knu.structures;

public class INTU16 extends Node{
	// Java에는 unsigned int type이 없음. 
	// long 형으로 변환하여 큰 수를 출력함.
	private long unsignedParsedValue;
	
	public INTU16(){
		name="INT-U16";
	}
	
	public INTU16(String param){
		name="INT-U16";
		parsedString += (param+"=");
	}

	public int parse(char[] message, int startIndex){
		char[] chars = {0,0,0,0};
		System.arraycopy(message, startIndex, chars, 0, 4);
		parsedValue = (Integer.parseInt(String.valueOf(chars),16));
		unsignedParsedValue = (Integer.parseUnsignedInt(String.valueOf(chars),16));
		// unsigned가 원하는 값.
		parsedString+=String.valueOf(unsignedParsedValue);
		startIndex +=4;
		return startIndex;
	}
	
	public long getUnsignedParsedValue(){
		return (int)unsignedParsedValue;
	}
}
