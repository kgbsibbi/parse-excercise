package com.kaispring.structures;

import java.nio.ByteBuffer;

public class AbsoluteTimeStamp extends Node {
	public int parse(int[] message, int startIndex) { 
		int inputDate = message[startIndex++];
		inputDate = inputDate << 16;
		inputDate += message[startIndex++];
		int inputTime = message[startIndex++];
		inputTime  = inputTime <<16;
		inputTime += message[startIndex++];
		
		ByteBuffer b = ByteBuffer.allocate(4);
		b.putInt(inputDate);
		byte[] result = b.array();
		
		String year = Integer.toHexString(result[0]) + String.format("%02d", Integer.parseInt(Integer.toHexString(result[1])));
		String month = String.format("%02d",  Integer.parseInt(Integer.toHexString(result[2])));
		String day = String.format("%02d",  Integer.parseInt(Integer.toHexString(result[3])));
		
		parsedString = infoString = year+month+day;
		
		b.clear();
		b.putInt(inputTime);
		result = b.array();
		String hour = String.format("%02d",  Integer.parseInt(Integer.toHexString(result[0])));
		String minute = String.format("%02d",  Integer.parseInt(Integer.toHexString(result[1])));
		String second = String.format("%02d",  Integer.parseInt(Integer.toHexString(result[2])));
		String milSecond = String.format("%02d",  Integer.parseInt(Integer.toHexString(result[3])));
		
		parsedString +="T"+hour+":"+minute+":"+second+":"+milSecond;
		infoString = parsedString;
		return startIndex;
	}
}
