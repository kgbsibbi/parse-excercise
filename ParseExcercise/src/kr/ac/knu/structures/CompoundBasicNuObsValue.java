package kr.ac.knu.structures;

import java.util.ArrayList;

public class CompoundBasicNuObsValue extends Node{
	private int count=0;
	private String[] mean;
	public CompoundBasicNuObsValue(){
		name="CompoundBasicNuObsValue";
	}
	
	public CompoundBasicNuObsValue(int count, String[] mean){
		name="CompoundBasicNuObsValue";
		this.count = count;
		this.mean = mean;
		children = new ArrayList<>();
	}
	
	public int parse(char[] message, int startIndex){
		int i=0;
		for(; i < count; i++){
			children.add(new BasicNuObsValue(mean[i]));
			startIndex = children.get(i).parse(message, startIndex);
		}
		children.add(new TimeStamp());
		startIndex=children.get(i).parse(message, startIndex);
		return startIndex;
	}
}
