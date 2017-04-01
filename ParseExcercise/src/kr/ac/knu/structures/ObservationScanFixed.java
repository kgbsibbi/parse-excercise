package kr.ac.knu.structures;

import kr.ac.knu.config.Config;

public class ObservationScanFixed extends Node{
	
	public ObservationScanFixed(){
		name="ObservationScanFixed";
	}
	
	public int parse(char[] message, int startIndex){
		children.add(new INT16("HANDLE"));
		children.add(new INT16("length"));
		startIndex = children.get(0).parse(message, startIndex);
		startIndex = children.get(1).parse(message, startIndex);
		
		parsedValue = children.get(0).getParsedValue(); // handle id
		Class selectedClass = Config.getClass(parsedValue);
		
		// 아래 부분을 수정해야 함. 어떻게?
		OCTETString octet = new OCTETString();
		children.add(octet);
		startIndex = octet.parseAs(message, startIndex, selectedClass);
		return startIndex;
	}
}
