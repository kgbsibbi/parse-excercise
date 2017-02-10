package com.kaispring.types;

public class BitString {
	/**
	 * 
	 * @param value   raw data
	 * @param length  bit length 8 or 16, if 32 separate as two numbers
	 * @return index of flagged(non-zero) bit, if none return -1
	 */
	public static int getBit(int value, int length){
		int [] mask = new int[length];
		//int offset = -1;
		//if(length < 16)
		//	offset = -9;
		for(int i=0; i < length; i++){
			mask[i] = 1 << length-i-1;
			if((mask[i] & value) != 0)
				return i;
		}
		return -1;
	}
}
