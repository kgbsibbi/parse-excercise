package kr.ac.knu.structures;

public class BitString {
	
	public static int getBit(char[] message, int startIndex, int charLength){
		char[] chars = new char[charLength];
		System.arraycopy(message, startIndex, chars, 0, charLength);
		
		long value;
		if(charLength > 4 )
			value = Long.parseLong(new String(chars), 16);
		else
			value = Integer.parseInt(new String(chars), 16);
		
		int bitLength = charLength*4;
		int [] mask = new int[bitLength];
		
		for(int i=0; i < bitLength; i++){
			mask[i] = 1 << bitLength-i-1;
			if((mask[i] & value) != 0)
				return i;
		}
		return -1;
	}
}
