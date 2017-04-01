package kr.ac.knu.structures;

public class AttrValueMapEntry extends Node {
	public AttrValueMapEntry(){
		name="AttrValueMapEntry";
	}
	
	public int parse(char[] message, int startIndex){
		children.add(new OIDType());
		children.add(new INT16("attribute-len"));
		
		for(int i=0; i< children.size(); i++)
			startIndex = children.get(0).parse(message, startIndex);
		
		return startIndex;
	}
}
