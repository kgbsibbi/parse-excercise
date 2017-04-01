package kr.ac.knu.structures;

public class AARQ extends Node {
	public AARQ(){
		name="AARQ";
	}
	
	public int parse(char[] message, int startIndex) { 
		children.add(new AssociationVersion());
		children.add(new DataProtoList());
		
		for(int i=0; i < children.size(); i++){
			startIndex = children.get(i).parse(message, startIndex);
		}
		return startIndex;
	}
}
