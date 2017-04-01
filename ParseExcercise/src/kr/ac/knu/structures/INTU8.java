package kr.ac.knu.structures;

public class INTU8 extends Node{
	// Java�� unsigned type�� �������� ����.
	// 8bit unsigned�� 16bit signed�� ó����.
	//�׷��� ���������δ� �׳� Integer�� �����.
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
