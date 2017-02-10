package com.kaispring.types;

public class INT8 {
	public static int getValue(int value, boolean isUpper){
		if(isUpper) 
			return value >> 8;
		else
			return value & 0xFF;
	}
}
