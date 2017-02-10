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
		
		int exponent = result[0];
		int mantissa = result[1] << 16 | result[2] << 8 | result[3];
		
		value = mantissa * Math.pow(10, exponent);
		
		parsedString = infoString = String.valueOf(value);
		//infoString += " ("+mantissa+"x10^"+exponent+")";
		return startIndex;
	}

}
