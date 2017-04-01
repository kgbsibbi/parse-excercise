package kr.ac.knu.structures;

public class SimpleNuObservedValue extends Node {
	// 4byte 숫자 하나만 생성
	public int parse(char[] message, int startIndex){
		double value = 0;
		char[] exp = new char[2];
		char[] man = new char[6];
		for(int i = 0; i < 2; i++)
			exp[i] = message[startIndex++];
		for(int i=0; i < 6; i++)
			man[i] = message[startIndex++];
		
		int exponent = (Integer.parseInt(String.valueOf(exp),16));
		if(exponent > 127) exponent -=256;
		int mantissa = (Integer.parseInt(String.valueOf(man),16));
		value = mantissa * Math.pow(10, exponent);
		//출력 소숫점 자리수
		String format = "%." + Math.abs(exponent) +"f";
		parsedString = String.format(format, value) + " ("+mantissa+"x10^"+exponent+")";
		
		return startIndex;
	}
}
