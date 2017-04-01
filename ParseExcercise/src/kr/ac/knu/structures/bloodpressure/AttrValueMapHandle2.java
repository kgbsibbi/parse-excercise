package kr.ac.knu.structures.bloodpressure;

import kr.ac.knu.structures.BasicNuObsValue;
import kr.ac.knu.structures.Node;
import kr.ac.knu.structures.TimeStamp;

public class AttrValueMapHandle2 extends Node {
	public AttrValueMapHandle2(){
		name="AttrValueMap";
	}
	
	public int parse(char[] message, int startIndex){
		children.add(new BasicNuObsValue("Pulse"));
		children.add(new TimeStamp());
		
		for(int i=0; i < children.size(); i++){
			startIndex = children.get(i).parse(message, startIndex);
		}
		return startIndex;
	}
}
