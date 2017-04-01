package kr.ac.knu.structures.bloodpressure;

import kr.ac.knu.structures.CompoundBasicNuObsValue;
import kr.ac.knu.structures.INT16;
import kr.ac.knu.structures.Node;

public class AttrValueMapHandle1 extends Node {
	String[] mean = {"Systolic", "Diastolic", "MAP"};
	public AttrValueMapHandle1(){
		name="AttrValueMap";
	}
	
	public int parse(char[] message, int startIndex){
		children.add(new INT16("count"));
		children.add(new INT16("length"));
		
		for(int i=0; i < children.size(); i++)
			startIndex = children.get(i).parse(message, startIndex);
		
		parsedValue = children.get(0).getParsedValue(); // count
		children.add(new CompoundBasicNuObsValue(parsedValue, mean));
		startIndex = children.get(children.size()-1).parse(message, startIndex);
		return startIndex;
	}
}
