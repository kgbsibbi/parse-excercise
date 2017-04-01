package kr.ac.knu.structures;

public class PRST extends Node {
	public PRST(){
		name="PRST";
	}
	
	public int parse(char[] message, int startIndex){
		OCTETString octet = new OCTETString();
		children.add(octet);
		startIndex = octet.parseAs(message, startIndex, DataAPDU.class);
		return startIndex;
	}
}
