package kr.ac.knu.structures.thermometer;

import kr.ac.knu.structures.Node;
import kr.ac.knu.structures.SimpleNuObservedValue;
import kr.ac.knu.structures.TimeStamp;

public class AttrValueMapHandle extends Node{
	public int parse(char[] message, int startIndex){
		children.add(new SimpleNuObservedValue());
		children.add(new TimeStamp());
		
		for(int i=0; i < children.size(); i++){
			startIndex = children.get(i).parse(message, startIndex);
		}
		return startIndex;
	}
}
