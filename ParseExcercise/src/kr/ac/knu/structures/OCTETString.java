package kr.ac.knu.structures;

public class OCTETString extends Node {
	
	public OCTETString(){
		name="OCTETString";
	}

	public int parse(char[] message, int startIndex) {
		children.add(new INT16("length"));
		startIndex = children.get(0).parse(message, startIndex);
		parsedValue=length = children.get(0).getParsedValue();
		
		for(int i=0; i < (length); i++){
			char[] chars = {0,0};
			System.arraycopy(message, startIndex, chars, 0, 2);
			startIndex+=2;
			parsedString+=(char)(Integer.parseInt(String.valueOf(chars),16));
		}
		return startIndex;
	}
	
	public int parseAs(char[] message, int startIndex, Class className){
		if(className != null){
			try{
			children.add((Node)className.newInstance());
			startIndex = children.get(0).parse(message, startIndex);
			}
			catch( InstantiationException ie) { ie.printStackTrace(); }
			catch (  IllegalAccessException ile) { ile.printStackTrace(); }
		}
		
		return startIndex;
	}
}
