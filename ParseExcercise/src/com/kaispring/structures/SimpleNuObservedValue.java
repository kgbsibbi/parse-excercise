package com.kaispring.structures;

import java.nio.ByteBuffer;

public class SimpleNuObservedValue extends Node {
	
	// use 2 numbers to parse real number
	public int parse(int[] message, int startIndex){
		double value = 0;
		int input = message[startIndex++];
		input = input << 16;
		input += message[startIndex++];
		
		ByteBuffer b = ByteBuffer.allocate(4);
		b.putInt(input);
		byte[] result = b.array();
		int mantissa = 0;
		// Java가 bit 각각을 signed로 변환하기 때문에
		// 숫자 전체(3bit)로는 음수가 안나와도 하나의 bit로 치면 에서 음수가 생길 수 있음.
		int[] values = { 65536, 256, 1 };
		for(int i=1; i < 4; i++){
			int number = result[i];
			if(number < 0) number+=256;
			mantissa += number*values[i-1];
		}
		int exponent = result[0];
		value = mantissa * Math.pow(10, exponent);
		//출력 소숫점 자리수
		String format = "%." + Math.abs(exponent) +"f";
		parsedString = infoString = String.format(format, value);
		infoString += " ("+mantissa+"x10^"+exponent+")";
		return startIndex;
	}

}
