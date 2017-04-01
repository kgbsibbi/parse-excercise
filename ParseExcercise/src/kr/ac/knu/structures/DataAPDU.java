package kr.ac.knu.structures;

public class DataAPDU extends Node {

	public DataAPDU(){
		name="DataAPDU";
	}
	
	public int parse(char[] message, int startIndex){
		children.add(new INT16("length"));
		children.add(new INT16("invoke-id"));
		children.add(new Message());
		
		for(int i=0; i < children.size(); i++)
			startIndex = children.get(i).parse(message, startIndex);
		return startIndex;
	}
}
